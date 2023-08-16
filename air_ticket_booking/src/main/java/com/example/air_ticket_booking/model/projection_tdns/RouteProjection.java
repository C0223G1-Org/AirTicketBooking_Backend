package com.example.air_ticket_booking.model.projection_tdns;

/**
 * create by : Sang TDN
 */
public interface RouteProjection {
    Long getIdRoute();

    String getDateArrival();

    String getDateDeparture();

    String getNameRoute();

    Long getPriceRoute();

    String getTimeArrival();

    String getTimeDeparture();

    String getNameAirCraft();

    String getNameDestination();

    String getNameDeparture();

    int getSeatsBussinessRemaining();

    int getSeatsSkybossRemaining();

    int getSeatsVeluxeRemaining();

    int getSeatsEcoRemaining();

    double getPriceExtraBussiness();

    double getPriceExtraSkyboss();

    double getPriceExtraVeluxe();

    double getPriceExtraEco();
}
