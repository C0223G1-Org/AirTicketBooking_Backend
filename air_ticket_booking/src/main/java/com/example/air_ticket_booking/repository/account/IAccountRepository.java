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

    /**
     * Created by: NhanDT
     * Date created: 10/08/2023
     *
     * @param userName
     * @return Account
     */
    @Query(nativeQuery = true, value = "select * from account as a where a.username = :userName and a.status_delete = 0")
    Account getByUserNameAndStatusFalse(@Param("userName") String userName);


    /**
     * Created by: NhanDT
     * Date created: 10/08/2023
     *
     * @param userName
     * @return Account
     */
    @Query(nativeQuery = true, value = "select * from account as a where a.username = :userName and a.status_delete = 1")
    Account getByUserNameAndStatusTrue(@Param("userName") String userName);

    Account findByUsername(String userName);

    /**
     * Created by: NhanDT
     * Date created: 10/08/2023
     *
     * @param userName
     * @return List<Account>
     */
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "select * from account as a where a.username = :userName and a.status_delete = 0")
    List<Account> findAllByUsername(@Param("userName") String userName);

    /**
     * Created by: NhanDT
     * Date created: 10/08/2023
     *
     * @param email,password
     * @return void
     */
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "insert into account(username, password, verification_code, role_id_role, status_delete) values (:email, :password, :code, 3, 1)")
    void saveAccount(@Param("email") String email, @Param("password") String password, @Param("code") int code);

    /**
     * Created by: NhanDT
     * Date created: 15/08/2023
     *
     * @param id
     * @return void
     */
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update account as a set a.status_delete = 0 where a.id_account = :id")
    void setStatusToFalse(@Param("id") Long id);

    /**
     * Created by: NhanDT
     * Date created: 15/08/2023
     *
     * @param id
     * @return void
     */
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update account as a set a.verification_code = 0 where a.id_account = :id")
    void setCodeToFalse(@Param("id") Long id);
}
