package com.example.air_ticket_booking.model.route;

import javax.persistence.*;


@Entity
@Table(name="route")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRoute;
    private String nameRoute;
    private String timeArrival;
    private String timeDeparture;
    private String dateArrival;
    private String dateDeparture;
    private boolean flagRoute;
    private Long priceRoute;
    @ManyToOne
    @JoinColumn(name="id_Destination")
    private Destination destination;
    @ManyToOne
    @JoinColumn(name="id_departure")
    private Departure departure;
    @ManyToOne
    @JoinColumn(name="id_air_craft")
    private AirCraft airCraft;

    public Route() {
    }

    public Route(Long idRoute, String nameRoute, String timeArrival, String timeDeparture, String dateArrival, String dateDeparture, boolean flagRoute, Long priceRoute, Destination destination, Departure departure, AirCraft airCraft) {
        this.idRoute = idRoute;
        this.nameRoute = nameRoute;
        this.timeArrival = timeArrival;
        this.timeDeparture = timeDeparture;
        this.dateArrival = dateArrival;
        this.dateDeparture = dateDeparture;
        this.flagRoute = flagRoute;
        this.priceRoute = priceRoute;
        this.destination = destination;
        this.departure = departure;
        this.airCraft = airCraft;
    }

    public Long getIdRoute() {
        return idRoute;
    }

    public void setIdRoute(Long idRoute) {
        this.idRoute = idRoute;
    }

    public String getNameRoute() {
        return nameRoute;
    }

    public void setNameRoute(String nameRoute) {
        this.nameRoute = nameRoute;
    }

    public String getTimeArrival() {
        return timeArrival;
    }

    public void setTimeArrival(String timeArrival) {
        this.timeArrival = timeArrival;
    }

    public String getTimeDeparture() {
        return timeDeparture;
    }

    public void setTimeDeparture(String timeDeparture) {
        this.timeDeparture = timeDeparture;
    }

    public String getDateArrival() {
        return dateArrival;
    }

    public void setDateArrival(String dateArrival) {
        this.dateArrival = dateArrival;
    }

    public String getDateDeparture() {
        return dateDeparture;
    }

    public void setDateDeparture(String dateDeparture) {
        this.dateDeparture = dateDeparture;
    }

    public boolean isFlagRoute() {
        return flagRoute;
    }

    public void setFlagRoute(boolean flagRoute) {
        this.flagRoute = flagRoute;
    }

    public Long getPriceRoute() {
        return priceRoute;
    }

    public void setPriceRoute(Long priceRoute) {
        this.priceRoute = priceRoute;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public Departure getDeparture() {
        return departure;
    }

    public void setDeparture(Departure departure) {
        this.departure = departure;
    }

    public AirCraft getAirCraft() {
        return airCraft;
    }

    public void setAirCraft(AirCraft airCraft) {
        this.airCraft = airCraft;
    }
}