package com.example.air_ticket_booking.model.route;

import javax.persistence.*;

@Entity
@Table(name="departure")
public class Departure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDeparture;
    private String nameDeparture;

    public Departure() {
    }

    public Departure(Long idDeparture, String nameDeparture) {
        this.idDeparture = idDeparture;
        this.nameDeparture = nameDeparture;
    }

    public Long getIdDeparture() {
        return idDeparture;
    }

    public void setIdDeparture(Long idDeparture) {
        this.idDeparture = idDeparture;
    }

    public String getNameDeparture() {
        return nameDeparture;
    }

    public void setNameDeparture(String nameDeparture) {
        this.nameDeparture = nameDeparture;
    }
}
