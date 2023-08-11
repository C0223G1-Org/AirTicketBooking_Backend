package com.example.air_ticket_booking.controller.customer;

import com.example.air_ticket_booking.dto.customer.CustomerDto;
import com.example.air_ticket_booking.model.customer.Customer;
import com.example.air_ticket_booking.service.customer.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customers")
@CrossOrigin("*")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    /**
     * Create by: HungLV
     * Date create: 10/08/2023
     * Function: get data from front-end and check id, if get customer = null, return status not found, else update customer return status success
     *
     * @Param: customer, id
     * @Return: ResponseEntity
     */

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable Long id,@Valid @RequestBody CustomerDto customerDto){
        if (customerService.findCustomerById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        customerService.updateCustomer(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Create by: HungLV
     * Date create: 10/08/2023
     * Function:get data from front-end and save data in database and return status success
     *
     * @Param: customer
     * @Return: ResponseEntity
     */

    @PostMapping("")
    public ResponseEntity<?> saveCustomer(@Valid @RequestBody CustomerDto customerdto) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerdto,customer);
        customerService.saveCustomer(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
