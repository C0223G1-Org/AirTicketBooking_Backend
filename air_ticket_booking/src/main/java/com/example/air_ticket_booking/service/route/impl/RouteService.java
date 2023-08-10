package com.example.air_ticket_booking.service.route.impl;

import com.example.air_ticket_booking.model.projection_tdns.RouteProjection;
import com.example.air_ticket_booking.model.route.Route;
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
     * method dùng để lấy danh sách top 10 chuyến bay giá rẻ nhất
     * @author ThaiVV
     * @since 10/08/2023
     * @return List<Route>
     */
    @Override
    public List<Route> findTop10RouteCheapest() {
        return routeRepository.getTop10RouteCheapest();
    }
    @Override
    public List<RouteProjection> showListRoute(String departure, String destination) {
        return routeRepository.showListRoute(departure,destination);
    }
}
