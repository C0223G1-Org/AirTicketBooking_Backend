package com.example.air_ticket_booking.repository.seat;


import com.example.air_ticket_booking.model.projection_tdns.SeatProjection;
import com.example.air_ticket_booking.model.seat.Seat;
import com.example.air_ticket_booking.projection.ISeatEmptyProjection;
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

    @Query(value = "select * from seat where id_type_seat=:idTypeSeat and flag_seat=false and id_route=:idRoute limit :number,1",nativeQuery = true)
    Seat findSeatByIdTySeat(@Param("idTypeSeat")Long idTypeSeat,@Param("idRoute") Long idRoute,@Param("number") Long number );
    @Query(value = "SELECT r.id_route AS idRoute, r.name_route AS nameRoute, de.name_departure AS nameDeparture, d.name_destination AS nameDestination, r.time_departure AS timeDeparture,\n" +
            "    (SELECT COUNT(*) FROM seat s\n" +
            "     JOIN type_seat ts ON ts.id_type_seat = s.id_type_seat\n" +
            "     WHERE s.flag_seat = 0 AND r.id_route = s.id_route) AS countEmpty\n" +
            "FROM route r\n" +
            "JOIN destination d ON d.id_destination = r.id_destination\n" +
            "JOIN air_craft ac ON ac.id_air_craft = r.id_air_craft\n" +
            "JOIN departure de ON de.id_departure = r.id_departure\n" +
            "ORDER BY r.id_route;",nativeQuery = true)
    ISeatEmptyProjection getSeatEmptyRoute(@Param("id")int id);
}
