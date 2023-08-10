package com.example.air_ticket_booking.repository.route;

import com.example.air_ticket_booking.model.route.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDestinationRepository extends JpaRepository<Destination,Long> {
}
