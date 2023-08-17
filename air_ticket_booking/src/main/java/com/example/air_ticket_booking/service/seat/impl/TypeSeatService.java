package com.example.air_ticket_booking.service.seat.impl;

import com.example.air_ticket_booking.model.seat.TypeSeat;
import com.example.air_ticket_booking.repository.seat.ITypeSeatRepository;
import com.example.air_ticket_booking.service.seat.ITypeSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeSeatService implements ITypeSeatService {
    @Autowired
    private ITypeSeatRepository typeSeatRepository;


    /**
     *method :find  type seat  by id in service
     * created by :NamPC
     * date create: 10/08/2023
     * @param id
     * return TypeSeat
     */
    @Override
    public TypeSeat findTypeSeatById(Long id) {
        return typeSeatRepository.findTypeSeatById(id);
    }

    @Override
    public TypeSeat findTypeSeatByName(String name) {
        return typeSeatRepository.findTypeSeatByName(name);
    }
}
