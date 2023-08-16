package com.example.air_ticket_booking.projection;

public interface IRouteCheapestProjection {
    Long getIdRoute();
    String getNameRoute();

    String getTimeArrival();

    String getTimeDeparture();

    String getDateArrival();

    String getDateDeparture();

    Long getPriceRoute();

    String getNameDestination();

    String getNameDeparture();

    String getNameAirCraft();
    String getImageDestination();
}
