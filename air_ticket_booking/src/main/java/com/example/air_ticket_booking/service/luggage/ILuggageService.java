package com.example.air_ticket_booking.service.luggage;

import com.example.air_ticket_booking.model.luggage.Luggage;

import java.util.List;

public interface ILuggageService {
    /**
     * method :getAllLuggage()
     * created by :NamPC
     * date create: 10/08/2023
     *
     * @param "not" return List<Luggage>
     */


    List<Luggage> getAllLuggage();
    /**
     * method :findLuggageById()
     * created by :NamPC
     * date create: 10/08/2023
     *
     * @param "not" return List<Luggage>
     */

    Luggage findLuggageById(Long id);
}
