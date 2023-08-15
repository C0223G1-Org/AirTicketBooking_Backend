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
     * create by : SangTDN
     *
     * @param newPass
     * @param oldPass
     * @param idCustomer
     * @Return void
     */
    void updatePasswordForCustomer(String newPass, String oldPass, Long idCustomer);

    /**
     * create by : SangTDN
     *
     * @param newPass
     * @param oldPass
     * @param idEmployee
     * @Return void
     */
    void updatePasswordForEmployee (String newPass,String oldPass,Long idEmployee);
    List<Account> getList();
    void saveAccount(Account account);
    void updatePasswordForEmployee(String newPass, String oldPass, Long idEmployee);
    /**
     * Created by: NhanDT
     * Date created: 14/08/2023
     * Function: SignUp
     *
     * @param account
     * @return boolean
     */
    boolean checkCode(Account account);
}
