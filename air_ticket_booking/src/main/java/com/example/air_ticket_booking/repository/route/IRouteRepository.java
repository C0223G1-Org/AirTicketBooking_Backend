package com.example.air_ticket_booking.repository.route;


import com.example.air_ticket_booking.model.projection_tdns.RouteProjection;
import com.example.air_ticket_booking.model.route.Route;
import com.example.air_ticket_booking.projection.IRouteCheapestProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public interface IRouteRepository extends JpaRepository<Route,Long> {
    /**
     * method :find a flight route by id in database
     * created by :NamPC
     * date create: 10/08/2023
     * @param id return flight route
     */

    @Query(value = "select * from route where id_route=:id "
            , nativeQuery = true)
    Route findRouteById(@Param("id") Long id);


    /**
     * Create by: SangTDN
     *
     * @param departure
     * @param destination
<<<<<<<<< Temporary merge branch 1
     * @param dateDeparture function that retrieves flights according to the input request
=========
     * @param dateDeparture
     * use : the function of retrieving flights according to the input requirements and the number of available seats
     * corresponding to each seat type
>>>>>>>>> Temporary merge branch 2
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
     * theo ngày hiện tại với thời gian bay lớn hơn 4 giờ hoặc ngày lớn hơn ngày hiện tại
     * @param dateDeparture
     * @param timeDeparture
     * @return List<Route>
     * @author ThaiVV
     * @since 10/08/2023
     */
    @Query(nativeQuery = true, value = "select rt.id_route as idRoute, " +
            "       rt.name_route as nameRoute,\n" +
            "       rt.date_departure as dateDeparture,\n" +
            "       rt.date_arrival as dateArrival,\n" +
            "       rt.time_departure as timeDeparture,\n" +
            "       rt.time_arrival as timeArrival,\n" +
            "       rt.price_route as priceRoute,\n" +
            "       ac.name_air_craft as nameAirCraft,\n" +
            "       dp.name_departure as nameDeparture,\n" +
            "       ds.name_destination as nameDestination, " +
            "       ds.image_destination as imageDestination \n" +
            "from route rt\n" +
            "         join air_craft ac on ac.id_air_craft = rt.id_air_craft\n" +
            "         join departure dp on dp.id_departure = rt.id_departure\n" +
            "         join destination ds on ds.id_destination = rt.id_destination\n" +
            "where rt.flag_route = false\n" +
            "  and ((rt.date_departure = :dateDeparture and (timediff(rt.time_departure, :timeDeparture) >= 4))\n" +
            "    or (rt.date_departure > :dateDeparture and (DATEDIFF(rt.date_departure, :dateDeparture) <= 31)))\n" +
            "order by rt.price_route\n" +
            "limit 10;")
    List<IRouteCheapestProjection> getTop10RouteCheapest(@Param("dateDeparture") LocalDate dateDeparture,
                                                         @Param("timeDeparture") LocalTime timeDeparture);
}
