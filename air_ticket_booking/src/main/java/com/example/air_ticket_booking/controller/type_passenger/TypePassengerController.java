package com.example.air_ticket_booking.controller.type_passenger;

import com.example.air_ticket_booking.model.type_passenger.TypePassenger;
import com.example.air_ticket_booking.service.type_passenger.ITypePassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/type-passenger")
public class TypePassengerController {
    @Autowired
    private ITypePassengerService typePassengerService;

    @GetMapping("/detail/{id}")
    public ResponseEntity<TypePassenger> getTypePassenger(@PathVariable Long id){
        TypePassenger typePassenger = typePassengerService.findTypePassengerById(id);
        if (typePassenger==null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<TypePassenger>(typePassenger,HttpStatus.OK);
        }
    }
}
