package com.example.air_ticket_booking.controller.account;

import com.example.air_ticket_booking.service.account.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/role")
@CrossOrigin("*")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    @GetMapping("")
    public ResponseEntity<?> findByRole() {
        return new ResponseEntity<>(roleService.findByRole(), HttpStatus.OK);
    }
}
