package com.example.air_ticket_booking.repository.employee;

import com.example.air_ticket_booking.model.account.Account;
import com.example.air_ticket_booking.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
    /**
     * Create by: QuocNHA,
     * Date create : 10/08/2023
     * Function : find employee with corresponding id of employee
     * <p>
     *
     * @param id
     * @return HttpStatus.NOT_FOUND if result= null else then return employeeDto and HttpStatus.OK
     */
    @Query(nativeQuery = true, value = "select * from employee where id = :id")
    Employee findWithIdEmployee(@Param("id") Long id);
    /**
     * Create by: QuocNHA,
     * Date create : 10/08/2023
     * Function : create employee
     * <p>
     *
     * @param
     * @return status Created
     */
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO employee (`name`, birth_day, gender, image, tel_employee, email,id_account,flag_employee) " +
            "VALUES (:name, :birthDay, :gender,:image,:telEmployee, :email,:account,:flagEmployee)",
            nativeQuery = true)
    void addEmployee(@Param("name") String name,
                     @Param("birthDay") String birthDay,
                     @Param("gender") boolean gender,
                     @Param("image") String image,
                     @Param("telEmployee") String telEmployee,
                     @Param("email") String email,
                     @Param("account") Account account,
                     @Param("flagEmployee") boolean flagEmployee
    );

    /**
     * Create by: QuocNHA,
     * Date create : 10/08/2023
     * Function : update employee
     * <p>
     *
     * @param
     * @return status update
     */
    @Modifying
    @Transactional
    @Query(value = "Update employee set `name`=:name,birth_day=:birthDay,gender=:gender,image=:image," +
            "tel_employee=:telEmployee,email=:email,id_account=:account,flag_employee=:flagEmployee " +
            "where id=:id", nativeQuery = true)
    void updateEmployee(@Param("id")Long id,
                        @Param("name") String name,
                        @Param("birthDay") String birthday,
                        @Param("gender") boolean gender,
                        @Param("image") String image,
                        @Param("telEmployee") String telEmployee,
                        @Param("email") String email,
                        @Param("account") Account account,
                        @Param("flagEmployee") boolean flagEmployee
    );
}
