package com.example.air_ticket_booking.service.ticket.impl;

import com.example.air_ticket_booking.model.ticket.TypeTicket;
import com.example.air_ticket_booking.repository.ticket.ITypeTicketRepository;
import com.example.air_ticket_booking.service.ticket.ITypeTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeTicketService implements ITypeTicketService {
    @Autowired
    private ITypeTicketRepository typeTicketRepository;

    @Override
    public List<TypeTicket> showListTypeTicket() {
        return typeTicketRepository.findAllTypeTicket();
    }
}
