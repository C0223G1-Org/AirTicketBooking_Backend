package com.example.air_ticket_booking.service.account.impl;

import com.example.air_ticket_booking.repository.account.IAccountRepository;
import com.example.air_ticket_booking.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;
    @Override
    public void updatePasswordForCustomer(String newPass, String oldPass, Long idCustomer) {
        accountRepository.updatePasswordForCustomer(newPass,oldPass,idCustomer);
    }

    @Override
    public void updatePasswordForEmployee(String newPass, String oldPass, Long idEmployee) {
        accountRepository.updatePasswordForEmployee(newPass,oldPass,idEmployee);
    }
}
