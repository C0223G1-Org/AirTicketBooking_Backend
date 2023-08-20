package com.example.air_ticket_booking.controller.seat;

import com.example.air_ticket_booking.model.projection_tdns.SeatProjection;
import com.example.air_ticket_booking.model.seat.Seat;
import com.example.air_ticket_booking.projection.ISeatEmptyProjection;
import com.example.air_ticket_booking.repository.seat.ISeatRepository;
import com.example.air_ticket_booking.service.seat.ISeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/seats")
public class SeatController {
    @Autowired
    private ISeatService iSeatService;
    @GetMapping("/searchSeat/{idTypeTicket}/{idRoute}/{number}")
    public ResponseEntity<Seat> getSeatByIdTypeTicket(@PathVariable Long idTypeTicket,@PathVariable Long idRoute, @PathVariable Long number){
       Seat seat= iSeatService.findSeatByIdTySeat(idTypeTicket,idRoute,number);
       if (seat==null){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
       else {
           return  new ResponseEntity<>(seat,HttpStatus.OK);
       }
    }
    @GetMapping("/seat-unBook/{id}")
    public ResponseEntity<List<ISeatEmptyProjection>> showListSeatUnbooked(@PathVariable("id") int id) {
        if(iSeatService.getSeatEmptyRoute(id).isEmpty()){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(iSeatService.getSeatEmptyRoute(id),HttpStatus.OK);
        }
    }
}
