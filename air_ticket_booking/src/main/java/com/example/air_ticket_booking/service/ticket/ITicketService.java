package com.example.air_ticket_booking.service.ticket;

import com.example.air_ticket_booking.model.ticket.Ticket;

import java.util.List;

public interface ITicketService {
    List<Ticket> findTicketByNameAndIdCard(String namePassenger, String idCardPassenger);
}
