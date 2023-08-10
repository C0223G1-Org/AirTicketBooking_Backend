package com.example.air_ticket_booking.model.route;

import javax.persistence.*;

@Entity
@Table(name="air_craft")
public class AirCraft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAirCraft;

    private String nameAirCraft;

    public AirCraft() {
    }

    public AirCraft(Long idAirCraft, String nameAirCraft) {
        this.idAirCraft = idAirCraft;
        this.nameAirCraft = nameAirCraft;
    }

    public Long getIdAirCraft() {
        return idAirCraft;
    }

    public void setIdAirCraft(Long idAirCraft) {
        this.idAirCraft = idAirCraft;
    }

    public String getNameAirCraft() {
        return nameAirCraft;
    }

    public void setNameAirCraft(String nameAirCraft) {
        this.nameAirCraft = nameAirCraft;
    }
}
