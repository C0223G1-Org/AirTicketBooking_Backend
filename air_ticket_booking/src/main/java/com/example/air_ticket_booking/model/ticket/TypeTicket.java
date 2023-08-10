package com.example.air_ticket_booking.model.ticket;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class TypeTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTypeTicket;
    private String nameTypeTicket;
    public TypeTicket() {
    }
    public TypeTicket(Long idTypeTicket, String nameTypeTicket) {
        this.idTypeTicket = idTypeTicket;
        this.nameTypeTicket = nameTypeTicket;
    }
    public Long getIdTypeTicket() {
        return idTypeTicket;
    }
    public void setIdTypeTicket(Long idTypeTicket) {
        this.idTypeTicket = idTypeTicket;
    }
    public String getNameTypeTicket() {
        return nameTypeTicket;
    }
    public void setNameTypeTicket(String nameTypeTicket) {
        this.nameTypeTicket = nameTypeTicket;
    }
}