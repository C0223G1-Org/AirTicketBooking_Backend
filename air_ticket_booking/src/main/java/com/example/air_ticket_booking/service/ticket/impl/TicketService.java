package com.example.air_ticket_booking.service.ticket.impl;


import com.example.air_ticket_booking.dto.ticket.TicketDto;
import com.example.air_ticket_booking.model.customer.Customer;
import com.example.air_ticket_booking.model.ticket.Ticket;
import com.example.air_ticket_booking.model.ticket.TicketSearch;
import com.example.air_ticket_booking.projection.ITicketProjection;
import com.example.air_ticket_booking.projection.ITicketUnbookedProjection;
import com.example.air_ticket_booking.repository.ticket.ITicketRepository;
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
    public void updateTicket(Long id, String name, String email) {
        ticketRepository.updateTicket(id,name, email);
    }

    /**
     * task get all Ticket booked
     *date create: 10/08/2023
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
     *  date create: 10/08/2023
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

    @Override
    public Customer findCustomerById(Long id) {
        return ticketRepository.findCustomerById(id);
    }


    /**
     * task delete ticket
     *  date create: 10/08/2023
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
     *  date create: 10/08/2023
     * @param
     * @return Page<Ticket>
     * @Method searchTicket
     * @author Nhàn NA
     */
    @Override
    public Page<ITicketProjection> searchTicket(TicketSearch ticketSearch, Pageable pageable) {
        if(ticketSearch.getIdSearch()==1){
//            int typeTicket, String departure, String destination, String departureDate, String destinationDate, String passenger, int idSearch
            if(ticketSearch.getDeparture()==null){
                ticketSearch.setDeparture("");
            }
            if(ticketSearch.getDestination()==null){
                ticketSearch.setDestination("");
            }
            if(ticketSearch.getPassenger()==null){
                ticketSearch.setPassenger("");
            }
            return ticketRepository.searchTicket(ticketSearch,pageable);
        }else if(ticketSearch.getIdSearch()==2){
//            String passenger, String chairCode, int idSearch
            if(ticketSearch.getPassenger()==null){
                ticketSearch.setPassenger("");
            }
            if(ticketSearch.getChairCode()==null){
                ticketSearch.setChairCode("");
            }
            System.out.println(ticketRepository.searchSeatPosition(ticketSearch,pageable).getContent().size());
            return ticketRepository.searchSeatPosition(ticketSearch,pageable);
        }else if(ticketSearch.getIdSearch()==3){
//            String departure, String departureDate, String routeCode, int idSearch
            if(ticketSearch.getRouteCode()==null){
                ticketSearch.setRouteCode("");
            }
            System.out.println(ticketSearch.getRouteCode());
            return ticketRepository.searchRouteTicket(ticketSearch,pageable);
        }else {
            return null;
        }
    }

    /**
     * task get all ticket unbooked
     *  date create: 10/08/2023
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
     *  date create: 10/08/2023
     * @param
     * @return Page<Ticket>
     * @Method searchTicketUnbooked
     * @author Nhàn NA
     */
    @Override
    public Page<ITicketUnbookedProjection> searchTicketUnbooked(TicketSearch ticketSearch, Pageable pageable) {
        try {
            if(ticketSearch.getChairCode()==null){
                ticketSearch.setChairCode("");
            }
            if(ticketSearch.getRouteCode()==null){
                ticketSearch.setRouteCode("");
            }
            return ticketRepository.searchTicketUnbooked(ticketSearch, pageable);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Lỗi khi truy vấn dữ liệu từ database", e);
        }
    }

    @Override
    public Page<Ticket> searchAllListPaymentByCustomerById(Long id, Pageable pageable,String departure,String destination) {
        return ticketRepository.searchAllListPaymentByCustomerById(id,pageable,departure, destination);
    }

    @Override
    public void updateTicketByIdTicket(Long id) {
        ticketRepository.updateTicketByIdTicket(id);
    }


}