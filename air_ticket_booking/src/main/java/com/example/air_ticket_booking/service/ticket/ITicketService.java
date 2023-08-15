package com.example.air_ticket_booking.service.ticket;

import com.example.air_ticket_booking.model.ticket.Ticket;
import com.example.air_ticket_booking.model.ticket.TicketSearch;
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
    /**
     * task get Ticket by id
     *  date create: 10/08/2023
     * @param id
     * @return Ticket or null
     * @Method findByTicket
     * @author Nhàn NA
     */
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
    /**
     * task delete ticket
     *  date create: 10/08/2023
     * @param id
     * @return boolean
     * @Method findByTicket
     * @author Nhàn NA
     */

    boolean deleteTicket(Long id);
    /**
     * task search ticket
     *  date create: 10/08/2023
     * @param idTypeTicket, namePassenger, nameRoute,  nameDeparture, nameDestination,pageable
     * @return Page<Ticket>
     * @Method searchTicket
     * @author Nhàn NA
     */
    Page<ITicketProjection> searchTicket(TicketSearch ticketSearch, Pageable pageable);
    /**
     * task get all ticket unbooked
     *  date create: 10/08/2023
     * @param pageable
     * @return Page<Ticket>
     * @Method findAllTicketUnbooked
     * @author Nhàn NA
     */
    Page<ITicketUnbookedProjection> findAllTicketUnbooked(Pageable pageable);
    /**
     * task search ticket unbooked
     *  date create: 10/08/2023
     * @param idTypeSeat,positionSeat,nameRoute,nameDeparture,nameDestination,pageable
     * @return Page<Ticket>
     * @Method searchTicketUnbooked
     * @author Nhàn NA
     */
    Page<ITicketUnbookedProjection> searchTicketUnbooked(Long idTypeSeat,String positionSeat,String nameRoute, String nameDeparture,String nameDestination,Pageable pageable);
}
