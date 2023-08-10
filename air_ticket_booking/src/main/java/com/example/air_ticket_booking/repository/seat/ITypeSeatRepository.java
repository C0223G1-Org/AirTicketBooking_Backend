package com.example.air_ticket_booking.repository.seat;

import com.example.air_ticket_booking.model.seat.TypeSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ITypeSeatRepository extends JpaRepository<TypeSeat,Long> {
    /**
     *method :findTypeSeatById()
     * created by :NamPC
     * date create: 10/08/2023
     * @param id
     * return TypeSeat
     */
    @Query(value = "select * from type_seat where id_type_seat = :id",nativeQuery = true)
    TypeSeat findTypeSeatById(@Param("id")Long id);
}
