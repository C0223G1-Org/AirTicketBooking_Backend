package com.example.air_ticket_booking.model.luggage;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Luggage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLuggage;
    private String nameLuggage;
    private Long priceLuggage;
    public Luggage() {
    }
    public Luggage(Long idLuggage, String nameLuggage, Long priceLuggage) {
        this.idLuggage = idLuggage;
        this.nameLuggage = nameLuggage;
        this.priceLuggage = priceLuggage;
    }
    public Long getIdLuggage() {
        return idLuggage;
    }
    public void setIdLuggage(Long idLuggage) {
        this.idLuggage = idLuggage;
    }
    public String getNameLuggage() {
        return nameLuggage;
    }
    public void setNameLuggage(String nameLuggage) {
        this.nameLuggage = nameLuggage;
    }
    public Long getPriceLuggage() {
        return priceLuggage;
    }
    public void setPriceLuggage(Long priceLuggage) {
        this.priceLuggage = priceLuggage;
    }
}