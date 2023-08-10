package com.example.air_ticket_booking.service.seat;

import com.example.air_ticket_booking.model.seat.Seat;
import com.example.air_ticket_booking.model.seat.TypeSeat;

public interface ISeatService {
    /**
     *method :findSeatById()
     * created by :NamPC
     * date create: 10/08/2023
     * @param id
     * return Seat
     */
    Seat findSeatById(Long id);
}

