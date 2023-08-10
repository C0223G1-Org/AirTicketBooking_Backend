package com.example.air_ticket_booking.service.route;

import com.example.air_ticket_booking.model.projection_tdns.RouteProjection;

import java.util.List;

public interface IRouteService {
    List<RouteProjection> showListRoute (String departure,String destination);
}
