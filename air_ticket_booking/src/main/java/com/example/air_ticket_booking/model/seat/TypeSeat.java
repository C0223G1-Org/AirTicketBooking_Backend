package com.example.air_ticket_booking.model.seat;

import javax.persistence.*;
@Entity
@Table(name="type_seat")
public class TypeSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTypeSeat;
    private String nameTypeSeat;
    private double priceExtra;

    public TypeSeat() {
    }

    public TypeSeat(Long idTypeSeat, String nameTypeSeat, double priceExtra) {
        this.idTypeSeat = idTypeSeat;
        this.nameTypeSeat = nameTypeSeat;
        this.priceExtra = priceExtra;
    }

    public Long getIdTypeSeat() {
        return idTypeSeat;
    }

    public void setIdTypeSeat(Long idTypeSeat) {
        this.idTypeSeat = idTypeSeat;
    }

    public String getNameTypeSeat() {
        return nameTypeSeat;
    }

    public void setNameTypeSeat(String nameTypeSeat) {
        this.nameTypeSeat = nameTypeSeat;
    }

    public double getPriceExtra() {
        return priceExtra;
    }

    public void setPriceExtra(double priceExtra) {
        this.priceExtra = priceExtra;
    }
}