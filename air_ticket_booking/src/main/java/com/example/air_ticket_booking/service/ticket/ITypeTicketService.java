package com.example.air_ticket_booking.service.ticket;

import com.example.air_ticket_booking.model.ticket.TypeTicket;

public interface ITypeTicketService {
    /**
     *method :findTypeSeatById()
     * created by :NamPC
     * date create: 10/08/2023
     * @param id
     * return TypeSeat
     */
    TypeTicket findTypeTicketById(Long id);
}
