package com.example.air_ticket_booking.service.ticket;

import com.example.air_ticket_booking.model.ticket.Ticket;

public interface ITicketService {
    /**
     *Create by: VuDT
     *Date create: 10/08/2023
     * Function:findByIdTicket()
     * @Param: ticket
     * @Return: void
     */
    Ticket findByIdTicket(Long id);
}
