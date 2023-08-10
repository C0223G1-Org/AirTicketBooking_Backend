package com.example.air_ticket_booking.service.account;

import com.example.air_ticket_booking.dto.account.AccountDto;

public interface IAccountService {
    boolean signUp(AccountDto accountDto);
}
