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

}
