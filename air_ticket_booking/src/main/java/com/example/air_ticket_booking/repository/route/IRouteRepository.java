package com.example.air_ticket_booking.repository.route;

import com.example.air_ticket_booking.model.projection_tdns.RouteProjection;
import com.example.air_ticket_booking.model.route.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IRouteRepository extends JpaRepository<Route,Long> {
    /**
     * method :find a flight route by id in database
     * created by :NamPC
     * date create: 10/08/2023
     * @param id return flight route
     */

    @Query(value = "select rt.id_route ,rt.date_arrival, rt.date_departure, rt.name_route, rt.price_route, rt.time_arrival, rt.time_departure, ac.name_air_craft, dt.name_destination, dp.name_departure\n" +
            "from route rt\n" +
            "join air_craft ac on rt.id_air_craft = ac.id_air_craft\n" +
            "join departure dp on rt.id_departure = dp.id_departure\n" +
            "join destination dt on rt.id_destination = dt.id_destination\n" +
            "where rt.id_route =:id", nativeQuery = true)
    Route findRouteById(@Param("id") Long id);

    /**
     * Create by: SangTDN
     * @param departure
     * @param destination
     * @param dateDeparture
     * use : the function of retrieving flights according to the input requirements and the number of available seats
     * corresponding to each seat type
     * @return List RouteProjection (RouteProjection is interface to collect attributes from many related tables)
     */
    @Query(value = "select rt.id_route as idRoute ,rt.date_arrival as dateArrival, rt.date_departure as dateDeparture, rt.name_route as nameRoute, rt.price_route as priceRoute, rt.time_arrival as timeArrival, rt.time_departure as timeDeparture, ac.name_air_craft as nameAirCraft, dt.name_destination as nameDestination,\n" +
            " dp.name_departure as nameDeparture, (\n" +
            " select count(*) as countSeatEmpty\n" +
            "from seat s join type_seat ts on s.id_type_seat = ts.id_type_seat\n" +
            "where s.id_route = rt.id_route\n" +
            "and ts.name_type_seat = \"BUSSINESS\"\n" +
            "and s.flag_seat = false\n" +
            "group by s.id_type_seat\n" +
            " ) as seatsBussinessRemaining,\n" +
            " (\n" +
            "  select count(*) as countSeatEmpty\n" +
            "from seat s join type_seat ts on s.id_type_seat = ts.id_type_seat\n" +
            "where s.id_route = rt.id_route\n" +
            "and ts.name_type_seat = \"skyBOSS\"\n" +
            "and s.flag_seat = false\n" +
            "group by s.id_type_seat\n" +
            " ) as seatsSkybossRemaining,\n" +
            " (\n" +
            "   select count(*) as countSeatEmpty\n" +
            "from seat s join type_seat ts on s.id_type_seat = ts.id_type_seat\n" +
            "where s.id_route = rt.id_route\n" +
            "and ts.name_type_seat = \"VELUXE\"\n" +
            "and s.flag_seat = false\n" +
            "group by s.id_type_seat\n" +
            " ) as seatsVeluxeRemaining,\n" +
            " (\n" +
            "    select count(*) as countSeatEmpty\n" +
            "from seat s join type_seat ts on s.id_type_seat = ts.id_type_seat\n" +
            "where s.id_route = rt.id_route\n" +
            "and ts.name_type_seat = \"ECO\"\n" +
            "and s.flag_seat = false\n" +
            "group by s.id_type_seat\n" +
            " ) as seatsEcoRemaining,\n" +
            " (\n" +
            " select price_extra from type_seat\n" +
            "where id_type_seat = 1\n" +
            ") as priceExtraBussiness,\n" +
            " (\n" +
            " select price_extra from type_seat\n" +
            "where id_type_seat = 2\n" +
            ") as priceExtraSkyboss,\n" +
            " (\n" +
            " select price_extra from type_seat\n" +
            "where id_type_seat = 3\n" +
            ") as priceExtraVeluxe,\n" +
            " (\n" +
            " select price_extra from type_seat\n" +
            "where id_type_seat = 4\n" +
            ") as priceExtraEco\n" +
            "from route rt \n" +
            "join air_craft ac on rt.id_air_craft = ac.id_air_craft\n" +
            "join departure dp on rt.id_departure = dp.id_departure\n" +
            "join destination dt on rt.id_destination = dt.id_destination\n" +
            "where dp.name_departure = :departure \n" +
            "and dt.name_destination = :destination \n" +
            "and rt.date_departure = :dateDeparture \n" +
            "and rt.date_departure >= now()", nativeQuery = true)
    List<RouteProjection> showListRoute(@Param("departure") String departure, @Param("destination") String destination,
                                        @Param("dateDeparture") String dateDeparture);

    /**
     * method dùng để lấy danh sách top 10 chuyến bay giá rẻ nhất
     * @author ThaiVV
     * @since 10/08/2023
     * @return List<Route>
     */
    @Query(nativeQuery = true, value = "select * from route order by price_route desc limit 10")
    List<Route> getTop10RouteCheapest();


}
