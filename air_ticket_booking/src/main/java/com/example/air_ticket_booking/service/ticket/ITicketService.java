package com.example.air_ticket_booking.service.ticket;

import com.example.air_ticket_booking.model.ticket.Ticket;
import com.example.air_ticket_booking.projection.ITicketPassengerProjection;
import com.example.air_ticket_booking.model.ticket.TicketSearch;
import com.example.air_ticket_booking.projection.ITicketProjection;
import com.example.air_ticket_booking.projection.ITicketUnbookedProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import com.example.air_ticket_booking.dto.ticket.TicketDto;
import com.example.air_ticket_booking.model.customer.Customer;
import com.example.air_ticket_booking.model.luggage.Luggage;
import com.example.air_ticket_booking.model.route.Route;
import com.example.air_ticket_booking.model.seat.Seat;
import com.example.air_ticket_booking.model.ticket.Ticket;
import com.example.air_ticket_booking.model.ticket.TypeTicket;
import com.example.air_ticket_booking.model.type_passenger.TypePassenger;

import java.util.Date;
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
    Page<ITicketPassengerProjection> findTicketByNameAndIdCard(String namePassenger, String idCardPassenger, Pageable pageable);
    /**
     * task get Ticket by id
     *  date create: 10/08/2023
     * @param
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

    Customer findCustomerById(Long id);
    /**
     *Create by: VuDT
     *Date create: 10/08/2023
     * Function:updateTicket()
     * @Param: ticket
     * @Return: void
     */

    void updateTicket(Long id, String name,String email);


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

    /**
     *Create by: ThanhVh
     *Date create: 11/08/2023
     * Function:getListHistoryPayment()
     * @param id,pageable
     * @return Page<Ticket>
     **/
    Page<Ticket> searchAllListPaymentByCustomerById(Long id, Pageable pageable, String departure, String destination);

    void updateTicketByIdTicket(Long id);
}
