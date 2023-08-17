package com.example.air_ticket_booking.projection;

public interface ITicketUnbookedProjection {
    Long getId();
    String getNameRoute();
    String getNameDeparture();
    String getNameDestination();
    String getTimeDeparture();
    int getCountEmpty();
    Long getPriceTicket();

}
