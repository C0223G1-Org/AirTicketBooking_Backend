package com.example.air_ticket_booking.service.employee;

import com.example.air_ticket_booking.dto.employee.EmployeeDto;
import com.example.air_ticket_booking.model.employee.Employee;

public interface IEmployeeService {

    /**
     * Create by: QuocNHA,
     * Date create : 10/08/2023
     */
    void saveEmployee(EmployeeDto employee);
    void editEmployee(Long id,EmployeeDto employee);

    EmployeeDto findByyId(Long id);
}