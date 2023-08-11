package com.example.air_ticket_booking.controller.customer;

import com.example.air_ticket_booking.model.customer.Customer;
import com.example.air_ticket_booking.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    /**
     * @param pageable
     * @return if getListCustomer have data return getListCustomer and status OK else return status NO_CONTENT
     * Create by: TàiMP
     * Date create: 10/08/2023
     */
    @GetMapping(value = {"/" , "/list"})
    public ResponseEntity<Page<Customer>> getListCustomers(@PageableDefault(size = 5) Pageable pageable) {
        Page<Customer> getListCustomer = customerService.getListCustomer(pageable);
        if (!getListCustomer.isEmpty()) {
            return new ResponseEntity<>(getListCustomer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * @param pageable, name, nationality, email
     * @return if getListSearch have data return getListSearch and status OK else return status NO_CONTENT
     * Create by: TàiMP
     * Date create: 10/08/2023
     */
    @GetMapping("/search")
    public ResponseEntity<Page<Customer>> getListSearchCustomer(@PageableDefault(size = 5) Pageable pageable, @RequestParam("email") String email,
                                                                @RequestParam("name") String name, @RequestParam("nationality") String nationality) {
        Page<Customer> getListSearch = customerService.getListSearchCustomer(pageable, email, name, nationality);
        if (!getListSearch.isEmpty()) {
            return new ResponseEntity<>(getListSearch, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * @param id
     * @return if customerService.findCustomerById(id) have data return status OK and set flag customer = true that customer else return status NOT_FOUND
     * Create by: TàiMP
     * Date create: 10/08/2023
     */
    @PutMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") Long id) {
            if (customerService.findCustomerById(id) != null) {
                customerService.deleteCustomer(id);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
    }

    /**
     * Create by: HoaLTY,HungLV
     * Date create: 10/08/2023
     * Function: get data from front-end and check id, if get customer = null, return status not found, else update customer return status success
     *
     * @param id,customer
     * @return ResponseEntity<>
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        if (customerService.findCustomerById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerService.updateCustomer(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Create by: HoaLTY
     * Date create: 10/08/2023
     * Function: get customer details by id
     *
     * @param id
     * @return customer
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> customerDetails(@PathVariable Long id) {
        return new ResponseEntity<>(customerService.findCustomerById(id), HttpStatus.OK);
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
    public ResponseEntity<?> saveCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
    


