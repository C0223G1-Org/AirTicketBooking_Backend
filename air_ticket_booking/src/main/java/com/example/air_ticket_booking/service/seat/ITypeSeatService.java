package com.example.air_ticket_booking.service.seat;

import com.example.air_ticket_booking.model.seat.TypeSeat;

import java.util.List;

public interface ITypeSeatService {
    /**
     * create by : SangTDN
     * @return List TypeSeat
     * it is abstract method
     */
    List<TypeSeat> getListSeat ();
}
