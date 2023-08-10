package com.example.air_ticket_booking.controller.route;

import com.example.air_ticket_booking.model.route.Route;
import com.example.air_ticket_booking.service.route.IRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/routes")
public class RouteController {
    @Autowired
    private IRouteService iRouteService;
    /**
     *method :find a flight route by id
     * created by :NamPC
     * date create: 10/08/2023
     * @param id
     * return Route
     */
    @GetMapping("/{id}")
    public ResponseEntity<Route>getRouteById(@PathVariable Long id){
        Route route = iRouteService.findRouteById(id);
        if (route==null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }else {
            return  new ResponseEntity<>(route,HttpStatus.OK);
        }
    }
}
