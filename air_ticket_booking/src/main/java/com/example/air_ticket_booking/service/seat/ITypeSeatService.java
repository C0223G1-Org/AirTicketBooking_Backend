package com.example.air_ticket_booking.service.seat;

import com.example.air_ticket_booking.model.seat.TypeSeat;

public interface ITypeSeatService {
    /**
     *method :findTypeSeatById()
     * created by :NamPC
     * date create: 10/08/2023
     * @param id
     * return TypeSeat
     */
    TypeSeat findTypeSeatById(Long id);
}
