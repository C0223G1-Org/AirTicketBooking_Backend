package com.example.air_ticket_booking.service.luggage;

import com.example.air_ticket_booking.model.luggage.Luggage;

import java.util.List;

public interface ILuggageService {
    /**
     * method :get all the options the user chooses to buy extra luggage weight
     * created by :NamPC
     * date create: 10/08/2023
     *
     * @param "not"
     * return all luggage in database
     */


    List<Luggage> getAllLuggage();
    /**
     * method :find extra luggage by id
     * created by :NamPC
     * date create: 10/08/2023
     *
     * @param "not"
     * return all luggage in database
     */

    Luggage findLuggageById(Long id);
}
