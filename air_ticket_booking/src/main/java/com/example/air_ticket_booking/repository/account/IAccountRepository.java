package com.example.air_ticket_booking.repository.account;

import com.example.air_ticket_booking.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

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


}
