package com.example.air_ticket_booking.repository.employee;

import com.example.air_ticket_booking.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = "select * from employee", nativeQuery = true)
    Page<Employee> findAll(Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "delete from employee where id = :id", nativeQuery = true)
    void deleteEmployee(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = "select * from employee where id = :id", nativeQuery = true)
    Employee getEmployeeById(@Param("id") Long id);

}
