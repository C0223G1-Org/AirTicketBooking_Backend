package com.example.air_ticket_booking.service.account;

import com.example.air_ticket_booking.dto.account.AccountDto;
import com.example.air_ticket_booking.model.account.Account;
import com.example.air_ticket_booking.model.employee.Employee;

public interface IAccountService {
    void saveAccount(AccountDto accountDto);
    void editAccount(Long id,AccountDto accountDto);
    Account findByyId(Long id);
}
