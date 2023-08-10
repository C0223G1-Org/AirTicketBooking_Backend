package com.example.air_ticket_booking.repository.route;

import com.example.air_ticket_booking.model.route.Departure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartureRepository extends JpaRepository<Departure,Long> {
}
