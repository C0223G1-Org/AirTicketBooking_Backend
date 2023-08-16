package com.example.air_ticket_booking.controller.customer;

import com.example.air_ticket_booking.dto.customer.CustomerDto;
import com.example.air_ticket_booking.model.account.Account;
import com.example.air_ticket_booking.model.customer.Customer;
import com.example.air_ticket_booking.service.account.IAccountService;
import com.example.air_ticket_booking.service.customer.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customers")
@CrossOrigin("*")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IAccountService accountService;
    /**
     * @param pageable
     * @return if getListCustomer have data return getListCustomer and status OK else return status NO_CONTENT
     * Create by: TàiMP
     * Date create: 10/08/2023
     */
    @GetMapping(value = {"/", "/list"})
    public ResponseEntity<Page<Customer>> getListCustomers(@PageableDefault(size = 5) Pageable pageable, @RequestParam("page") String page, @RequestParam("email") String email,
                                                           @RequestParam("name") String name, @RequestParam("nationality") String nationality) {
        int currentPage;
        try {
            currentPage = Integer.parseInt(page);
            if (currentPage < 0) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else if (email.length() > 100 || name.length() > 100 || nationality.length() > 20) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            }
        } catch (NumberFormatException n) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Page<Customer> getListCustomer = customerService.getListSearchCustomer(pageable, email, name, nationality);
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
                                                                @RequestParam("name") String name, @RequestParam("nationality") String nationality,@RequestParam("page")String page) {

        int currentPage;
        try {
            currentPage = Integer.parseInt(page);
            if (currentPage < 0) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }else if (email.length()>100||name.length()>100||nationality.length()>20){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            }
        } catch (NumberFormatException n) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

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
    public ResponseEntity<?> updateCustomer(@PathVariable Long id, @Valid @RequestBody CustomerDto customerDto) {
        if (customerService.findCustomerById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
//        new CustomerDto().validate(customerDto,bindingResult);
//        if(bindingResult.hasErrors()){
//            return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
//        }
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
//    @GetMapping("/{id}")
//    public ResponseEntity<?> getCustomerDetails(@PathVariable Long id) {
//        try{
//            if(ObjectUtils.isEmpty(id)){
//                return new ResponseEntity<>("Không tìm thấy khách hàng này",HttpStatus.NOT_FOUND);
//            }
//            if (customerService.findCustomerById(id) == null) {
//                return new ResponseEntity<>("Không tìm thấy khách hàng này",HttpStatus.NOT_FOUND);
//            }
//
//       return new ResponseEntity<>(customerService.findCustomerById(id), HttpStatus.OK);
//}catch (IllegalArgumentException  e){
//        return new ResponseEntity<>("ID không thể chứa chữ hoặc kí tự đặc biệt",HttpStatus.BAD_REQUEST);
//        }
//
//        }
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
        Long idAccount = (long) (accountService.getList().size()+1);
        Account account = customer.getAccount();
        account.setIdAccount(idAccount);
        accountService.saveAccount(account);
        customer.setAccount(account);
        customerService.saveCustomer(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id ){
        Customer customer = customerService.findCustomerById(id);
        if(customer==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
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
