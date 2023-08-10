package com.example.air_ticket_booking.service.ticket;

import com.example.air_ticket_booking.model.ticket.Ticket;
import com.example.air_ticket_booking.projection.ITicketProjection;
import com.example.air_ticket_booking.projection.ITicketUnbookedProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface ITicketService {
    Page<ITicketProjection> findAllTickets(Pageable pageable);
    Ticket findByIdTicket(Long id);
    boolean deleteTicket(Long id);
    Page<ITicketProjection> searchTicket(Long idTypeTicket,String namePassenger, String nameRoute,  String nameDeparture, String nameDestination, Pageable pageable);
    Page<ITicketUnbookedProjection> findAllTicketUnbooked(Pageable pageable);
    Page<ITicketUnbookedProjection> searchTicketUnbooked(Long idTypeSeat,String positionSeat,String nameRoute, String nameDeparture,String nameDestination,Pageable pageable);
}
