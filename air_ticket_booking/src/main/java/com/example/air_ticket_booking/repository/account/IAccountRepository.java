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
     * @param idAccount
     *update password when user is customer
     */
    @Transactional
    @Modifying
    @Query(value = "UPDATE account SET password = :newPass \n" +
            "WHERE id_account = :idAccount\n" +
            "and password = :oldPass", nativeQuery = true)
    void updatePasswordForId (@Param("newPass") String newPass, @Param("oldPass") String oldPass,
                                    @Param("idCustomer") Long idAccount );

}
