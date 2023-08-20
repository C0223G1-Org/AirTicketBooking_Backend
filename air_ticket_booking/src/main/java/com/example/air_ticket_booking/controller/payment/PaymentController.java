package com.example.air_ticket_booking.controller.payment;

import com.example.air_ticket_booking.model.customer.Customer;
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
import org.springframework.security.access.prepost.PreAuthorize;
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
    @Autowired
    private JavaMailSender mailSender;

    /**
     * Create by: ThanhVH
     * Date create: 11/08/2023
     * Function:getListHistoryPayment() , updateTicketByIdTicket
     *
     * @param id,pageable
     * @return Page<Ticket> , void
     **/
    @GetMapping("/history/{id}")
    @PreAuthorize("hasAnyRole('ROLE_CUSTOMER')")
    public ResponseEntity<Page<Ticket>> getListHistoryPayment(@PathVariable Long id, @PageableDefault(size = 4) Pageable pageable,
                                                              @RequestParam("departure") String departure, @RequestParam("destination") String destination,
                                                              @RequestParam("page") String page) {
        int currentPage;
        currentPage = Integer.parseInt(page);
        if (iCustomerService.findCustomerById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else if (currentPage < 0 || departure.length() > 50 || destination.length() > 50) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(iTicketService.searchAllListPaymentByCustomerById(id, pageable, departure, destination), HttpStatus.OK);
        }

    }

    @GetMapping("/payment/{id}")
    public ResponseEntity<List<Ticket>> getTicketById(@PathVariable Long id) {
        if (iCustomerService.findCustomerById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(iTicketService.getListTicketByIdCustomer(id),HttpStatus.OK);
    }

    @PatchMapping("/callback/{id}/{message}")
    public ResponseEntity<String> updateTicketByIdTicket(@PathVariable Long id , @PathVariable("message") String paymentStatus) {
        Ticket ticket = iTicketService.findTicketPayment(id);
//        Seat seat = iSeatService.findSeatById(ticket.getSeat().getIdSeat());

         if (ticket == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
        System.out.print(id);
            if ("COMPLETED".equals(paymentStatus)) {
                // Thanh toán đã hoàn thành
//                seat.setFlagSeat(true);
//                sendEmail(id);
//                for (Long id1: id) {
//                    iTicketService.updateTicketByIdTicket(id1);
//                }
                iTicketService.updateTicketByIdTicket(id);
                return new ResponseEntity<>(HttpStatus.OK);
            } else if ("CANCELLED".equals(paymentStatus) || "DECLINED".equals(paymentStatus) || "FAILED".equals(paymentStatus)
                    || "EXPIRED".equals(paymentStatus) || "PENDING".equals(paymentStatus)) {
                return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
            }
        }
        return ResponseEntity.ok("Thành công");
    }

//    public void sendEmail( Long id) throws MessagingException, UnsupportedEncodingException {
//
//        Customer customer = iCustomerService.findCustomerById(id);
//        if (iCustomerService.findCustomerById(id) == null) {
//            new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            return;
//        }
//        List<Ticket> listTicket = iTicketService.getListTicketByIdCustomer(id);
//        StringBuilder contentBuilder = new StringBuilder();
//        String toAddress = customer.getEmailCustomer();
//        String fromAddress = "vohaithanh21@gmail.com";
//        String senderName = "Codegym Airline";
//        String subject = "[CodeGym Airline] Vé Điện Tử Codegym Airlines Của Quý Khách ";
//        String content = "<body style=\"font-family: Diavlo, sans-seriff\">\n" +
//                "<div class=\"ticket\" style=\"max-width: 600px;\n" +
//                "    margin: 50px auto;\n" +
//                "    padding: 30px;\n" +
//                "    background-color: white;\n" +
//                "    border: 5px solid #0055a3;\n" +
//                "    border-radius: 10px;\n" +
//                "    box-shadow: 0px 0px 10px #888888;\">\n" +
//                "    <div class=\"row\" style=\" display: flex;\n" +
//                "    justify-content: space-between;\n" +
//                "    margin-bottom: 10px;\">\n" +
//                "        <div class=\"col-6\" style=\"margin-top: 25px\">logo</div>\n" +
//                "        <div class=\"col-6\">\n" +
//                "            <h1 class=\"title\" style=\"text-align: center;\n" +
//                "    font-size: 24px;\n" +
//                "    margin-bottom: 26px;\n" +
//                "    color: #0055a3;\n" +
//                "margin-right: 44px\">CHI TIẾT VÉ</h1>\n" +
//                "        </div>\n" +
//                "    </div>\n" +
//                "    <div class=\"row\" style=\" display: flex;\n" +
//                "    justify-content: space-between;\n" +
//                "    margin-bottom: 10px;\">\n" +
//                "        <div class=\"col-4\">\n" +
//                "            <p class=\"label\" style=\" font-weight: bold;\">Danh sách người đi:</p>\n";
//        String name;
//        for (Ticket ticket: listTicket) {
//            name = "<p>" + ticket.getNamePassenger() + "</p>\n";
//            contentBuilder.append(name);
//        }
//        content+=
//                "        </div>\n" +
//                "        <div class=\"col-8\" style=\"margin-right: 100px; margin-top: 5px\">\n" +
//                "            <p class=\"label\" style=\" font-weight: bold; \">Mã đặt chỗ:</p>\n" +
//                "            <p class=\"value\">aaaaaa</p>\n" +
//                "\n" +
//                "        </div>\n" +
//                "    </div>\n" +
//                "    <div class=\"row\">\n" +
//                "        <p class=\"route\" style=\"font-weight: bold; font-size: 20px\">Nơi đi</p>\n" +
//                "    </div>\n" +
//                "    <div class=\"row\" style=\" display: flex;\n" +
//                "    justify-content: space-between;\n" +
//                "    margin-bottom: 10px;\">\n" +
//                "        <div class=\"col-3\">\n" +
//                "            <p class=\"label\" style=\" font-weight: bold;\">Nơi đi:</p>\n" +
//                "            <p class=\"value\">Hồ Chí Minh</p>\n" +
//                "        </div>\n" +
//                "        <div class=\"col-3\">\n" +
//                "            <p class=\"label\" style=\" font-weight: bold;\">Nơi đến:</p>\n" +
//                "            <p class=\"value\">Đà Nẵng</p>\n" +
//                "        </div>\n" +
//                "        <div class=\"col-3\">\n" +
//                "            <p class=\"label\" style=\" font-weight: bold;\">Giờ bay:</p>\n" +
//                "            <p class=\"value\">15:30 PM</p>\n" +
//                "        </div>\n" +
//                "        <div class=\"col-3\">\n" +
//                "            <p class=\"label\" style=\" font-weight: bold;\">Giờ đến:</p>\n" +
//                "            <p class=\"value\">17:00 PM</p>\n" +
//                "        </div>\n" +
//                "    </div>\n" +
//                "    <div class=\"row\" style=\" display: flex;\n" +
//                "    justify-content: space-between;\n" +
//                "    margin-bottom: 10px;\">\n" +
//                "        <div class=\"col-3\">\n" +
//                "            <p class=\"label\" style=\" font-weight: bold;\">SGN-DAN:</p>\n" +
//                "            <p class=\"value\">ABC123</p>\n" +
//                "        </div>\n" +
//                "        <div class=\"col-3\">\n" +
//                "            <p class=\"label\" style=\" font-weight: bold;\">Ngày đi:</p>\n" +
//                "            <p class=\"value\">14/08/2023</p>\n" +
//                "        </div>\n" +
//                "        <div class=\"col-3\">\n" +
//                "            <p class=\"label\" style=\" font-weight: bold;\">Ngày đến:</p>\n" +
//                "            <p class=\"value\">14/08/2023</p>\n" +
//                "        </div>\n" +
//                "        <div class=\"col-3\">\n" +
//                "            <p class=\"label\" style=\" font-weight: bold;\">Tiền vé:</p>\n" +
//                "            <p class=\"value\" value=\"700000\" style=\"width: 130px\">700,000 VND</p>\n" +
//                "        </div>\n" +
//                "    </div>\n" +
//                "</div>\n" +
//                "\n" +
//                "</body>";
//        MimeMessage message = mailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message);
//        helper.setFrom(fromAddress, senderName);
//        helper.setTo(toAddress);
//        helper.setSubject(subject);
//        helper.setText(content, true);
//        mailSender.send(message);
//    }
}