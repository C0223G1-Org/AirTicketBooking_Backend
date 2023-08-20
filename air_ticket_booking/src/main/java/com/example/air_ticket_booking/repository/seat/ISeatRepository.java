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
    @Query(value = "select position_seat as positionSeat,name_type_seat as nameSeat,flag_seat as flatSeat from seat s\n" +
            "join type_seat ts on  ts.id_type_seat = s.id_type_seat\n" +
            "join route r on r.id_route = s.id_route\n" +
            "where r.id_route=:id",nativeQuery = true)
    List<ISeatEmptyProjection> getSeatEmptyRoute(@Param("id")int id);
}
