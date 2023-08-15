package com.example.air_ticket_booking.service.account.impl;

import com.example.air_ticket_booking.model.account.Role;
import com.example.air_ticket_booking.repository.account.IRoleRepository;
import com.example.air_ticket_booking.repository.employee.IEmployeeRepository;
import com.example.air_ticket_booking.service.account.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleService implements IRoleService {
    @Autowired
    private IRoleRepository repository;

    @Override
    public List<Role> findByRole() {
        return repository.findByRole();
    }
}
