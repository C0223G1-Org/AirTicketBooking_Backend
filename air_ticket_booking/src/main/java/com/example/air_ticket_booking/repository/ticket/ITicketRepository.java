package com.example.air_ticket_booking.repository.ticket;


import com.example.air_ticket_booking.model.customer.Customer;
import com.example.air_ticket_booking.model.luggage.Luggage;
import com.example.air_ticket_booking.model.route.Route;
import com.example.air_ticket_booking.model.seat.Seat;
import com.example.air_ticket_booking.model.ticket.Ticket;
import com.example.air_ticket_booking.model.ticket.TypeTicket;
import com.example.air_ticket_booking.model.type_passenger.TypePassenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ITicketRepository extends JpaRepository<Ticket, Long> {
    /**
     * method :findTicketByNameAndIdCardPassengers()
     * created by :KietNT
     * date create: 10/08/2023
     *
     * @param namePassenger,idCardPassenger return List Ticket
     */
    @Query(nativeQuery = true,
            value = "select * from ticket where name_passenger like concat('%', :namePassenger, '%') and id_card_passenger = :idCardPassenger;")
    List<Ticket> findTicketByNameAndIdCardPassengers(@Param("namePassenger") String namePassenger,
                                                     @Param("idCardPassenger") String idCardPassenger);

    /**
     * method :used to create a new ticket when the user confirms the booking
     * created by :NamPC
     * date create: 10/08/2023
     *
     * @param ticket return void
     */
    @Modifying
    @Query(value = "insert into " +
            "ticket(date_booking,price_ticket,seat_id_seat,flag_ticket," +
            "email_passenger,gender_passenger,id_card_passenger,name_passenger,tel_passenger,luggage_id_luggage," +
            "type_passenger_id_type_passenger,type_ticket_id_type_ticket,customer_id_customer)" +
            "value(:#{#ticket.dateBooking},:#{#ticket.priceTicket},:#{#ticket.seat.idSeat}," +
            ":#{#ticket.flagTicket},:#{#ticket.emailPassenger},:#{#ticket.genderPassenger}," +
            ":#{#ticket.idCardPassenger},:#{#ticket.namePassenger},:#{#ticket.telPassenger}," +
            ":#{#ticket.luggage.idLuggage},:#{#ticket.typePassenger.idTypePassenger}," +
            ":#{#ticket.typeTicket.idTypeTicket},:#{#ticket.customer.idCustomer})"
            , nativeQuery = true)
    void createNewTicket(@Param("ticket") Ticket ticket);

    /**
     * Create by: VuDT
     * Date create: 10/08/2023
     * Function:updateTicket()
     *
     * @Param: ticketDto
     * @Return: void
     */

    @Modifying
    @Query("UPDATE Ticket t SET t.priceTicket = :price, t.flagTicket = :flag, t.namePassenger = :name, t.genderPassenger = :gender," +
            " t.emailPassenger = :email, t.telPassenger = :tel, t.idCardPassenger = :idCard, t.dateBooking = :dateBooking, " +
            "t.typeTicket = :typeTicket, t.luggage = :luggage, t.typePassenger = :typePassenger, t.seat = :seat, " +
            "t.customer = :customer WHERE t.idTicket = :id")
    void updateTicket(@Param("id") Long id, @Param("price") Long price, @Param("flag") Boolean flag, @Param("name") String name,
                      @Param("gender") Boolean gender, @Param("email") String email, @Param("tel") String tel, @Param("idCard") String idCard, @Param("dateBooking") String dateBooking, @Param("typeTicket") TypeTicket typeTicket, @Param("luggage") Luggage luggage, @Param("typePassenger") TypePassenger typePassenger, @Param("seat") Seat seat, @Param("customer") Customer customer);

    @Query(value = "select * from ticket where id_ticket = :id ", nativeQuery = true)
    Ticket findTicketById(@Param("id") Long id);


}
