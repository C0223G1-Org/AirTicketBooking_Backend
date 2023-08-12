package com.example.air_ticket_booking.controller.customer;

import com.example.air_ticket_booking.dto.customer.CustomerDto;
import com.example.air_ticket_booking.model.customer.Customer;
import com.example.air_ticket_booking.service.customer.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

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
    @GetMapping("")
    public ResponseEntity<Page<Customer>> getListCustomers(Pageable pageable) {
        Page<Customer> getListCustomer = customerService.getListCustomer(pageable);
        if (getListCustomer.getTotalElements() != 0) {
            return new ResponseEntity<>(getListCustomer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    /**
     * @param pageable, name, nationality, email
     * @return if getListSearch have data return getListSearch and status OK else return status NO_CONTENT
     * Create by: TàiMP
     * Date create: 10/08/2023
     */
    @GetMapping("search/name={name}/nationality={nationality}/email={email}")
    public ResponseEntity<Page<Customer>> getListSearchCustomer(Pageable pageable, @PathVariable("email") String email,
                                                                @PathVariable("name") String name, @PathVariable("nationality") String nationality) {
        Page<Customer> getListSearch = customerService.getListSearchCustomer(pageable, email, name, nationality);
        if (getListSearch.getTotalElements() != 0) {
            return new ResponseEntity<>(getListSearch, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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
    public ResponseEntity<?> updateCustomer(@PathVariable Long id, @Valid @RequestBody CustomerDto customerDto,BindingResult bindingResult) {
        if (customerService.findCustomerById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        new CustomerDto().validate(customerDto,bindingResult);
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
        }
        Customer customer=new Customer();
        BeanUtils.copyProperties(customerDto,customer);
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
    @GetMapping("/details/{id}")
    public ResponseEntity<?> getCustomerDetails(@PathVariable Long id) {
        try{
            if(ObjectUtils.isEmpty(id)){
                return new ResponseEntity<>("Không tìm thấy khách hàng này",HttpStatus.NOT_FOUND);
            }
            if (customerService.findCustomerById(id) == null) {
                return new ResponseEntity<>("Không tìm thấy khách hàng này",HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(customerService.findCustomerById(id), HttpStatus.OK);
        }catch (IllegalArgumentException  e){
            return new ResponseEntity<>("ID không thể chứa chữ hoặc kí tự đặc biệt",HttpStatus.BAD_REQUEST);
        }

    }


    /**
     * Create by: HungLV
     * Date create: 10/08/2023
     * Function:get data from front-end and save data in database and return status success
     * @Param: customer
     * @Return: ResponseEntity
     */

    @PostMapping("")
    public ResponseEntity<?> saveCustomer(@RequestBody Customer customer) {
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
    


