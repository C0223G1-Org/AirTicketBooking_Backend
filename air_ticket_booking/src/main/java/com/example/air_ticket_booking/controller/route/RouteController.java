package com.example.air_ticket_booking.controller.route;
import com.example.air_ticket_booking.model.projection_tdns.RouteProjection;
import com.example.air_ticket_booking.model.route.Route;
import com.example.air_ticket_booking.projection.IRouteCheapestProjection;
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
     * method dùng để lấy danh sách top 10 chuyến bay giá rẻ nhất
     * @return ResponseEntity
     * @author ThaiVV
     * @since 10/08/2023
     */
    @GetMapping("/top10")
    public ResponseEntity<List<IRouteCheapestProjection>> getTop10Cheapest() {
        if (routeService.findTop10RouteCheapest().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else if (routeService.findTop10RouteCheapest().size() < 10) {
            return new ResponseEntity<>(routeService.findTop10RouteCheapest(), HttpStatus.OK);
        }
        return new ResponseEntity<>(routeService.findTop10RouteCheapest(), HttpStatus.OK);
    }
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
        if(list.size()==0){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /**
     *method :find a flight route by id
     * created by :NamPC
     * date create: 10/08/2023
     * @param id
     * return Route
     */
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
