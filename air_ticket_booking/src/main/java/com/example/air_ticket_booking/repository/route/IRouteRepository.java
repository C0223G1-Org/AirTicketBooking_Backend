package com.example.air_ticket_booking.repository.route;

import com.example.air_ticket_booking.model.route.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IRouteRepository extends JpaRepository<Route,Long> {
    /**
     *method :find a flight route by id in database
     * created by :NamPC
     * date create: 10/08/2023
     * @param id
     * return flight route
     */

    @Query(value = "select * from route where id_route=:id "
            ,nativeQuery = true)
     Route findRouteById(@Param("id") Long id);

}
