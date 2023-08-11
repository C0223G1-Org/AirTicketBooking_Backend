package com.example.air_ticket_booking.repository.seat;

import com.example.air_ticket_booking.model.seat.Seat;
import com.example.air_ticket_booking.model.seat.TypeSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ITypeSeatRepository extends JpaRepository<TypeSeat,Long> {

}
