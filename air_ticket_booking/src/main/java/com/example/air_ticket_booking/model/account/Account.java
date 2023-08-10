package com.example.air_ticket_booking.model.account;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Account {
    @Id
    private Long idAccount;
    private String user;
    private String password;
    @ManyToOne
    private Role role;

    public Account() {
    }

    public Account(Long idAccount, String user, String password, Role role) {
        this.idAccount = idAccount;
        this.user = user;
        this.password = password;
        this.role = role;
    }

    public Long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Long idAccount) {
        this.idAccount = idAccount;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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
