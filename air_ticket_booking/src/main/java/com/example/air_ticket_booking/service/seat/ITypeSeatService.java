package com.example.air_ticket_booking.service.seat;

import com.example.air_ticket_booking.model.seat.TypeSeat;

import java.util.List;

import com.example.air_ticket_booking.model.seat.TypeSeat;

public interface ITypeSeatService {
    /**
     * create by : SangTDN
     * @return List TypeSeat
     * it is abstract method
     */
    List<TypeSeat> getListSeat ();
    /**
     *method :find type seat in service
     * created by :NamPC
     * date create: 10/08/2023
     * @param id
     * return TypeSeat
     */
    TypeSeat findTypeSeatById(Long id);
}
