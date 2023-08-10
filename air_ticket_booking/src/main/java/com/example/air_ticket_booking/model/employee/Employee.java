package com.example.air_ticket_booking.model.employee;

import com.example.air_ticket_booking.model.account.Account;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDateTime birthDay;
    private String telEmployee;
    private String image;

    private int gender;
    private boolean flagEmployee;


    @OneToOne
    @JoinColumn(name = "id_account")
    private Account account;
    @ManyToOne
    private TypeEmployee typeEmployee;

    public Employee() {
    }

    public Employee(Long id, String name, LocalDateTime birthDay, String telEmployee, String image, int gender, boolean flagEmployee, Account account) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.telEmployee = telEmployee;
        this.image = image;
        this.gender = gender;
        this.flagEmployee = flagEmployee;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDateTime birthDay) {
        this.birthDay = birthDay;
    }

    public TypeEmployee getTypeEmployee() {
        return typeEmployee;
    }

    public void setTypeEmployee(TypeEmployee typeEmployee) {
        this.typeEmployee = typeEmployee;
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public boolean isFlagEmployee() {
        return flagEmployee;
    }

    public void setFlagEmployee(boolean flagEmployee) {
        this.flagEmployee = flagEmployee;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}

