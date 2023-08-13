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
     * create by : SangTDN
     *
     * @param departure
     * @param destination
     * @param dateDeparture
     * @return List RouteProjection (RouteProjection is interface to collect attributes from many related tables)
     * call method showListRoute () from IRouteRepository
     */
    @Override
    public List<RouteProjection> showListRoute(String departure, String destination, String dateDeparture) {
        return routeRepository.showListRoute(departure, destination, dateDeparture);
    }

    /**
     * method :find a flight route by id in service
     * created by :NamPC
     * date create: 10/08/2023
     *
     * @param id return Route
     */
    @Override
    public Route findRouteById(Long id) {
        return routeRepository.findRouteById(id);
    }

    /**
     * method dùng để lấy danh sách top 10 chuyến bay giá rẻ nhất
     *
     * @return List<Route>
     * @author ThaiVV
     * @since 10/08/2023
     */
    @Override
    public List<Route> findTop10RouteCheapest() {
        return routeRepository.getTop10RouteCheapest();
    }

}
