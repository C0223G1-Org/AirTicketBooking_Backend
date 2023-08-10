package com.example.air_ticket_booking.controller.ticket;

import com.example.air_ticket_booking.service.ticket.ITypeTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TypeTicketController {
    @Autowired
    private ITypeTicketService typeTicketService;
}
