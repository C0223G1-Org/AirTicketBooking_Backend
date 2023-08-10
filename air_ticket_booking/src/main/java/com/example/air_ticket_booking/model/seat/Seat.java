package com.example.air_ticket_booking.model.seat;

import com.example.air_ticket_booking.model.route.Route;

import javax.persistence.*;
@Entity
@Table(name="seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSeat;
    private String positionSeat;
    private boolean flagSeat;
    @ManyToOne
    @JoinColumn(name="id_type_seat")
    private TypeSeat typeSeat;
    @ManyToOne
    @JoinColumn(name="id_route")
    private Route route;

    public Seat() {
    }

    public Seat(Long idSeat, String positionSeat, boolean flagSeat, TypeSeat typeSeat, Route route) {
        this.idSeat = idSeat;
        this.positionSeat = positionSeat;
        this.flagSeat = flagSeat;
        this.typeSeat = typeSeat;
        this.route = route;
    }

    public Long getIdSeat() {
        return idSeat;
    }

    public void setIdSeat(Long idSeat) {
        this.idSeat = idSeat;
    }

    public String getPositionSeat() {
        return positionSeat;
    }

    public void setPositionSeat(String positionSeat) {
        this.positionSeat = positionSeat;
    }

    public boolean isFlagSeat() {
        return flagSeat;
    }

    public void setFlagSeat(boolean flagSeat) {
        this.flagSeat = flagSeat;
    }

    public TypeSeat getTypeSeat() {
        return typeSeat;
    }

    public void setTypeSeat(TypeSeat typeSeat) {
        this.typeSeat = typeSeat;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
