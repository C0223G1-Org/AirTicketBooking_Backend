package com.example.air_ticket_booking.model.employee;

import javax.persistence.*;

@Entity
@Table
public class TypeEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTypeEmployee;

    private String nameTypeEmployee;

    public TypeEmployee(Long idTypeEmployee, String nameTypeEmployee) {
        this.idTypeEmployee = idTypeEmployee;
        this.nameTypeEmployee = nameTypeEmployee;
    }

    public TypeEmployee() {
    }

    public Long getIdTypeEmployee() {
        return idTypeEmployee;
    }

    public void setIdTypeEmployee(Long idTypeEmployee) {
        this.idTypeEmployee = idTypeEmployee;
    }

    public String getNameTypeEmployee() {
        return nameTypeEmployee;
    }

    public void setNameTypeEmployee(String nameTypeEmployee) {
        this.nameTypeEmployee = nameTypeEmployee;
    }
}