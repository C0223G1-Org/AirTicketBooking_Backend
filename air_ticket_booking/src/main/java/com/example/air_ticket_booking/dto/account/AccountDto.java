package com.example.air_ticket_booking.dto.account;

import com.example.air_ticket_booking.model.account.Role;

import javax.persistence.ManyToOne;

public class AccountDto {
    private Long idAccount;
    private String username;
    private String password;
    private Role role;

    public AccountDto() {
    }

    public Long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Long idAccount) {
        this.idAccount = idAccount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
