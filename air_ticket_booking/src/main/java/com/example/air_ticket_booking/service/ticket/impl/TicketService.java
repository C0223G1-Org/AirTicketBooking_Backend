package com.example.air_ticket_booking.service.ticket.impl;


import com.example.air_ticket_booking.dto.ticket.TicketDto;
import com.example.air_ticket_booking.model.customer.Customer;
import com.example.air_ticket_booking.model.luggage.Luggage;
import com.example.air_ticket_booking.model.seat.Seat;
import com.example.air_ticket_booking.model.ticket.Ticket;
import com.example.air_ticket_booking.model.ticket.TypeTicket;
import com.example.air_ticket_booking.model.type_passenger.TypePassenger;
import com.example.air_ticket_booking.projection.ITicketProjection;
import com.example.air_ticket_booking.projection.ITicketUnbookedProjection;
import com.example.air_ticket_booking.repository.ticket.ITicketRepository;
import com.example.air_ticket_booking.repository.ticket.ITypeTicketRepository;
import com.example.air_ticket_booking.service.ticket.ITicketService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TicketService implements ITicketService {
    @Autowired
    private ITicketRepository ticketRepository;

    /**
     * method :findTicketByNameAndIdCardPassengers()
     * created by : KietNT
     * date create: 10/08/2023
     *
     * @param namePassenger,idCardPassenger return List Ticket
     */
    @Override
    public List<Ticket> findTicketByNameAndIdCard(String namePassenger, String idCardPassenger) {
        return ticketRepository.findTicketByNameAndIdCardPassengers(namePassenger, idCardPassenger);
    }

    /**
     * method :used to create a new ticket when the user confirms the booking
     * created by :NamPC
     * date create: 10/08/2023
     *
     * @param "ticketDto" return void
     */

    @Override
    public void createNewTicket(TicketDto ticketDto) {
        Ticket ticket = new Ticket();
        BeanUtils.copyProperties(ticketDto, ticket);
        ticket.setPriceTicket(ticket.getLuggage().getPriceLuggage() + ticket.getSeat().getTypeSeat().getPriceExtra() * ticket.getSeat().getRoute().getPriceRoute());
        ticketRepository.createNewTicket(ticket);
    }

    /**
     * Create by: VuDT
     * Date create: 10/08/2023
     * Function:updateTicket()
     *
     * @Param: ticket
     * @Return: void
     */
    @Transactional
    public void updateTicket(Long id, Long price, Boolean flag, String name, Boolean gender, String email, String tel, String idCard,
                             String dateBooking, TypeTicket typeTicket, Luggage luggage, TypePassenger typePassenger, Seat seat, Customer customer) {
        ticketRepository.updateTicket(id, price, flag, name, gender, email, tel, idCard, dateBooking, typeTicket, luggage, typePassenger, seat, customer);
    }

    /**
     * task get all Ticket booked
     *
     * @param pageable
     * @return Page<Ticket>
     * @Method findAllTickets
     * @author Nhàn NA
     */
    @Override
    public Page<ITicketProjection> findAllTickets(Pageable pageable) {
        try {
            return ticketRepository.findAllTickets(pageable);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Lỗi khi truy vấn dữ liệu từ database", e);
        }
    }

    /**
     * task get Ticket by id
     *
     * @param id
     * @return Ticket or null
     * @Method findByTicket
     * @author Nhàn NA
     */
    @Override
    public Ticket findByIdTicket(Long id) {
        if (ticketRepository.findByTicket(id).isPresent()) {
            return ticketRepository.findByTicket(id).get();
        }
        return null;
    }

    /**
     * task delete ticket
     *
     * @param id
     * @return boolean
     * @Method findByTicket
     * @author Nhàn NA
     */

    @Override
    public boolean deleteTicket(Long id) {
        if (findByIdTicket(id) != null) {
            ticketRepository.deleteTicketById(id);
            return true;
        }
        return false;
    }

    /**
     * task search ticket
     *
     * @param idTypeTicket, namePassenger, nameRoute,  nameDeparture, nameDestination,pageable
     * @return Page<Ticket>
     * @Method searchTicket
     * @author Nhàn NA
     */
    @Override
    public Page<ITicketProjection> searchTicket(Long idTypeTicket, String namePassenger, String nameRoute, String nameDeparture, String nameDestination, Pageable pageable) {
        try {
//            return ticketRepository.searchTicket(idTypeTicket, namePassenger, nameRoute, nameDeparture, nameDestination, pageable);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Lỗi khi truy vấn dữ liệu từ database", e);
        }
    }

    /**
     * task get all ticket unbooked
     *
     * @param pageable
     * @return Page<Ticket>
     * @Method findAllTicketUnbooked
     * @author Nhàn NA
     */
    @Override
    public Page<ITicketUnbookedProjection> findAllTicketUnbooked(Pageable pageable) {
        try {
            return ticketRepository.findAllTicketUnbooked(pageable);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Lỗi khi truy vấn dữ liệu từ database", e);
        }
    }

    /**
     * task search ticket unbooked
     *
     * @param idTypeSeat,positionSeat,nameRoute,nameDeparture,nameDestination,pageable
     * @return Page<Ticket>
     * @Method searchTicketUnbooked
     * @author Nhàn NA
     */
    @Override
    public Page<ITicketUnbookedProjection> searchTicketUnbooked(Long idTypeSeat, String positionSeat, String nameRoute, String nameDeparture, String nameDestination, Pageable pageable) {
        try {
//            return ticketRepository.searchTicketUnbooked(idTypeSeat, positionSeat, nameRoute, nameDeparture, nameDestination, pageable);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Lỗi khi truy vấn dữ liệu từ database", e);
        }
    }
}