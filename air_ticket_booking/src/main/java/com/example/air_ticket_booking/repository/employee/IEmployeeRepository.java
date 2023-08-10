package com.example.air_ticket_booking.repository.employee;

import com.example.air_ticket_booking.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

    /**
     * Create by: HuyHD;
     * Date create: 10/08/2023
     * Funtion: Retrieves a page of employees where are the flag_employee is false.
     * @param pageable the pageable to request a paged result, can be {@link Pageable#unpaged()}, must not be
     *          {@literal null}.
     * @return
     */
    @Query(value = "select * from employee where flag_employee = false", nativeQuery = true)
    Page<Employee> findAll(Pageable pageable);

    /**
     * Create by: HuyHD;
     * Date create: 10/08/2023
     * Funtion: Delete an employee by setting the flag_employee to true based on the provided employee id.
     * @param id the id ò the employee to be  deleted.
     */
    @Transactional
    @Modifying
    @Query(value = "update employee set flag_employee = true where id_employee = :id", nativeQuery = true)
    void deleteEmployee(@Param("id") Long id);

    /**
     * Create by: HuyHD;
     * Date create: 10/08/2023
     * Function: Searches for employees based on the provided gender and name parameters.
     * @param gender The gender of the employee to search for. Can be null to indicate any gender
     * @param name The name of the employee to search for. Can be null to indicate any name.
     * @return A list of employees matching the specified gender and name criteria.
     */
    @Transactional
    @Modifying
    @Query("SELECT e FROM Employee e WHERE (:gender IS NULL OR e.gender = :gender) AND (:name IS NULL OR e.nameEmployee LIKE %:name%) AND e.flagEmployee = false")
    List<Employee> searchEmployee(@Param("gender") Boolean gender, @Param("name") String name);

}
