package com.example.air_ticket_booking.repository.seat;

import com.example.air_ticket_booking.model.seat.TypeSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypeSeatRepository extends JpaRepository<TypeSeat,Long> {
}
