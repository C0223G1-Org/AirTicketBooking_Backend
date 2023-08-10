package com.example.air_ticket_booking.model.account;

import javax.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAccount;
    private String username;
    private String password;
    @ManyToOne
    private Role role;

    public Account() {
    }

    public Account(Long idAccount, String username, String password, Role role) {
        this.idAccount = idAccount;
        this.username = username;
        this.password = password;
        this.role = role;
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

    public void setUsername(String user) {
        this.username = user;
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