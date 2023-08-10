package com.example.air_ticket_booking.service.ticket.impl;

import com.example.air_ticket_booking.model.customer.Customer;
import com.example.air_ticket_booking.model.luggage.Luggage;
import com.example.air_ticket_booking.model.seat.Seat;
import com.example.air_ticket_booking.model.ticket.Ticket;
import com.example.air_ticket_booking.model.ticket.TypeTicket;
import com.example.air_ticket_booking.model.type_passenger.TypePassenger;
import com.example.air_ticket_booking.repository.ticket.ITicketRepository;
import com.example.air_ticket_booking.service.ticket.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TicketService implements ITicketService {

    @Autowired
    private ITicketRepository ticketRepository;
    /**
     *Create by: VuDT
     *Date create: 10/08/2023
     * Function:updateTicket()
     * @Param: ticket
     * @Return: void
     */
    @Transactional
    public void updateTicket(Long id, Long price, Boolean flag, String name, Boolean gender, String email, String tel, String idCard,
                             String dateBooking, TypeTicket typeTicket, Luggage luggage, TypePassenger typePassenger, Seat seat, Customer customer) {
        ticketRepository.updateTicket(id, price, flag, name, gender, email, tel, idCard, dateBooking, typeTicket, luggage, typePassenger, seat, customer);
    }
    /**
     *Create by: VuDT
     *Date create: 10/08/2023
     * Function:findByIdTicket()
     * @Param: ticket
     * @Return: void
     */
    @Override
    public Ticket findByIdTicket(Long id) {

        return ticketRepository.findTicketById(id);
    }
}
