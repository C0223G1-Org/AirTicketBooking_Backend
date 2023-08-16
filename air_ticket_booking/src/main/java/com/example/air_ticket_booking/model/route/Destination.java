package com.example.air_ticket_booking.model.route;

import javax.persistence.*;

@Entity
@Table(name="destination")
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDestination;
    private String nameDestination;
    private String imageDestination;

    public Destination() {
    }

    public Destination(Long idDestination, String nameDestination) {
        this.idDestination = idDestination;
        this.nameDestination = nameDestination;
    }

    public Destination(Long idDestination, String nameDestination, String imageDestination) {
        this.idDestination = idDestination;
        this.nameDestination = nameDestination;
        this.imageDestination = imageDestination;
    }

    public Long getIdDestination() {
        return idDestination;
    }

    public void setIdDestination(Long idDestination) {
        this.idDestination = idDestination;
    }

    public String getNameDestination() {
        return nameDestination;
    }

    public void setNameDestination(String nameDestination) {
        this.nameDestination = nameDestination;
    }

    public String getImageDestination() {
        return imageDestination;
    }

    public void setImageDestination(String imageDestination) {
        this.imageDestination = imageDestination;
    }
}