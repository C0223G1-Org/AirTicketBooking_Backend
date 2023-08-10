package com.example.air_ticket_booking.model.ticket;

import com.example.air_ticket_booking.model.customer.Customer;
import com.example.air_ticket_booking.model.luggage.Luggage;
import com.example.air_ticket_booking.model.seat.Seat;
import com.example.air_ticket_booking.model.type_passenger.TypePassenger;

import javax.persistence.*;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTicket;
    private Long priceTicket;
    private Boolean flagTicket;
    private String namePassenger;
    private Boolean genderPassenger;
    private String emailPassenger;
    private  String telPassenger;
    private String idCardPassenger;
    private String dateBooking;
    @ManyToOne
    private TypeTicket typeTicket;
    @ManyToOne
     private Luggage luggage;
     @ManyToOne
     private TypePassenger typePassenger;
     @OneToOne
     private Seat seat;
     @ManyToOne
     private Customer customer;

    public Ticket() {
    }

    public Ticket(Long idTicket, Long priceTicket, Boolean flagTicket, String namePassenger,
                  Boolean genderPassenger, String emailPassenger, String telPassenger, String idCardPassenger,
                  String dateBooking, TypeTicket typeTicket, Luggage luggage, TypePassenger typePassenger, Seat seat,
                  Customer customer) {
        this.idTicket = idTicket;
        this.priceTicket = priceTicket;
        this.flagTicket = flagTicket;
        this.namePassenger = namePassenger;
        this.genderPassenger = genderPassenger;
        this.emailPassenger = emailPassenger;
        this.telPassenger = telPassenger;
        this.idCardPassenger = idCardPassenger;
        this.dateBooking = dateBooking;
        this.typeTicket = typeTicket;
        this.luggage = luggage;
        this.typePassenger = typePassenger;
        this.seat = seat;
        this.customer = customer;
    }

    public void setIdTicket(Long idTicket) {
        this.idTicket = idTicket;
    }

    public Long getIdTicket() {
        return idTicket;
    }

    public Long getPriceTicket() {
        return priceTicket;
    }

    public void setPriceTicket(Long priceTicket) {
        this.priceTicket = priceTicket;
    }

    public Boolean getFlagTicket() {
        return flagTicket;
    }

    public void setFlagTicket(Boolean flagTicket) {
        this.flagTicket = flagTicket;
    }

    public String getNamePassenger() {
        return namePassenger;
    }

    public void setNamePassenger(String namePassenger) {
        this.namePassenger = namePassenger;
    }

    public Boolean getGenderPassenger() {
        return genderPassenger;
    }

    public void setGenderPassenger(Boolean genderPassenger) {
        this.genderPassenger = genderPassenger;
    }

    public String getEmailPassenger() {
        return emailPassenger;
    }

    public void setEmailPassenger(String emailPassenger) {
        this.emailPassenger = emailPassenger;
    }

    public String getTelPassenger() {
        return telPassenger;
    }

    public void setTelPassenger(String telPassenger) {
        this.telPassenger = telPassenger;
    }

    public String getIdCardPassenger() {
        return idCardPassenger;
    }

    public void setIdCardPassenger(String idCardPassenger) {
        this.idCardPassenger = idCardPassenger;
    }

    public String getDateBooking() {
        return dateBooking;
    }

    public void setDateBooking(String dateBooking) {
        this.dateBooking = dateBooking;
    }

    public TypeTicket getTypeTicket() {
        return typeTicket;
    }

    public void setTypeTicket(TypeTicket typeTicket) {
        this.typeTicket = typeTicket;
    }

    public Luggage getLuggage() {
        return luggage;
    }

    public void setLuggage(Luggage luggage) {
        this.luggage = luggage;
    }

    public TypePassenger getTypePassenger() {
        return typePassenger;
    }

    public void setTypePassenger(TypePassenger typePassenger) {
        this.typePassenger = typePassenger;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
