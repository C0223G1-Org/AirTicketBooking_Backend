package com.example.air_ticket_booking.controller.employee;

import com.example.air_ticket_booking.model.employee.Employee;
import com.example.air_ticket_booking.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/employee")
@CrossOrigin("*")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    /**
     * Create by: HuyHD;
     * Date create: 10/08/2023
     * Function: displays a paginated list of employees;
     * @param : page (page number), limit(number of elements in the page);
     * @return : paginated employee list with limit number of molecules per page.
     */
    @GetMapping("/{page}/{limit}")
    public ResponseEntity<?> getListEmployee(@PathVariable(value = "page")Integer page, @PathVariable(value = "limit") Integer limit) {
        Pageable pageable = PageRequest.of(page, limit);
        if (employeeService.findAll(pageable).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(this.employeeService.findAll(pageable), HttpStatus.OK);
    }

    /**
     * Create by: HuyHD;
     * Date create: 10/08/2023
     * Function: delete employee with employee code ? ;
     * @param : id (id_employee);
     * @return : new employee list does not exist newly deleted element.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        this.employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Create by: HuyHD;
     * Date create: 10/08/2023
     * Function: Search for employees by gender and name ;
     * @param : gender (employee's gender), name(name of employee you want to find);
     * @return : The list of new employees matches the parameters passed in.
     */
    @GetMapping("/search/{gender}/{name}")
    public ResponseEntity<?> searchEmployee(@PathVariable Boolean gender, @PathVariable String name) {
        List<Employee> employeeList = employeeService.searchEmployee(gender, name);
        if (employeeList.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(employeeList, HttpStatus.OK);
        }
    }

}
