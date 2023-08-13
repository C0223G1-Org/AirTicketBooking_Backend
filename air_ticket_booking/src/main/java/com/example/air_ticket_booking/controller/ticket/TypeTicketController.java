package com.example.air_ticket_booking.controller.ticket;

import com.example.air_ticket_booking.model.ticket.TypeTicket;
import com.example.air_ticket_booking.service.ticket.ITypeTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/type-tickets")
public class TypeTicketController {
    @Autowired
    private ITypeTicketService typeTicketService;

    /**
     * method: get ticket type by id
     * created by :NamPC
     * date create: 10/08/2023
     * @param id
     * @return TypeTicket,httpStatus
     */
    @GetMapping("/{id}")
    public ResponseEntity<TypeTicket> getTypeTicketById(@PathVariable Long id){
        TypeTicket typeTicket=typeTicketService.findTypeTicketById(id);
        if (typeTicket ==null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(typeTicket,HttpStatus.OK);
    }
}
