package com.example.air_ticket_booking.controller.customer;

import com.example.air_ticket_booking.model.customer.Customer;
import com.example.air_ticket_booking.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    /**
     * @param pageable
     * @return if getListCustomer have data return getListCustomer and status OK else return status NO_CONTENT
     *Create by: TàiMP
     *Date create: 10/08/2023
     */
    @GetMapping("")
    public ResponseEntity<Page<Customer>> getListCustomers(Pageable pageable) {
        Page<Customer> getListCustomer = iCustomerService.getListCustomer(pageable);
        if (getListCustomer.getTotalElements() != 0) {
            return new ResponseEntity<>(getListCustomer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    /**
     * @param pageable, name, nationality, email
     * @return if getListSearch have data return getListSearch and status OK else return status NO_CONTENT
     *Create by: TàiMP
     *Date create: 10/08/2023
     */
    @GetMapping("search/name={name}/nationality={nationality}/email={email}")
    public ResponseEntity<Page<Customer>> getListSearchCustomer(Pageable pageable, @PathVariable("email") String email,
                                                                @PathVariable("name") String name, @PathVariable("nationality") String nationality) {
        Page<Customer> getListSearch = iCustomerService.getListSearchCustomer(pageable, email, name, nationality);
        if (getListSearch.getTotalElements() != 0) {
            return new ResponseEntity<>(getListSearch, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    /**
     * @param id
     * @return if iCustomerService.findCustomerById(id) have data return status OK and set flag customer = true that customer else return status NOT_FOUND
     *Create by: TàiMP
     *Date create: 10/08/2023
     */
    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") Long id) {
        if (iCustomerService.findCustomerById(id) != null) {
            iCustomerService.deleteCustomer(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
