/**
 *method :findTicketByNameAndIdCardPassengers()
 * created by :KietNT
 * date create: 10/08/2023
 * @param namePassenger,idCardPassenger
 * return List Ticket
 */
package com.example.air_ticket_booking.service.ticket.impl;

import com.example.air_ticket_booking.model.ticket.Ticket;
import com.example.air_ticket_booking.repository.ticket.ITicketRepository;
import com.example.air_ticket_booking.repository.ticket.ITypeTicketRepository;
import com.example.air_ticket_booking.service.ticket.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService implements ITicketService {
    @Autowired
    private ITicketRepository ticketRepository;
    @Override
    public List<Ticket> findTicketByNameAndIdCard(String namePassenger, String idCardPassenger) {
        return ticketRepository.findTicketByNameAndIdCardPassengers(namePassenger,idCardPassenger);
    }
}
