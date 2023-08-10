package com.example.air_ticket_booking.model.employee;

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
    private String birthDay;
    private String telEmployee;
    private String image;

    private int gender;
    private boolean flagEmployee;

    public Employee() {
    }

    public Employee(Long id, String name, String birthDay, String telEmployee, String image, int gender, boolean flagEmployee) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.telEmployee = telEmployee;
        this.image = image;
        this.gender = gender;
        this.flagEmployee = flagEmployee;
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

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
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

}
