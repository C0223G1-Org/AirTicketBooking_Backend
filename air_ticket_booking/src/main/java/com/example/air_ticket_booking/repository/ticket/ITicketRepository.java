package com.example.air_ticket_booking.repository.ticket;


import com.example.air_ticket_booking.model.customer.Customer;
import com.example.air_ticket_booking.model.luggage.Luggage;
import com.example.air_ticket_booking.model.seat.Seat;
import com.example.air_ticket_booking.model.ticket.Ticket;
import com.example.air_ticket_booking.model.ticket.TypeTicket;
import com.example.air_ticket_booking.model.type_passenger.TypePassenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ITicketRepository extends JpaRepository<Ticket,Long> {

    /**
     *Create by: VuDT
     *Date create: 10/08/2023
     * Function:updateTicket()
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
