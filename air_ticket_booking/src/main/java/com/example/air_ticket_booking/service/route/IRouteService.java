package com.example.air_ticket_booking.service.route;

import com.example.air_ticket_booking.model.route.Route;

public interface IRouteService {
    /**
     *method :find a flight route by id in service
     * created by :NamPC
     * date create: 10/08/2023
     * @param id
     * return flight route
     */
    Route findRouteById(Long id);
}
