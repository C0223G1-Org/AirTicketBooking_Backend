package com.example.air_ticket_booking.repository.account;

import com.example.air_ticket_booking.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
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
    /**
     * create by : SangTDN
     * @param newPass
     * @param idAccount
     *use: update password
     */
   @Transactional
   @Modifying
   @Query(value = "UPDATE account SET password = :newPass \n" +
           "WHERE id_account = :idAccount", nativeQuery = true)
   void updatePasswordById (@Param("newPass") String newPass, @Param("idAccount") Long idAccount);

    /**
     * create by : SangTDN
     * @param id
     * @return account by id
     */
    @Query(value = "select * from account where id_account = :id", nativeQuery = true)
    Account findAccountById (@Param("id") Long id);


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