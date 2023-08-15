package com.example.air_ticket_booking.controller.employee;

import com.example.air_ticket_booking.model.employee.Employee;
import com.example.air_ticket_booking.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/employee")
@RestController
@CrossOrigin("*")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;
    @GetMapping("")
    public ResponseEntity<List<Employee>> employeesList(){
        List<Employee> employeeList=iEmployeeService.getAllEmployee();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }
}
