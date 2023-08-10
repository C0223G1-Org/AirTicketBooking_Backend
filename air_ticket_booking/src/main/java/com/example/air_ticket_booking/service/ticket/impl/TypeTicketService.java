package com.example.air_ticket_booking.service.ticket.impl;

import com.example.air_ticket_booking.model.ticket.TypeTicket;
import com.example.air_ticket_booking.repository.ticket.ITypeTicketRepository;
import com.example.air_ticket_booking.service.ticket.ITypeTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeTicketService implements ITypeTicketService {
    @Autowired
    private ITypeTicketRepository iTypeTicketRepository;
    /**
     *method :find  type ticket by id in service
     * created by :NamPC
     * date create: 10/08/2023
     * @param id
     * return Type ticket
     */

    @Override
    public TypeTicket findTypeTicketById(Long id) {
        return iTypeTicketRepository.findTypeTicketById(id);
    }
}
