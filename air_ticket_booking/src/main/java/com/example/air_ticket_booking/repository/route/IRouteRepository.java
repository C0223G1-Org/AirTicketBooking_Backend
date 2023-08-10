package com.example.air_ticket_booking.repository.route;

import com.example.air_ticket_booking.model.projection_tdns.RouteProjection;
import com.example.air_ticket_booking.model.route.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IRouteRepository extends JpaRepository<Route,Long> {
    @Query(value = "select rt.id_route as idRoute ,rt.date_arrival as dateArrival, rt.date_departure as dateDeparture, rt.name_route as nameRoute, rt.price_route as priceRoute, rt.time_arrival as timeArrival, rt.time_departure as timeDeparture, ac.name_air_craft as nameAirCraft, dt.name_destination as nameDestination, dp.name_departure as nameDeparture \n" +
            "from route rt \n" +
            "join air_craft ac on rt.id_air_craft = ac.id_air_craft\n" +
            "join departure dp on rt.id_departure = dp.id_departure\n" +
            "join destination dt on rt.id_destination = dt.id_destination\n" +
            "where dp.name_departure = :departure \n" +
            "and dt.name_destination = :destination", nativeQuery = true)
    List<RouteProjection> showListRoute (@Param("departure")String departure, @Param("destination") String destination);


}
