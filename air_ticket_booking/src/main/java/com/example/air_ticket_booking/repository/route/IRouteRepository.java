package com.example.air_ticket_booking.repository.route;

import com.example.air_ticket_booking.model.route.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IRouteRepository extends JpaRepository<Route,Long> {
    /**
     *method :findRouteById()
     * created by :NamPC
     * date create: 10/08/2023
     * @param id
     * return Route
     */

    @Query(value = "select rt.id_route ,rt.date_arrival, rt.date_departure, rt.name_route, rt.price_route, rt.time_arrival, rt.time_departure, ac.name_air_craft, dt.name_destination, dp.name_departure\n" +
            "from route rt\n" +
            "join air_craft ac on rt.id_air_craft = ac.id_air_craft\n" +
            "join departure dp on rt.id_departure = dp.id_departure\n" +
            "join destination dt on rt.id_destination = dt.id_destination\n" +
            "where rt.id_route =:id",nativeQuery = true)
     Route findRouteById(@Param("id") Long id);

}
