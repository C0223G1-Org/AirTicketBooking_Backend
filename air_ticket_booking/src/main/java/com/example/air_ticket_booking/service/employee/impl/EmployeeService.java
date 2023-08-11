package com.example.air_ticket_booking.service.employee.impl;

import com.example.air_ticket_booking.dto.employee.EmployeeDto;

import com.example.air_ticket_booking.model.employee.Employee;
import com.example.air_ticket_booking.repository.employee.IEmployeeRepository;
import com.example.air_ticket_booking.service.employee.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    /**
     * Create by: QuocNHA,
     * Date create : 10/08/2023
     * Function : create employee
     * <p>
     *
     * @param employeeDto
     * @return status create
     */
    @Override
    public void saveEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        employeeRepository.addEmployee(
                employee.getNameEmployee(),
                employee.getDateEmployee(),
                employee.getGender(),
                employee.getImage(),
                employee.getTelEmployee(),
                employee.getEmailEmployee(),
                employee.getAccount(),
                employee.getFlagEmployee()
        );
    }

    /**
     * Create by: QuocNHA,
     * Date create : 10/08/2023
     * Function : create employee
     * <p>
     *
     * @param employeeDto
     * @return status update
     */
    @Override
    public void editEmployee(Long id, EmployeeDto employeeDto) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        employeeRepository.updateEmployee(
                employee.getIdEmployee(),
                employee.getNameEmployee(),
                employee.getDateEmployee(),
                employee.getGender(),
                employee.getImage(),
                employee.getTelEmployee(),
                employee.getEmailEmployee(),
                employee.getAccount(),
                employee.getFlagEmployee()
        );
    }

    /**
     * Create by: QuocNHA,
     * Date create : 10/08/2023
     * Function : create employee
     * <p>
     *
     * @param id
     * @return status find by employee
     */
    @Override
    public EmployeeDto findByyId(Long id) {
        Employee employee = employeeRepository.findWithIdEmployee(id);
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);
        return employeeDto;
    }


    /**
     * Create by: HuyHD;
     * Date create: 10/08/2023
     * Function:  Retrieves a page of all employees.
     *
     * @param pageable The pagination information.
     * @return A page of all employees.
     */
    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    /**
     * Create by: HuyHD;
     * Date create: 10/08/2023
     * Function: delete employee with id;
     *
     * @param id The ID of the employee to be deleted.
     */
    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteEmployee(id);
    }

    /**
     * Create by: HuyHD;
     * Date create: 10/08/2023
     * Function: Searches for employees based on the provided gender and name parameters.
     *
     * @param gender The gender of the employee to search for
     * @param name   The name or part of the name of the employee to search for
     * @return A list of employees matching the specified gender and name criteria
     */
    @Override
    public List<Employee> searchEmployee(Boolean gender, String name) {
        return employeeRepository.searchEmployee(gender, name);
    }
}
