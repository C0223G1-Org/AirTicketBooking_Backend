package com.example.air_ticket_booking.controller.seat;

import com.example.air_ticket_booking.model.projection_tdns.SeatProjection;
import com.example.air_ticket_booking.repository.seat.ISeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/seat")
public class SeatController {
    @Autowired
    private ISeatRepository seatRepository;

    /**
     * create by: SangTDN
     * @param idRoute
     * @return array Json SeatProjection,status
     * Upload data to API
     */
    @GetMapping("/seat-empty/{idRoute}")
    public ResponseEntity<List<SeatProjection>> showListSeatEmptyByRoute (@PathVariable Long idRoute){
        List<SeatProjection> list;
        try{
            list = seatRepository.showListSeatEmptyByRoute(idRoute);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (list.size()==0){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
