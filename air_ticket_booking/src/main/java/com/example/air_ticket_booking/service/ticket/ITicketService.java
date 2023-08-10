package com.example.air_ticket_booking.service.ticket;

import com.example.air_ticket_booking.dto.ticket.TicketDto;
import com.example.air_ticket_booking.model.ticket.Ticket;

public interface ITicketService {
    /**
     *method :used to create a new ticket when the user confirms the booking
     * created by :NamPC
     * date create: 10/08/2023
     * @param ticketDto
     * return void
     */
    void createNewTicket(TicketDto ticketDto);
}
