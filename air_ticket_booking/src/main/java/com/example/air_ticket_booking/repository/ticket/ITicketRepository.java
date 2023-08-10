package com.example.air_ticket_booking.repository.ticket;

import com.example.air_ticket_booking.model.ticket.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional

public interface ITicketRepository extends JpaRepository<Ticket ,Long> {
    /**
     *method :used to create a new ticket when the user confirms the booking
     * created by :NamPC
     * date create: 10/08/2023
     * @param ticket
     * return void
     */

    @Modifying
    @Query (value = "insert into " +
            "ticket(date_booking,price_ticket,seat_id_seat,flag_ticket," +
            "email_passenger,gender_passenger,id_card_passenger,name_passenger,tel_passenger,luggage_id_luggage," +
            "type_passenger_id_type_passenger,type_ticket_id_type_ticket,customer_id_customer)" +
            "value(:#{#ticket.dateBooking},:#{#ticket.priceTicket},:#{#ticket.seat.idSeat}," +
            ":#{#ticket.flagTicket},:#{#ticket.emailPassenger},:#{#ticket.genderPassenger}," +
            ":#{#ticket.idCardPassenger},:#{#ticket.namePassenger},:#{#ticket.telPassenger}," +
            ":#{#ticket.luggage.idLuggage},:#{#ticket.typePassenger.idTypePassenger}," +
            ":#{#ticket.typeTicket.idTypeTicket},:#{#ticket.customer.idCustomer})"
            ,nativeQuery = true)
    void createNewTicket(@Param("ticket")Ticket ticket);
}

