package com.example.air_ticket_booking.projection;

public interface ITicketProjection {
    Long getId();
    String getDateBooking();
    String getNamePassenger();
    String getNameRoute();
    String getNameDeparture();
    String getNameDestination();
    String getTimeDeparture();
    String getPriceTicket();
}
