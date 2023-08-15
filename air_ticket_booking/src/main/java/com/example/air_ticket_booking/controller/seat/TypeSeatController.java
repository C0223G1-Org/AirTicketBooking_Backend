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
     *method :find type seat by id
     * created by :NamPC
     * date create: 10/08/2023
     * @param id
     * return HttpStatus, TypeSeat
     */
    @GetMapping("detail/{id}")
    public ResponseEntity<TypeSeat> findTypeSeatById(@PathVariable Long id){
        TypeSeat typeSeat = typeSeatService.findTypeSeatById(id);
        if (typeSeat==null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(typeSeat,HttpStatus.OK);
        }
    }
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
