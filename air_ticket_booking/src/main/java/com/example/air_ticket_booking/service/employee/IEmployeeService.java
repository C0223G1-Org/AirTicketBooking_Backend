package com.example.air_ticket_booking.service.employee;

import com.example.air_ticket_booking.dto.employee.EmployeeDto;
import com.example.air_ticket_booking.model.employee.Employee;

import com.example.air_ticket_booking.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {

    /**
     * Create by: QuocNHA,
     * Date create : 10/08/2023
     */
    void saveEmployee(EmployeeDto employee);
    void editEmployee(Long id,EmployeeDto employee);

    EmployeeDto findByyId(Long id);
    /**
     * Create by: HuyHD;
     * Date create: 10/08/2023
     * Function:  Retrieves a page of all employees.
     * @param pageable The pagination information.
     * @return A page of all employees.
     */
    Page<Employee> findAll(Pageable pageable);
    /**
     * Create by: HuyHD;
     * Date create: 10/08/2023
     * Function: delete employee with id;
     * @param id The ID of the employee to be deleted.
     */
    void deleteEmployee(Long id);

    /**
     * Create by: HuyHD;
     * Date create: 10/08/2023
     * Function: Searches for employees based on the provided gender and name parameters.
     * @param gender The gender of the employee to search for
     * @param name The name or part of the name of the employee to search for
     * @return A list of employees matching the specified gender and name criteria
     */
    List<Employee> searchEmployee(Boolean gender, String name);
}
