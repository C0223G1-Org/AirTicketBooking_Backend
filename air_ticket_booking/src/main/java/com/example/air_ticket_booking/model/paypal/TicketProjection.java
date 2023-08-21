package com.example.air_ticket_booking.model.paypal;

public interface  TicketProjection {
      int getIdTicket();
      String getNameCustomer();

      String getNameRoute();
      String getNameDeparture();
      String getNameDestination();
      String getDateDeparture();
      String getDateArrival();
      double getPriceTicket();
      String getDateBooking();

}
