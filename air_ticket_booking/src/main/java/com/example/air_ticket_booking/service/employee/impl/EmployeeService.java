package com.example.air_ticket_booking.service.employee.impl;

import com.example.air_ticket_booking.model.employee.Employee;
import com.example.air_ticket_booking.repository.employee.IEmployeeRepository;
import com.example.air_ticket_booking.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.getEmployeeById(id);
        employee.setFlagEmployee(true);
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return null;
    }
}
