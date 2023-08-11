package com.example.air_ticket_booking.service.route;

import com.example.air_ticket_booking.model.route.Route;

import java.util.List;

import com.example.air_ticket_booking.model.projection_tdns.RouteProjection;

import java.util.List;

import com.example.air_ticket_booking.model.route.Route;

public interface IRouteService {
    List<Route> findTop10RouteCheapest();

    /**
     * create by : SangTDN
     * @param departure
     * @param destination
     * @param dateDeparture
     * @return List RouteProjection (RouteProjection is interface to collect attributes from many related tables)
     * it is abstract method
     */
    List<RouteProjection> showListRoute (String departure,String destination, String dateDeparture);
    /**
     *method :find a flight route by id in service
     * created by :NamPC
     * date create: 10/08/2023
     * @param id
     * return flight route
     */
    Route findRouteById(Long id);
}
