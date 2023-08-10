package com.example.air_ticket_booking.repository.type_passenger;

import com.example.air_ticket_booking.model.type_passenger.TypePassenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypePassengerRepository extends JpaRepository <TypePassenger,Long> {
}
