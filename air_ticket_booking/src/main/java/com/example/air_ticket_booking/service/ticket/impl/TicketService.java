package com.example.air_ticket_booking.service.ticket.impl;


import com.example.air_ticket_booking.dto.ticket.TicketDto;
import com.example.air_ticket_booking.model.ticket.Ticket;
import com.example.air_ticket_booking.repository.ticket.ITicketRepository;
import com.example.air_ticket_booking.repository.ticket.ITypeTicketRepository;
import com.example.air_ticket_booking.service.ticket.ITicketService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService implements ITicketService {
    @Autowired
    private ITicketRepository ticketRepository;
    /**
     *method :findTicketByNameAndIdCardPassengers()
     * created by : KietNT
     * date create: 10/08/2023
     * @param namePassenger,idCardPassenger
     * return List Ticket
     */
    @Override
    public List<Ticket> findTicketByNameAndIdCard(String namePassenger, String idCardPassenger) {
        return ticketRepository.findTicketByNameAndIdCardPassengers(namePassenger,idCardPassenger);
    }
    /**
     * method :used to create a new ticket when the user confirms the booking
     * created by :NamPC
     * date create: 10/08/2023
     * @param "ticketDto"
     * return void
     */

    @Override
    public void createNewTicket(TicketDto ticketDto) {
        Ticket ticket = new Ticket();
        BeanUtils.copyProperties(ticketDto, ticket);
        ticket.setPriceTicket(ticket.getLuggage().getPriceLuggage() + ticket.getSeat().getTypeSeat().getPriceExtra() * ticket.getSeat().getRoute().getPriceRoute());
        ticketRepository.createNewTicket(ticket);
    }
}

