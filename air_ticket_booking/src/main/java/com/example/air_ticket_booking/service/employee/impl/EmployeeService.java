package com.example.air_ticket_booking.service.employee.impl;

import com.example.air_ticket_booking.dto.employee.EmployeeDto;

import com.example.air_ticket_booking.model.employee.Employee;
import com.example.air_ticket_booking.repository.employee.IEmployeeRepository;
import com.example.air_ticket_booking.service.employee.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void editEmployee(Long id,EmployeeDto employeeDto) {
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
    public Employee findByyId(Long id) {
       return employeeRepository.findWithIdEmployee(id);

    }
}
