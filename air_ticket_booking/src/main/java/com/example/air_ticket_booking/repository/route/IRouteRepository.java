package com.example.air_ticket_booking.repository.route;

import com.example.air_ticket_booking.model.route.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRouteRepository extends JpaRepository<Route,Long> {
}
