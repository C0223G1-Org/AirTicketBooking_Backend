package com.example.air_ticket_booking.service.seat.impl;

import com.example.air_ticket_booking.model.projection_tdns.SeatProjection;
import com.example.air_ticket_booking.model.seat.Seat;
import com.example.air_ticket_booking.projection.ISeatEmptyProjection;
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

    @Override
    public Seat findSeatByIdTySeat(Long idTypeSeat, Long idRoute, Long number) {
        return seatRepository.findSeatByIdTySeat(idTypeSeat,idRoute,number);
    }

    @Override
    public List<ISeatEmptyProjection> getSeatEmptyRoute(int id) {
        return seatRepository.getSeatEmptyRoute(id);
    }
}
