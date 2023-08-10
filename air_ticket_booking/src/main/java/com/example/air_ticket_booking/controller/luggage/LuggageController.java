package com.example.air_ticket_booking.controller.luggage;

import com.example.air_ticket_booking.model.luggage.Luggage;
import com.example.air_ticket_booking.service.luggage.ILuggageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/luggage")
public class LuggageController {
    @Autowired
    private ILuggageService iLuggageService;
    /**
     *method : get all the options the user chooses to buy extra luggage weight
     * created by :NamPC
     * date create: 10/08/2023
     * @param "not param"
     * return HttpStatus,List<Luggage>
     */

    @GetMapping("/list")
    public ResponseEntity<List<Luggage>> getAllLuggage(){
        List<Luggage> luggageList=iLuggageService.getAllLuggage();
        if (luggageList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(luggageList,HttpStatus.OK);
        }
    }
    /**
     *method :find extra luggage by id
     * created by :NamPC
     * date create: 10/08/2023
     * @param id
     * return HttpStatus, Luggage
     */
    @GetMapping("/{id}")
    public ResponseEntity<Luggage> findLuggageById(@PathVariable Long id){
        Luggage luggage = iLuggageService.findLuggageById(id);
        if (luggage==null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(luggage,HttpStatus.OK);
        }
    }
}
