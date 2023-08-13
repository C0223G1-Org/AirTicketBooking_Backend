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
     * method :get all the options the user chooses to buy extra luggage weight
     * created by :NamPC
     * date create: 10/08/2023
     *
     * @param "not"
     * return all luggage in database
     */
    @Override
    public List<Luggage> getAllLuggage() {
        return iLuggageRepository.getAllLuggage();
    }
    /**
     * method :find extra luggage by id
     * created by :NamPC
     * date create: 10/08/2023
     *
     * @param id
     * return all luggage in database
     */


    @Override
    public Luggage findLuggageById(Long id) {
        return iLuggageRepository.findLuggageById(id);
    }
}
