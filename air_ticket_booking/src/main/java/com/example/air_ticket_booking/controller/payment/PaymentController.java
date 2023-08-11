package com.example.air_ticket_booking.controller.payment;

import com.example.air_ticket_booking.model.customer.Customer;
import com.example.air_ticket_booking.model.paypal.PayPalResponse;
import com.example.air_ticket_booking.model.seat.Seat;
import com.example.air_ticket_booking.model.ticket.Ticket;
import com.example.air_ticket_booking.service.customer.ICustomerService;
import com.example.air_ticket_booking.service.seat.ISeatService;
import com.example.air_ticket_booking.service.ticket.ITicketService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

//    @Value("${paypal.clientId}")
//    private String clientId;
//
//    @Value("${paypal.clientSecret}")
//    private String clientSecret;
    /**
     *Create by: ThanhVh
     *Date create: 11/08/2023
     * Function:getListHistoryPayment() , updateTicketByIdTicket
     * @param id,pageable
     * @return Page<Ticket> , void
     **/
    @GetMapping("/history/{id}")
    public ResponseEntity<Page<Ticket>>  getListHistoryPayment(@PathVariable Long id, Pageable pageable) {
        if (iCustomerService.findCustomerById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(iTicketService.findAllListPaymentByCustomerById(id,pageable),HttpStatus.OK);
        }
    }

    @PutMapping("/callback/{id}")
    public ResponseEntity<String> updateTicketByIdTicket(@PathVariable Long id) {
//        Chuyển đổi JSON thành đối tượng Java
        Gson gson = new Gson();
        if (iTicketService.findByIdTicket(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            Ticket ticket = iTicketService.findByIdTicket(id);
            // Chuyển đổi đối tượng ticket thành chuỗi JSON
            String ticketJson = gson.toJson(ticket);
            // Chuyển đổi chuỗi JSON thành đối tượng PayPalResponse
            PayPalResponse response = gson.fromJson(ticketJson, PayPalResponse.class);

            String paymentStatus = response.getStatus();
            Seat seat = iSeatService.findSeatById(ticket.getSeat().getIdSeat());
            seat.setFlagSeat(true);
            if ("COMPLETED".equals(paymentStatus)) {
                // Thanh toán đã hoàn thành
                iTicketService.updateTicketByIdTicket(id);
                return new ResponseEntity<>(HttpStatus.OK);
            } else if ("CANCELLED".equals(paymentStatus)) {
                return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
            }
        }
        return ResponseEntity.ok("Thành công");
    }
}