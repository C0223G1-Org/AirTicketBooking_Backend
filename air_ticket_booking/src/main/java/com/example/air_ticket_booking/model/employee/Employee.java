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
    private String passwordEmployee;
    private String confirmPasswordEmployee;
    private Boolean gender;
    private Boolean flagEmployee;

    @ManyToOne
    private TypeEmployee typeEmployee;

    public Employee() {
    }

    public Employee(Long idEmployee, String nameEmployee, String dateEmployee, String telEmployee, String image,
                    String emailEmployee, String passwordEmployee, String confirmPasswordEmployee, Boolean gender, Boolean flagEmployee) {
        this.idEmployee = idEmployee;
        this.nameEmployee = nameEmployee;
        this.dateEmployee = dateEmployee;
        this.telEmployee = telEmployee;
        this.image = image;
        this.emailEmployee = emailEmployee;
        this.passwordEmployee = passwordEmployee;
        this.confirmPasswordEmployee = confirmPasswordEmployee;
        this.gender = gender;
        this.flagEmployee = flagEmployee;
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

    public String getPasswordEmployee() {
        return passwordEmployee;
    }

    public void setPasswordEmployee(String passwordEmployee) {
        this.passwordEmployee = passwordEmployee;
    }

    public String getConfirmPasswordEmployee() {
        return confirmPasswordEmployee;
    }

    public void setConfirmPasswordEmployee(String confirmPasswordEmployee) {
        this.confirmPasswordEmployee = confirmPasswordEmployee;
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

    public TypeEmployee getTypeEmployee() {
        return typeEmployee;
    }

    public void setTypeEmployee(TypeEmployee typeEmployee) {
        this.typeEmployee = typeEmployee;
    }
}