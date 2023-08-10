package com.example.air_ticket_booking.service.route.impl;

import com.example.air_ticket_booking.model.projection_tdns.RouteProjection;
import com.example.air_ticket_booking.repository.route.IRouteRepository;
import com.example.air_ticket_booking.service.route.IRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RouteService implements IRouteService {
    @Autowired
    private IRouteRepository routeRepository;

    /**
     * create by : SangTDN
     * @param departure
     * @param destination
     * @param dateDeparture
     * @return List RouteProjection (RouteProjection is interface to collect attributes from many related tables)
     * call method showListRoute () from IRouteRepository
     */
    @Override
    public List<RouteProjection> showListRoute(String departure, String destination, String dateDeparture) {
        return routeRepository.showListRoute(departure,destination,dateDeparture);
    }
}
