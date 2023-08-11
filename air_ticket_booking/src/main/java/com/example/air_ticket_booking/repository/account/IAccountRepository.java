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
     * @param oldPass
     * @param idCustomer
     *update password when user is customer
     */
    @Transactional
    @Modifying
    @Query(value = "UPDATE account SET password = :newPass \n" +
            "WHERE password = :oldPass \n" +
            "and id_account = (\n" +
            "select account_id_account \n" +
            "from customer \n" +
            "where id_customer = :idCustomer)", nativeQuery = true)
    void updatePasswordForCustomer (@Param("newPass") String newPass, @Param("oldPass") String oldPass,
                                    @Param("idCustomer") Long idCustomer );

    /**
     * create by : SangTDN
     * @param newPass
     * @param oldPass
     * @param idEmployee
     * update password when user is employee
     */
    @Transactional
    @Modifying
    @Query(value = "UPDATE account SET password = :newPass \n" +
            "WHERE password = :oldPass \n" +
            "and id_account = (\n" +
            "select account_id_account \n" +
            "from employee \n" +
            "where id_employee = :idEmployee)",nativeQuery = true)
    void updatePasswordForEmployee (@Param("newPass") String newPass, @Param("oldPass") String oldPass, @Param("idEmployee") Long idEmployee);
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
