package com.example.air_ticket_booking.repository.seat;


import com.example.air_ticket_booking.model.seat.TypeSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITypeSeatRepository extends JpaRepository<TypeSeat,Long> {
    /**
     * method :use find seat type by id passenger choose
     * created by :NamPC
     * date create: 10/08/2023
     *
     * @param id return selected type seat
     */
    @Query(value = "select * from type_seat where id_type_seat = :id", nativeQuery = true)
    TypeSeat findTypeSeatById(@Param("id") Long id);

    /**
     * create by : SangTDN
     * @return List TypeSeat
     * get list of seat type
     */
    @Query(value = "select * from type_seat", nativeQuery = true)
    List<TypeSeat> getListSeat ();
}
