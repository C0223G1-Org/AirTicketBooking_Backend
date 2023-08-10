package com.example.air_ticket_booking.repository.seat;

import com.example.air_ticket_booking.model.projection_tdns.SeatProjection;
import com.example.air_ticket_booking.model.seat.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISeatRepository extends JpaRepository<Seat,Long> {
    @Query (value = "select ts.id_type_seat as idTypeSeat,ts.name_type_seat as nameTypeSeat, count(*) as countSeatEmpty \n" +
            "from seat s join type_seat ts on s.id_type_seat = ts.id_type_seat\n" +
            "where s.id_route = :idRoute \n" +
            "and s.flag_seat = false\n" +
            "group by s.id_type_seat;", nativeQuery = true)
    List<SeatProjection> showListSeatEmptyByRoute(@Param("idRoute") Long idRoute );

}
