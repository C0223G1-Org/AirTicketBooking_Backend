package com.example.air_ticket_booking.controller.ticket;

import com.example.air_ticket_booking.dto.ticket.TicketDto;
import com.example.air_ticket_booking.model.luggage.Luggage;
import com.example.air_ticket_booking.model.ticket.Ticket;
import com.example.air_ticket_booking.service.luggage.ILuggageService;
import com.example.air_ticket_booking.service.ticket.ITicketService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    private ITicketService iTicketService;

    /**
     * method: used to create a new ticket when the user confirms the booking
     * created by :NamPC
     * date create: 10/08/2023
     * @param ticketDto
     * @param bindingResult
     * @return httpStatus
     */

    @PostMapping()
    public ResponseEntity<?> createNewTicket(@RequestBody TicketDto ticketDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        iTicketService.createNewTicket(ticketDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

