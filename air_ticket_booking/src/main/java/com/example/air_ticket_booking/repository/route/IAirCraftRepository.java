package com.example.air_ticket_booking.repository.route;

import com.example.air_ticket_booking.model.route.AirCraft;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAirCraftRepository extends JpaRepository<AirCraft,Long> {

}
