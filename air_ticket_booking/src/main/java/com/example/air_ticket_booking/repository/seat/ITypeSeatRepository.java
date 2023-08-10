package com.example.air_ticket_booking.repository.seat;

import com.example.air_ticket_booking.model.seat.TypeSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ITypeSeatRepository extends JpaRepository<TypeSeat, Long> {
    @Query(value = "select * from type_seat", nativeQuery = true)
    List<TypeSeat> getListSeat ();
}
