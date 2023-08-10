package com.example.air_ticket_booking.service.route;

import com.example.air_ticket_booking.model.projection_tdns.RouteProjection;

import java.util.List;

public interface IRouteService {
    /**
     * create by : SangTDN
     * @param departure
     * @param destination
     * @param dateDeparture
     * @return List RouteProjection (RouteProjection is interface to collect attributes from many related tables)
     * it is abstract method
     */
    List<RouteProjection> showListRoute (String departure,String destination, String dateDeparture);
}
