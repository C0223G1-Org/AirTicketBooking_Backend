package com.example.air_ticket_booking.service.account;

import com.example.air_ticket_booking.model.account.Account;

import java.util.List;

public interface IAccountService {
    List<Account> getList();
    void saveAccount(Account account);
}
