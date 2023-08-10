package com.example.air_ticket_booking.projection;

public interface ITicketUnbookedProjection {
    Long getId();
    String getPositionSeat();
    String getTypeSeat();
    String getNameRoute();
    String getNameDeparture();
    String getNameDestination();
    String getTimeDeparture();
}
