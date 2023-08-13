package com.example.air_ticket_booking.service.account.impl;

import com.example.air_ticket_booking.dto.account.AccountDto;
import com.example.air_ticket_booking.model.account.Account;
import com.example.air_ticket_booking.repository.account.IAccountRepository;
import com.example.air_ticket_booking.service.account.IAccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;
    @Override
    public void saveRole(AccountDto accountDto) {
        Account account =new Account();
        BeanUtils.copyProperties(accountDto,account);
        accountRepository.addAccount(
                account.getPassword(),
                account.getUsername(),
                account.getRole()
        );
    }
}
