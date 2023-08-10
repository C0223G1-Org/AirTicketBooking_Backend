package com.example.air_ticket_booking.repository.seat;


import com.example.air_ticket_booking.model.projection_tdns.SeatProjection;
import com.example.air_ticket_booking.model.seat.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISeatRepository extends JpaRepository<Seat,Long> {
    /**
     * method :find seat in database by id in repository
     * created by :NamPC
     * date create: 10/08/2023
     *
     * @param id return Seat
     */

    @Query(value = "select * from seat where id_seat = :id", nativeQuery = true)
    Seat findSeatById(@Param("id") Long id);

    /**
     * create by : SangTDN
     * @param idRoute
     * @return List SeatProjection (see details in path air_ticket_booking/model/projection_tdns/SeatProjection.java)
     * get the number of seats available for each seat type for the corresponding flight
     */
    @Query (value = "select ts.id_type_seat as idTypeSeat,ts.name_type_seat as nameTypeSeat, count(*) as countSeatEmpty \n" +
            "from seat s join type_seat ts on s.id_type_seat = ts.id_type_seat\n" +
            "where s.id_route = :idRoute \n" +
            "and s.flag_seat = false\n" +
            "group by s.id_type_seat;", nativeQuery = true)
    List<SeatProjection> showListSeatEmptyByRoute(@Param("idRoute") Long idRoute );

}

