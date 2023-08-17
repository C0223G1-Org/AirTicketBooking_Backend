package com.example.air_ticket_booking.service.employee.impl;

import com.example.air_ticket_booking.dto.employee.EmployeeDto;

import com.example.air_ticket_booking.model.account.Account;
import com.example.air_ticket_booking.model.employee.Employee;
import com.example.air_ticket_booking.repository.account.IAccountRepository;
import com.example.air_ticket_booking.repository.employee.IEmployeeRepository;
import com.example.air_ticket_booking.service.account.IAccountService;
import com.example.air_ticket_booking.service.employee.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;
    @Autowired
    private IAccountRepository accountRepository;
    @Autowired
    private IAccountService accountService;
    @Autowired
    private PasswordEncoder passwordEncoder;

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
                employee.getTypeEmployee().getIdTypeEmployee(),
                employee.getPasswordEmployee()

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
                employee.getPasswordEmployee(),
                employee.getTypeEmployee().getIdTypeEmployee(),
                employee.getFlagEmployee(),
                employee.getIdEmployee()
        );
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
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
    public boolean createEmployee(EmployeeDto employeeDto) {
        String email = employeeDto.getEmailEmployee();
        Boolean checkExistAcc = accountService.checkExistAccount(email);
        Boolean checkExistEmp = checkExistEmpl(email);
        if(checkExistAcc || checkExistEmp){
            return false;
        }
        String password = passwordEncoder.encode(employeeDto.getPasswordEmployee());
        this.accountService.createAccEmpl(email,password);
        Account accountNew = accountService.findAccountByEmail(email);
        if(accountNew == null){
            return false;
        }
        this.employeeRepository.addEmployee(employeeDto.getNameEmployee(),
                employeeDto.getDateEmployee(),employeeDto.isGender(),employeeDto.getImage(),employeeDto.getTelEmployee(),
                employeeDto.getEmailEmployee(), employeeDto.getTypeEmployee().getIdTypeEmployee(), employeeDto.getPasswordEmployee());
        return true;
    }
    private boolean checkExistEmpl(String email){
        List<Employee> employeeList = employeeRepository.findAllByEmail(email);
        return employeeList.size() > 0;
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
//        employeeRepository.deleteEmployee(id);
        Employee employee = employeeRepository.findById(id).get();
        employee.setFlagEmployee(true);
        employeeRepository.save(employee);
    }

    /**
     * Create by: HuyHD;
     * Date create: 10/08/2023
     * Function: Searches for employees based on the provided gender and name parameters.
     *
     * @param gender   The gender of the employee to search for
     * @param name     The name or part of the name of the employee to search for
     * @param pageable
     * @return A list of employees matching the specified gender and name criteria
     */
    @Override
    public Page<Employee> searchEmployee(Boolean gender, String name, Pageable pageable) {
        return employeeRepository.searchEmployee(gender, name, pageable);
    }

    @Override
    public Employee getEmployeeLoginByEmail(String email) {
        return employeeRepository.getEmployeeLoginByEmail(email);
    }
}

