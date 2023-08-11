package com.example.air_ticket_booking.controller.seat;

import com.example.air_ticket_booking.model.seat.TypeSeat;
import com.example.air_ticket_booking.service.seat.ITypeSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/type-seat")
public class TypeSeatController {
    @Autowired
    private ITypeSeatService typeSeatService;

    /**
     * create by : SangTDN
     * @return arr Json TypeSeat , status
     * Upload data to API
     */
    @GetMapping("")
    public ResponseEntity<List<TypeSeat>> getListSeat(){
        return new ResponseEntity<>(typeSeatService.getListSeat(), HttpStatus.OK);
    }
}
