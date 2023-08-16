package com.example.air_ticket_booking.service.account;

import com.example.air_ticket_booking.dto.account.AccountDto;

import com.example.air_ticket_booking.model.account.Account;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAccountService {
    /**
     * Created by: NhanDT
     * Date created: 10/08/2023
     * Function: SignUp
     *
     * @param accountDto
     * @return boolean
     */
    boolean signUp(AccountDto accountDto);
    /**
     * Created by: NhanDT
     * Date created: 10/08/2023
     * Function: SignUp
     *
     * @param email
     * @return boolean
     */
    boolean checkExistAccount(String email);

    /**
     * create by : SangTDN
     * @param newPass
     * @param idCustomer
     * @Return void
     */
    void updatePasswordForId(String newPass,Long idCustomer);

    Account findAccountById (Long id);
    List<Account> getList();

    void saveAccount(Account account);


    /**
     * Created by: NhanDT
     * Date created: 14/08/2023
     * Function: SignUp
     *
     * @param account
     * @return boolean
     */
    boolean checkCode(AccountDto account);
}
