package com.example.air_ticket_booking.repository.ticket;

import com.example.air_ticket_booking.model.ticket.TypeTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypeTicketRepository extends JpaRepository<TypeTicket,Long> {
}