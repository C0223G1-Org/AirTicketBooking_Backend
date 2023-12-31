package com.example.air_ticket_booking.controller.employee;

import com.example.air_ticket_booking.dto.employee.EmployeeDto;
import com.example.air_ticket_booking.model.employee.Employee;
import com.example.air_ticket_booking.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin("*")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    /**
     * Create by: QuocNHA,
     * Date create : 10/08/2023
     * Function : create employee
     * <p>
     *
     * @param employeeDto
     * @return status create
     */
    @PostMapping("")
    public ResponseEntity<?> saveEmployee(@Validated @RequestBody EmployeeDto employeeDto,
                                          BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            employeeService.saveEmployee(employeeDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            getResponseEntity(bindingResult);
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
        }
    }
    /**
     * Create by: QuocNHA,
     * Date create : 10/08/2023
     * Function : find by employee
     * <p>
     *
     * @param id
     * @return HttpStatus.NOT_FOUND if result= null else then return employeeDto and HttpStatus.OK
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> findByIdEmployee(@PathVariable Long id) {
        EmployeeDto employeeDto = employeeService.findByyId(id);
        if (employeeDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(employeeDto, HttpStatus.OK);
        }
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
    @PutMapping("/{id}")
    public ResponseEntity<?> editEmployee(@Validated @RequestBody EmployeeDto employeeDto,
                                          BindingResult bindingResult, @PathVariable Long id) {
        if (!bindingResult.hasErrors()) {
            employeeService.editEmployee(id, employeeDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            getResponseEntity(bindingResult);
            return new ResponseEntity<>(bindingResult.getFieldErrors(),HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Create by: QuocNHA,
     * Date create : 10/08/2023
     * Function : get ResponseEntity
     * <p>
     *
     * @param bindingResult
     * @return status update
     */
    private void getResponseEntity(BindingResult bindingResult) {
        Map<String, String> map = new LinkedHashMap<>();
        List<FieldError> errors = bindingResult.getFieldErrors();
        for (FieldError error : errors) {
            if (!map.containsKey(error.getField())) {
                map.put(error.getField(), error.getDefaultMessage());
            }
        }
    }

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
    public ResponseEntity<?> searchEmployee(@PathVariable(value = "gender", required = false) Boolean gender, @PathVariable(value = "name", required = false) String name) {
        List<Employee> employeeList = employeeService.searchEmployee(gender, name);
        if (employeeList.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(employeeList, HttpStatus.OK);
        }
    }
}
