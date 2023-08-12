package com.example.air_ticket_booking.service.account;

import com.example.air_ticket_booking.dto.account.AccountDto;

import com.example.air_ticket_booking.model.account.Account;
import org.springframework.data.repository.query.Param;

public interface IAccountService {
    boolean signUp(AccountDto accountDto);
    /**
     * create by : SangTDN
     * @param newPass
     * @param idCustomer
     * @Return void
     */
    void updatePasswordForId(String newPass,Long idCustomer);

    Account findAccountById (Long id);

}
