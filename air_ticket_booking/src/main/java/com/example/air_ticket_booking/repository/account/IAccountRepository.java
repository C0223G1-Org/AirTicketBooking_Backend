package com.example.air_ticket_booking.repository.account;

import com.example.air_ticket_booking.model.account.Account;

import com.example.air_ticket_booking.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
@Repository
public interface IAccountRepository extends JpaRepository<Account, Integer> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO account (password,username,role_id_role)" +
            "value (:password,:userName,:roleIdRole)", nativeQuery = true)
    void addAccount(@Param("password") String password,
                    @Param("userName") String userName,
                    @Param("roleIdRole")Long role);

    @Modifying
    @Transactional
    @Query(value = "UPDATE account set password=:password,username=:userName,role_id_role=:roleId" +
            " where id_account=:id", nativeQuery = true)
    void updateAccount(@Param("id") Long id,
                       @Param("password") String password,
                       @Param("userName")String userName,
                       @Param("roleId") Long idRole);
    @Query(nativeQuery = true, value = "select * from account where id_account = :id")
    Account findByIdAccount(@Param("id") Long id);

    Account findByUsername(String username);
}
