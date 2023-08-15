package com.example.air_ticket_booking.service.employee.impl;

import com.example.air_ticket_booking.model.employee.Employee;
import com.example.air_ticket_booking.repository.employee.IEmployeeRepository;
import com.example.air_ticket_booking.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;
    @Override
    public List<Employee> getAllEmployee() {
        return iEmployeeRepository.getAllEmployee();
    }
}
