package com.example.air_ticket_booking.repository.seat;

import com.example.air_ticket_booking.model.seat.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ISeatRepository extends JpaRepository<Seat,Long> {
    /**
     *method :find seat in database by id in repository
     * created by :NamPC
     * date create: 10/08/2023
     * @param id
     * return Seat
     */

    @Query(value = "select * from seat where id_seat = :id",nativeQuery = true)
    Seat findSeatById(@Param("id")Long id);

}
