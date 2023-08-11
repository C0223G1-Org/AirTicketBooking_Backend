package com.example.air_ticket_booking.service.account.impl;

import com.example.air_ticket_booking.service.account.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private IRoleService iRoleService;
}
