package com.example.air_ticket_booking.service.ticket;

import com.example.air_ticket_booking.model.ticket.TypeTicket;

public interface ITypeTicketService {
    /**
     *method :find  type ticket  by id in service
     * created by :NamPC
     * date create: 10/08/2023
     * @param id
     * return Type ticket
     */
    TypeTicket findTypeTicketById(Long id);
}
