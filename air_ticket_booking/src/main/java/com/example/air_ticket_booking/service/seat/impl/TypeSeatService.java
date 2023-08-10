package com.example.air_ticket_booking.service.seat.impl;

import com.example.air_ticket_booking.model.seat.TypeSeat;
import com.example.air_ticket_booking.repository.seat.ITypeSeatRepository;
import com.example.air_ticket_booking.service.seat.ITypeSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeSeatService implements ITypeSeatService {
    @Autowired
    private ITypeSeatRepository iTypeSeatRepository;

    /**
     *method :findTypeSeatById()
     * created by :NamPC
     * date create: 10/08/2023
     * @param id
     * return TypeSeat
     */
    @Override
    public TypeSeat findTypeSeatById(Long id) {
        return iTypeSeatRepository.findTypeSeatById(id);
    }
}
