package com.example.air_ticket_booking.controller.account;

import com.example.air_ticket_booking.dto.account.AccountDto;
import com.example.air_ticket_booking.dto.employee.EmployeeDto;
import com.example.air_ticket_booking.model.account.Account;
import com.example.air_ticket_booking.model.employee.Employee;
import com.example.air_ticket_booking.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/account")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    /**
     * Create by: QuocNHA,
     * Date create : 10/08/2023
     * Function : create Account
     * <p>
     *
     * @param accountDto
     * @return HttpStatus.NOT_FOUND if result= null else then return employeeDto and HttpStatus.OK
     */

    @PostMapping("")
    public ResponseEntity<?> saveEmployee(@Validated @RequestBody AccountDto accountDto,
                                          BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            accountService.saveAccount(accountDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            getResponseEntity(bindingResult);
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Create by: QuocNHA,
     * Date create : 10/08/2023
     * Function : find by account
     * <p>
     *
     * @param id
     * @return HttpStatus.NOT_FOUND if result= null else then return employeeDto and HttpStatus.OK
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> findByIdAccount(@PathVariable Long id) {
        Account account = accountService.findByyId(id);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(account, HttpStatus.OK);
        }
    }

    /**
     * Create by: QuocNHA,
     * Date create : 10/08/2023
     * Function : editAccount
     * <p>
     *
     * @param accountDto
     * @return status update
     */
    @PatchMapping("/{id}")
    public ResponseEntity<?> editAccount(@Validated @RequestBody AccountDto accountDto,
                                          BindingResult bindingResult, @PathVariable Long id) {
        if (!bindingResult.hasErrors()) {
            accountService.editAccount(id, accountDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            getResponseEntity(bindingResult);
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
        }
    }

    private void getResponseEntity(BindingResult bindingResult) {
        Map<String, String> map = new LinkedHashMap<>();
        List<FieldError> errors = bindingResult.getFieldErrors();
        for (FieldError error : errors) {
            if (!map.containsKey(error.getField())) {
                map.put(error.getField(), error.getDefaultMessage());
            }
        }
    }
}
