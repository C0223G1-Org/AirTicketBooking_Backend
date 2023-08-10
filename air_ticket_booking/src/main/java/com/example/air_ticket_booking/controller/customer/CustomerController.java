package com.example.air_ticket_booking.controller.customer;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import com.example.air_ticket_booking.model.customer.Customer;
import com.example.air_ticket_booking.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customers")
@CrossOrigin("*")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    /**
     * Create by: HoaLTY
     * Date create: 10/08/2023
     * Function:update customer information
     * @param id
     * @param customer
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        if(customerService.findCustomerById(id)==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerService.updateCustomer(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Create by: HoaLTY
     * Date create: 10/08/2023
     * Function: get customer details by id
     * @param id
     * @return customer
     */
    @GetMapping("/details/{id}")
    public ResponseEntity<?> customerDetails(@PathVariable Long id){
        return new ResponseEntity<>(customerService.findCustomerById(id),HttpStatus.OK);
    }


}