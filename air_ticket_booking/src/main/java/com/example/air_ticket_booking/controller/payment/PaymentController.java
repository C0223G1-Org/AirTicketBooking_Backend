package com.example.air_ticket_booking.controller.payment;

import com.example.air_ticket_booking.model.paypal.TicketProjection;
import com.example.air_ticket_booking.model.seat.Seat;
import com.example.air_ticket_booking.model.ticket.Ticket;
import com.example.air_ticket_booking.service.customer.ICustomerService;
import com.example.air_ticket_booking.service.seat.ISeatService;
import com.example.air_ticket_booking.service.ticket.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.List;

// ThanhVH
@RestController
@CrossOrigin
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private ITicketService iTicketService;
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private ISeatService iSeatService;

    /**
     * Create by: ThanhVH
     * Date create: 11/08/2023
     * Function:getListHistoryPayment() , updateTicketByIdTicket
     *
     * @param id,pageable
     * @return Page<Ticket> , void
     **/
    @GetMapping("/history/{id}")
    public ResponseEntity<Page<TicketProjection>> getListHistoryPayment(@PathVariable Long id, @PageableDefault(size = 4) Pageable pageable,
                                                                        @RequestParam("departure") String departure, @RequestParam("destination") String destination,
                                                                        @RequestParam("page") String page) {
        int currentPage;
        currentPage = Integer.parseInt(page);
        if (iCustomerService.findCustomerById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else if (currentPage < 0 || departure.length() > 50 || destination.length() > 50) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else if (iTicketService.searchAllListPaymentByCustomerById(id, pageable, departure, destination).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else{
            return new ResponseEntity<>(iTicketService.searchAllListPaymentByCustomerById(id, pageable, departure, destination), HttpStatus.OK);
        }
    }
    @GetMapping("/detail-history/{nameDeparture}/{nameDestination}/{dateBooking}")
    public ResponseEntity<List<Ticket>> getListTicketByNameRoute(@PathVariable("nameDeparture") String nameDeparture, @PathVariable("nameDestination") String nameDestination,
                                                                 @PathVariable("dateBooking") String dateBooking) {
        if(iTicketService.getListTicketByRoute(nameDeparture, nameDestination,dateBooking) ==  null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
                    return new ResponseEntity<>(iTicketService.getListTicketByRoute(nameDeparture, nameDestination,dateBooking),HttpStatus.OK);
        }
    }

    @GetMapping("/payment/{id}/{num}")
    public ResponseEntity<List<Ticket>> getTicketById(@PathVariable Long id, @PathVariable Integer num) {
        if (iCustomerService.findCustomerById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(iTicketService.getListTicketByIdCustomer(id, num),HttpStatus.OK);
    }

    @PatchMapping("/callback/{id}/{message}")
    public ResponseEntity<String> updateTicketByIdTicket(@PathVariable Long id , @PathVariable("message") String paymentStatus) {
        Ticket ticket = iTicketService.findTicketPayment(id);
        Seat seat = iSeatService.findSeatById(ticket.getSeat().getIdSeat());

         if (ticket == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {

            if ("COMPLETED".equals(paymentStatus)) {
                // Thanh toán đã hoàn thành
                seat.setFlagSeat(true);
                iTicketService.updateTicketByIdTicket(id);
                return new ResponseEntity<>(HttpStatus.OK);
            } else if ("CANCELLED".equals(paymentStatus) || "DECLINED".equals(paymentStatus) || "FAILED".equals(paymentStatus)
                    || "EXPIRED".equals(paymentStatus) || "PENDING".equals(paymentStatus)) {
                return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
            }
        }
        return ResponseEntity.ok("Thành công");
    }
}