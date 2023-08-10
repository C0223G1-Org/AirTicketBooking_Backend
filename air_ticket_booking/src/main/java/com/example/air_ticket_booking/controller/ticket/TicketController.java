package com.example.air_ticket_booking.controller.ticket;

import com.example.air_ticket_booking.dto.ticket.TicketDto;
import com.example.air_ticket_booking.model.customer.Customer;
import com.example.air_ticket_booking.model.luggage.Luggage;
import com.example.air_ticket_booking.model.seat.Seat;
import com.example.air_ticket_booking.model.ticket.Ticket;
import com.example.air_ticket_booking.model.ticket.TypeTicket;
import com.example.air_ticket_booking.model.type_passenger.TypePassenger;
import com.example.air_ticket_booking.service.ticket.ITicketService;
import com.example.air_ticket_booking.service.ticket.impl.TicketService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
@CrossOrigin("*")
public class TicketController {
    @Autowired
    private TicketService ticketService;
    /**
     *Create by: VuDT
     *Date create: 10/08/2023
     * Function:getTicketById()
     * @Param: ticketDto
     * @Return: void
     */
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id){
        Ticket ticket= this.ticketService.findByIdTicket(id);
        if(ticket == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ticket,HttpStatus.OK);
    }
    /**
     *Create by: VuDT
     *Date create: 10/08/2023
     * Function:updateTicket()
     * @Param: ticketDto
     * @Return: void
     */

    @PutMapping("/updateTicket/{id}")

    public ResponseEntity<?> updateTicket(@PathVariable Long id,@RequestBody TicketDto ticketDto, BindingResult bindingResult ) {
        ticketDto.validate(ticketDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Lỗi validation");
        }

        Ticket existingTicket = ticketService.findByIdTicket(id);
        if (existingTicket == null) {
            return ResponseEntity.notFound().build();
        }

        Long price = ticketDto.getPriceTicket();
        Boolean flag = ticketDto.getFlagTicket();
        String name = ticketDto.getNamePassenger();
        Boolean gender = ticketDto.getGenderPassenger();
        String email = ticketDto.getEmailPassenger();
        String tel = ticketDto.getTelPassenger();
        String idCard = ticketDto.getIdCardPassenger();
        String dateBooking = ticketDto.getDateBooking();
        TypeTicket typeTicket = ticketDto.getTypeTicket();
        Luggage luggage = ticketDto.getLuggage();
        TypePassenger typePassenger = ticketDto.getTypePassenger();
        Seat seat = ticketDto.getSeat();
        Customer customer = ticketDto.getCustomer();

        ticketService.updateTicket(id, price, flag, name, gender, email, tel, idCard, dateBooking, typeTicket, luggage, typePassenger, seat, customer);

        return ResponseEntity.ok("Cập nhật vé thành công");
    }

}
