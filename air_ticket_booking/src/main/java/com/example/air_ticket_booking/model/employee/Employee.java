package com.example.air_ticket_booking.model.employee;

import com.example.air_ticket_booking.model.account.Account;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmployee;
    private String nameEmployee;
    private String dateEmployee;
    private String telEmployee;
    private String image;
    private String emailEmployee;
    private Boolean gender;
    private Boolean flagEmployee;

    @OneToOne
    private Account account;

    public Employee() {
    }

    public Employee(Long idEmployee, String nameEmployee, String dateEmployee, String telEmployee,
                    String image, String emailEmployee, Boolean gender, Boolean flagEmployee, Account account) {
        this.idEmployee = idEmployee;
        this.nameEmployee = nameEmployee;
        this.dateEmployee = dateEmployee;
        this.telEmployee = telEmployee;
        this.image = image;
        this.emailEmployee = emailEmployee;
        this.gender = gender;
        this.flagEmployee = flagEmployee;
        this.account = account;
    }

    public Long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getDateEmployee() {
        return dateEmployee;
    }

    public void setDateEmployee(String dateEmployee) {
        this.dateEmployee = dateEmployee;
    }

    public String getTelEmployee() {
        return telEmployee;
    }

    public void setTelEmployee(String telEmployee) {
        this.telEmployee = telEmployee;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEmailEmployee() {
        return emailEmployee;
    }

    public void setEmailEmployee(String emailEmployee) {
        this.emailEmployee = emailEmployee;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Boolean getFlagEmployee() {
        return flagEmployee;
    }

    public void setFlagEmployee(Boolean flagEmployee) {
        this.flagEmployee = flagEmployee;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
