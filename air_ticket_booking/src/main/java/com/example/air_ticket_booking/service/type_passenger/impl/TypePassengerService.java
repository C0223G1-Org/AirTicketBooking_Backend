package com.example.air_ticket_booking.service.type_passenger.impl;

import com.example.air_ticket_booking.model.type_passenger.TypePassenger;
import com.example.air_ticket_booking.repository.type_passenger.ITypePassengerRepository;
import com.example.air_ticket_booking.service.type_passenger.ITypePassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypePassengerService implements ITypePassengerService {
    @Autowired
    private ITypePassengerRepository typePassengerRepository;
    @Override
    public TypePassenger findTypePassengerById(Long id) {
        return typePassengerRepository.findTypePassengerById(id);
    }
}
