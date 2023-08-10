package com.example.air_ticket_booking.controller.route;

import com.example.air_ticket_booking.service.route.IRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/route")
public class RouteController {
    @Autowired
    private IRouteService routeService;

    /**
     * method dùng để lấy danh sách top 10 chuyến bay giá rẻ nhất
     * @author ThaiVV
     * @since 10/08/2023
     * @return List<Route>
     */
    @GetMapping("/top10")
    public ResponseEntity<?> getTop10Cheapest() {
        return new ResponseEntity<>(routeService.findTop10RouteCheapest(), HttpStatus.OK);
    }
}
