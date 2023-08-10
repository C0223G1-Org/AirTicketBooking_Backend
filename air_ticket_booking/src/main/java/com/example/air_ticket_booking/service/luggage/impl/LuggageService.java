package com.example.air_ticket_booking.service.luggage.impl;

import com.example.air_ticket_booking.model.luggage.Luggage;
import com.example.air_ticket_booking.repository.luggage.ILuggageRepository;
import com.example.air_ticket_booking.service.luggage.ILuggageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LuggageService implements ILuggageService {
    @Autowired
    private ILuggageRepository iLuggageRepository;
    /**
     * method :getAllLuggage()
     * created by :NamPC
     * date create: 10/08/2023
     *
     * @param "not" return List<Luggage>
     */
    @Override
    public List<Luggage> getAllLuggage() {
        return iLuggageRepository.getAllLuggage();
    }
    /**
     * method :findLuggageById()
     * created by :NamPC
     * date create: 10/08/2023
     *
     * @param id return List<Luggage>
     */


    @Override
    public Luggage findLuggageById(Long id) {
        return iLuggageRepository.findLuggageById(id);
    }
}
