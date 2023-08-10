package com.example.air_ticket_booking.service.route.impl;

import com.example.air_ticket_booking.model.route.Route;
import com.example.air_ticket_booking.repository.route.IRouteRepository;
import com.example.air_ticket_booking.service.route.IRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteService implements IRouteService {
    @Autowired
    private IRouteRepository iRouteRepository;
    /**
     *method :findRouteById()
     * created by :NamPC
     * date create: 10/08/2023
     * @param id
     * return Route
     */
    @Override
    public Route findRouteById(Long id) {
        return iRouteRepository.findRouteById(id);
    }
}
