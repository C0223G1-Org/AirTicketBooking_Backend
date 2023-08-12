package com.example.air_ticket_booking.service.account.impl;

import com.example.air_ticket_booking.repository.account.IAccountRepository;
import com.example.air_ticket_booking.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;

    /**
     * create by : SangTDN
     * @param newPass
     * @param oldPass
     * @param idAccount
     * call method updatePasswordForCustomer() from IAccountRepository
     */
    @Override
    public void updatePasswordForId(String newPass, String oldPass, Long idAccount) {
        accountRepository.updatePasswordForId(newPass,oldPass,idAccount);
    }

}
