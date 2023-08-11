package com.example.air_ticket_booking.service.seat.impl;

import com.example.air_ticket_booking.model.projection_tdns.SeatProjection;
import com.example.air_ticket_booking.model.seat.Seat;
import com.example.air_ticket_booking.repository.seat.ISeatRepository;
import com.example.air_ticket_booking.service.seat.ISeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService implements ISeatService {
    @Autowired
    private ISeatRepository seatRepository;

    /**
     * creatr by : SangTDN
     * @param idRoute
     * @return list SeatProjection (see details in path air_ticket_booking/model/projection_tdns/SeatProjection.java)
     * call method showListSeatEmptyByRoute() from ISeatRepository
     */
    @Override
    public List<SeatProjection> showListSeatEmptyByRoute(Long idRoute) {
        return seatRepository.showListSeatEmptyByRoute(idRoute);
    }

    /**
     *method :find seat  by id in service
     * created by :NamPC
     * date create: 10/08/2023
     * @param id
     * return Seat
     */
    @Override
    public Seat findSeatById(Long id) {
        return seatRepository.findSeatById(id);
    }
}
