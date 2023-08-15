package com.example.air_ticket_booking.repository.employee;

import com.example.air_ticket_booking.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee,Long> {
    @Query(value = "select * from employee where flag_employee=false",nativeQuery = true)
    List<Employee> getAllEmployee();
}
