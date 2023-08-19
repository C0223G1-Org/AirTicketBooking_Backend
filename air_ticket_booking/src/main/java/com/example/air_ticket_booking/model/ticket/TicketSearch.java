package com.example.air_ticket_booking.model.ticket;

public class TicketSearch {
    private int typeTicket;
    private String departure;
    private String destination;
    private String departureDate;
    private String destinationDate;
    private String passenger;
    private String seatCode;
    private String routeCode;
    private String chairCode;
    private int idSearch;
    private boolean hasParameter;
    public TicketSearch() {
        hasParameter=false;
    }

    public TicketSearch(int typeTicket, String departure, String destination, String departureDate, String destinationDate, String passenger, String seatCode, String routeCode, String chairCode, int idSearch) {
        this.typeTicket = typeTicket;
        this.departure = departure;
        this.destination = destination;
        this.departureDate = departureDate;
        this.destinationDate = destinationDate;
        this.passenger = passenger;
        this.seatCode = seatCode;
        this.routeCode = routeCode;
        this.chairCode = chairCode;
        this.idSearch = idSearch;
    }


    public TicketSearch(int typeTicket, String departure, String destination, String departureDate, String destinationDate, String passenger, int idSearch) {
        this.typeTicket = typeTicket;
        this.departure = departure;
        this.destination = destination;
        this.departureDate = departureDate;
        this.destinationDate = destinationDate;
        this.passenger = passenger;
        this.idSearch = idSearch;
        hasParameter=true;
    }

    public TicketSearch(String passenger, String chairCode, int idSearch,boolean hasParameter) {
        this.passenger = passenger;
        this.chairCode = chairCode;
        this.idSearch = idSearch;
        this.hasParameter=true;
    }

    public TicketSearch(String routeCode, String chairCode,boolean hasParameter) {
        this.routeCode = routeCode;
        this.chairCode = chairCode;
        this.hasParameter=true;
    }

    public TicketSearch(String departure, String departureDate, String routeCode, int idSearch,boolean hasParameter) {
        this.departure = departure;
        this.departureDate = departureDate;
        this.routeCode = routeCode;
        this.idSearch = idSearch;
        this.hasParameter=true;
    }


    public int getIdSearch() {
        return idSearch;
    }

    public void setIdSearch(int idSearch) {
        this.idSearch = idSearch;
    }

    public int getTypeTicket() {
        return typeTicket;
    }

    public void setTypeTicket(int typeTicket) {
        this.typeTicket = typeTicket;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDestinationDate() {
        return destinationDate;
    }

    public void setDestinationDate(String destinationDate) {
        this.destinationDate = destinationDate;
    }

    public String getPassenger() {
        return passenger;
    }

    public void setPassenger(String passenger) {
        this.passenger = passenger;
    }

    public String getSeatCode() {
        return seatCode;
    }

    public void setSeatCode(String seatCode) {
        this.seatCode = seatCode;
    }

    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    public String getChairCode() {
        return chairCode;
    }

    public void setChairCode(String chairCode) {
        this.chairCode = chairCode;
    }

    public boolean isHasParameter() {
        return hasParameter;
    }

    public void setHasParameter(boolean hasParameter) {
        this.hasParameter = hasParameter;
    }
}
