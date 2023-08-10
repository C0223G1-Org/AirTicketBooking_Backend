package com.example.air_ticket_booking.model.type_passenger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class TypePassenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTypePassenger;
    private String nameTypePassenger;
    public TypePassenger() {
    }
    public TypePassenger(Long idTypePassenger, String nameTypePassenger) {
        this.idTypePassenger = idTypePassenger;
        this.nameTypePassenger = nameTypePassenger;
    }
    public Long getIdTypePassenger() {
        return idTypePassenger;
    }
    public void setIdTypePassenger(Long idTypePassenger) {
        this.idTypePassenger = idTypePassenger;
    }
    public String getNameTypePassenger() {
        return nameTypePassenger;
    }
    public void setNameTypePassenger(String nameTypePassenger) {
        this.nameTypePassenger = nameTypePassenger;
    }
}