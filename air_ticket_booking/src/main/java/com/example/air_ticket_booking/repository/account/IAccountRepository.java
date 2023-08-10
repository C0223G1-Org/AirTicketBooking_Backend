package com.example.air_ticket_booking.repository.account;

import com.example.air_ticket_booking.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Long> {
    Account findByUsername(String username);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "select * from account where username = :userName")
    List<Account> findAllByUsername(@Param("userName") String userName);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "insert into account(username, password, role_id_role) values (:email, :password, 3)")
    void saveAccount(@Param("email") String email, @Param("password") String password);
}
