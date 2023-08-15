package com.example.air_ticket_booking.repository.type_passenger;

import com.example.air_ticket_booking.model.type_passenger.TypePassenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ITypePassengerRepository extends JpaRepository <TypePassenger,Long> {
    @Query(value = "select * from type_passenger where id_type_passenger =:id",nativeQuery = true)
    TypePassenger findTypePassengerById(@Param("id") Long id);
}
