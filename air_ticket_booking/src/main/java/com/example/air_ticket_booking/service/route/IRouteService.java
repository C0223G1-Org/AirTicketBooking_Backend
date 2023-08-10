package com.example.air_ticket_booking.service.route;

import com.example.air_ticket_booking.model.route.Route;

import java.util.List;

import com.example.air_ticket_booking.model.projection_tdns.RouteProjection;

import java.util.List;

public interface IRouteService {
    List<Route> findTop10RouteCheapest();
    List<RouteProjection> showListRoute (String departure,String destination);
}
