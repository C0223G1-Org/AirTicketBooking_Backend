package com.example.air_ticket_booking.service.ticket;

import com.example.air_ticket_booking.model.ticket.Ticket;
import com.example.air_ticket_booking.projection.ITicketProjection;
import com.example.air_ticket_booking.projection.ITicketUnbookedProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import com.example.air_ticket_booking.dto.ticket.TicketDto;
import com.example.air_ticket_booking.model.ticket.Ticket;

import java.util.List;

public interface ITicketService {
    

    /**
     *method :used to create a new ticket when the user confirms the booking
     * created by :NamPC
     * date create: 10/08/2023
     * @param ticketDto
     * return void
     */
    void createNewTicket(TicketDto ticketDto);
    List<Ticket> findTicketByNameAndIdCard(String namePassenger, String idCardPassenger);
    /**
     *Create by: VuDT
     *Date create: 10/08/2023
     * Function:findByIdTicket()
     * @Param: ticket
     * @Return: void
     */
    Ticket findByIdTicket(Long id);
    Page<ITicketProjection> findAllTickets(Pageable pageable);

    boolean deleteTicket(Long id);
    Page<ITicketProjection> searchTicket(Long idTypeTicket,String namePassenger, String nameRoute,  String nameDeparture, String nameDestination, Pageable pageable);
    Page<ITicketUnbookedProjection> findAllTicketUnbooked(Pageable pageable);
    Page<ITicketUnbookedProjection> searchTicketUnbooked(Long idTypeSeat,String positionSeat,String nameRoute, String nameDeparture,String nameDestination,Pageable pageable);
}
