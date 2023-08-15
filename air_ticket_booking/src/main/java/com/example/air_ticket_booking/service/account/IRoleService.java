package com.example.air_ticket_booking.service.account;

import com.example.air_ticket_booking.model.account.Role;

import java.util.List;

public interface IRoleService {
    List<Role> findByRole();
}
