package com.example.air_ticket_booking.model.account;

import javax.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAccount;
    private String username;
    private String password;
    @Column(name = "verification_code")
    private Integer verificationCode;
    @ManyToOne
    private Role role;
    @Column(name = "status_delete")
    private Integer statusDelete;

    public Account() {
    }

    public Account(String username, Integer verificationCode) {
        this.username = username;
        this.verificationCode = verificationCode;
    }

    public Account(Long idAccount, String username, String password, Role role) {
        this.idAccount = idAccount;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Account(Long idAccount, String username, String password, Integer verificationCode, Role role) {
        this.idAccount = idAccount;
        this.username = username;
        this.password = password;
        this.verificationCode = verificationCode;
        this.role = role;
    }

    public Account(Long idAccount, String username, String password, Integer verificationCode, Role role, Integer statusDelete) {
        this.idAccount = idAccount;
        this.username = username;
        this.password = password;
        this.verificationCode = verificationCode;
        this.role = role;
        this.statusDelete = statusDelete;
    }

    public Integer getStatusDelete() {
        return statusDelete;
    }

    public void setStatusDelete(Integer statusDelete) {
        this.statusDelete = statusDelete;
    }

    public Integer getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(Integer verificationCode) {
        this.verificationCode = verificationCode;
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