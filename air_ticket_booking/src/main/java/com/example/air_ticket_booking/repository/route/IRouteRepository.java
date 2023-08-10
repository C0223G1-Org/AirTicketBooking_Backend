package com.example.air_ticket_booking.repository.route;

import com.example.air_ticket_booking.model.route.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IRouteRepository extends JpaRepository<Route, Long> {
    /**
     * method dùng để lấy danh sách top 10 chuyến bay giá rẻ nhất
     * @author ThaiVV
     * @since 10/08/2023
     * @return List<Route>
     */
    @Query(nativeQuery = true, value = "select * from route order by price_route desc limit 10")
    List<Route> getTop10RouteCheapest();
}
