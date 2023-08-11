package com.example.air_ticket_booking.controller.route;
import com.example.air_ticket_booking.model.projection_tdns.RouteProjection;

import com.example.air_ticket_booking.model.route.Route;
import com.example.air_ticket_booking.service.route.IRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@CrossOrigin("*")
@RequestMapping("/route")
public class RouteController {
    @Autowired
    private IRouteService routeService;

    /**
     * Create by: SangTDN
     * @param departure
     * @param destination
     * @return list RouteProjection , status
     * get data from the URL as the appropriate argument of the function showListRoute() from IRouteService
     * then Upload data to API
     */
    @GetMapping("/search-trips/{departure}/{destination}/{dateDeparture}")
public ResponseEntity<List<RouteProjection>> searchTrips(@PathVariable String departure, @PathVariable String destination,
                                                         @PathVariable String dateDeparture){
        List<RouteProjection> list;
        try{
            list = routeService.showListRoute(departure,destination,dateDeparture);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (list.size()==0){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Route>getRouteById(@PathVariable Long id){
        Route route = routeService.findRouteById(id);
        if (route==null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }else {
            return  new ResponseEntity<>(route,HttpStatus.OK);
        }
    }
}
