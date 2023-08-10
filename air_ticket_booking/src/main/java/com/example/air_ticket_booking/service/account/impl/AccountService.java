package com.example.air_ticket_booking.service.account.impl;

import com.example.air_ticket_booking.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountService iAccountService;
}
