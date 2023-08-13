package com.example.air_ticket_booking.controller.account;

import com.example.air_ticket_booking.dto.account.AccountDto;
import com.example.air_ticket_booking.dto.employee.EmployeeDto;
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
    @PostMapping("")
    public ResponseEntity<?> saveEmployee(@Validated @RequestBody AccountDto accountDto,
                                          BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            accountService.saveRole(accountDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
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
