package com.example.air_ticket_booking.service.employee;

import com.example.air_ticket_booking.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
    Page<Employee> findAll(Pageable pageable);
    void deleteEmployee(Long id);
    Employee getEmployeeById(Long id);
}
