package com.example.air_ticket_booking.service.ticket.impl;

import com.example.air_ticket_booking.model.ticket.Ticket;
import com.example.air_ticket_booking.projection.ITicketProjection;
import com.example.air_ticket_booking.projection.ITicketUnbookedProjection;
import com.example.air_ticket_booking.repository.ticket.ITicketRepository;
import com.example.air_ticket_booking.service.ticket.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public class TicketService implements ITicketService {
    @Autowired
    private  ITicketRepository ticketRepository;
    /**
     * task get all Ticket booked
     * @Method findAllTickets
     * @param pageable
     * @return Page<Ticket>
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
     * @Method findByTicket
     * @param id
     * @return Ticket or null
     * @author Nhàn NA
     */
    @Override
    public Ticket findByIdTicket(Long id) {
        if(ticketRepository.findByTicket(id).isPresent()){
            return ticketRepository.findByTicket(id).get();
        }
        return null;
    }
    /**
     * task delete ticket
     * @Method findByTicket
     * @param id
     * @return boolean
     * @author Nhàn NA
     */

    @Override
    public boolean deleteTicket(Long id) {
        if(findByIdTicket(id)!=null){
            ticketRepository.deleteTicketById(id);
            return true;
        }
        return false;
    }
    /**
     * task search ticket
     * @Method searchTicket
     * @param idTypeTicket, namePassenger, nameRoute,  nameDeparture, nameDestination,pageable
     * @return Page<Ticket>
     * @author Nhàn NA
     */
    @Override
    public Page<ITicketProjection> searchTicket(Long idTypeTicket, String namePassenger, String nameRoute, String nameDeparture, String nameDestination, Pageable pageable) {
        try {
            return ticketRepository.searchTicket(idTypeTicket, namePassenger, nameRoute,  nameDeparture, nameDestination,pageable);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Lỗi khi truy vấn dữ liệu từ database", e);
        }
    }
    /**
     * task get all ticket unbooked
     * @Method findAllTicketUnbooked
     * @param pageable
     * @return Page<Ticket>
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
     * @Method searchTicketUnbooked
     * @param idTypeSeat,positionSeat,nameRoute,nameDeparture,nameDestination,pageable
     * @return Page<Ticket>
     * @author Nhàn NA
     */
    @Override
    public Page<ITicketUnbookedProjection> searchTicketUnbooked(Long idTypeSeat, String positionSeat, String nameRoute, String nameDeparture, String nameDestination, Pageable pageable) {
        try {
            return ticketRepository.searchTicketUnbooked(idTypeSeat,positionSeat,nameRoute,nameDeparture,nameDestination,pageable);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Lỗi khi truy vấn dữ liệu từ database", e);
        }
    }
}
