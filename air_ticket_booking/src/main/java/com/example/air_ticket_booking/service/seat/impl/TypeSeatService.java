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
    @Override
    public List<TypeSeat> getListSeat() {
        return typeSeatRepository.getListSeat();
    }
}
