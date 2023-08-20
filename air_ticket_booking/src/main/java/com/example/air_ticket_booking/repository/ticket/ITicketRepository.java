package com.example.air_ticket_booking.repository.ticket;


import com.example.air_ticket_booking.model.customer.Customer;
import com.example.air_ticket_booking.model.luggage.Luggage;
import com.example.air_ticket_booking.model.paypal.TicketProjection;
import com.example.air_ticket_booking.model.seat.Seat;
import com.example.air_ticket_booking.model.ticket.Ticket;
import com.example.air_ticket_booking.model.ticket.TicketSearch;
import com.example.air_ticket_booking.model.ticket.TypeTicket;
import com.example.air_ticket_booking.model.type_passenger.TypePassenger;
import com.example.air_ticket_booking.projection.ITicketProjection;
import com.example.air_ticket_booking.projection.ITicketUnbookedProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

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
     * @Return: update Ticket
     */

    @Modifying
    @Query(value = "UPDATE ticket  JOIN customer on ticket.customer_id_customer= customer.id_customer  " +
            "SET ticket.name_passenger = :name, customer.email_customer = :email " +
            "WHERE ticket.id_ticket = :id", nativeQuery = true)
    void updateTicket(@Param("id") Long id, @Param("name") String name, @Param("email") String email);

    @Query(value = "select * from customer where id_customer = :id", nativeQuery = true)
    Customer findCustomerById(@Param("id") Long id);

    /**
     * task take  data from database
     *
     * @param pageable
     * @return Page<Ticket>
     * @Method findAllTickets
     * @author Nhàn NA
     */
    @Query(value = "select id_ticket as id, date_booking as dateBooking, name_passenger as namePassenger, name_route as nameRoute,name_departure as nameDeparture , name_destination as  nameDestination, time_departure as timeDeparture,price_ticket as priceTicket  from ticket t \n" +
            "join type_ticket tt on t.type_ticket_id_type_ticket = tt.id_type_ticket\n" +
            "join luggage l on l.id_luggage=t.luggage_id_luggage\n" +
            "join type_passenger tp on tp.id_type_passenger = t.type_passenger_id_type_passenger\n" +
            "join customer c on c.id_customer = t.customer_id_customer\n" +
            "join seat s on s.id_seat=t.seat_id_seat\n" +
            "join type_seat ts on ts.id_type_seat=s.id_type_seat\n" +
            "join route r on r.id_route=s.id_route\n" +
            "join destination d on d.id_destination = r.id_destination\n" +
            "join air_craft ac on ac.id_air_craft = r.id_air_craft\n" +
            "join departure de on de.id_departure=r.id_departure\n" +
            "where t.flag_ticket=0", nativeQuery = true)
    Page<ITicketProjection> findAllTickets(Pageable pageable);

    /**
     * task delete ticket by ID database
     *
     * @param id
     * @return
     * @Method deleteTicketById
     * @author Nhàn NA
     */
    @javax.transaction.Transactional
    @Modifying
    @Query(value = "update ticket set ticket.flag_ticket=1 where ticket.id_ticket=:id", nativeQuery = true)
    void deleteTicketById(@Param("id") Long id);

    /**
     * task get Ticket by id
     *
     * @param id
     * @return
     * @Method findByTicket
     * @author Nhàn NA
     */
    @Query(value = "select  * from ticket where ticket.flag_ticket=0 and ticket.id_ticket=:id", nativeQuery = true)
    Optional<Ticket> findByTicket(@Param("id") Long id);

    @Query(value = "select id_ticket as id, date_booking as dateBooking, name_passenger as namePassenger, name_route as nameRoute,name_departure as nameDeparture , name_destination as  nameDestination, time_departure as timeDeparture,price_ticket as priceTicket  from ticket t \n" +
            "join type_ticket tt on t.type_ticket_id_type_ticket = tt.id_type_ticket\n" +
            "join type_passenger tp on tp.id_type_passenger = t.type_passenger_id_type_passenger\n" +
            "join customer c on c.id_customer = t.customer_id_customer\n" +
            "join seat s on s.id_seat=t.seat_id_seat\n" +
            "join type_seat ts on ts.id_type_seat=s.id_type_seat\n" +
            "join route r on r.id_route=s.id_route\n" +
            "join destination d on d.id_destination = r.id_destination\n" +
            "join air_craft ac on ac.id_air_craft = r.id_air_craft\n" +
            "join departure de on de.id_departure=r.id_departure\n" +
            "where t.flag_ticket=0 and tt.id_type_ticket=:#{#ticketSearch.typeTicket} and name_passenger like concat('%',:#{#ticketSearch.passenger},'%') " +
            "and name_route like concat('%',:#{#ticketSearch.routeCode},'%') and  name_destination like concat('%',:#{#ticketSearch.destination},'%') " +
            "and name_departure like concat('%',:#{#ticketSearch.departure},'%') and position_seat like concat('%',:#{#ticketSearch.seatCode},'%')" +
            "and date_departure like :#{#ticketSearch.departureDate} and date_arrival like :#{#ticketSearch.destinationDate}", nativeQuery = true)
    Page<ITicketProjection> searchTicket(@Param("ticketSearch") TicketSearch ticketSearch, Pageable pageable);

    @Query(value = "select id_ticket as id, date_booking as dateBooking, name_passenger as namePassenger, name_route as nameRoute,name_departure as nameDeparture , name_destination as  nameDestination, time_departure as timeDeparture,price_ticket as priceTicket  from ticket t \n" +
            "join type_ticket tt on t.type_ticket_id_type_ticket = tt.id_type_ticket\n" +
            "join type_passenger tp on tp.id_type_passenger = t.type_passenger_id_type_passenger\n" +
            "join customer c on c.id_customer = t.customer_id_customer\n" +
            "join seat s on s.id_seat=t.seat_id_seat\n" +
            "join type_seat ts on ts.id_type_seat=s.id_type_seat\n" +
            "join route r on r.id_route=s.id_route\n" +
            "join destination d on d.id_destination = r.id_destination\n" +
            "join air_craft ac on ac.id_air_craft = r.id_air_craft\n" +
            "join departure de on de.id_departure=r.id_departure\n" +
            "where t.flag_ticket=0 and  name_passenger like concat('%',:#{#ticketSearch.passenger},'%') " +
            " and position_seat like concat('%',:#{#ticketSearch.chairCode},'%')", nativeQuery = true)
    Page<ITicketProjection> searchSeatPosition(@Param("ticketSearch") TicketSearch ticketSearch, Pageable pageable);

    @Query(value = "select id_ticket as id, date_booking as dateBooking, name_passenger as namePassenger, name_route as nameRoute,name_departure as nameDeparture , name_destination as  nameDestination, time_departure as timeDeparture,price_ticket as priceTicket  from ticket t \n" +
            "join type_ticket tt on t.type_ticket_id_type_ticket = tt.id_type_ticket\n" +
            "join type_passenger tp on tp.id_type_passenger = t.type_passenger_id_type_passenger\n" +
            "join customer c on c.id_customer = t.customer_id_customer\n" +
            "join seat s on s.id_seat=t.seat_id_seat\n" +
            "join type_seat ts on ts.id_type_seat=s.id_type_seat\n" +
            "join route r on r.id_route=s.id_route\n" +
            "join destination d on d.id_destination = r.id_destination\n" +
            "join air_craft ac on ac.id_air_craft = r.id_air_craft\n" +
            "join departure de on de.id_departure=r.id_departure\n" +
            "where t.flag_ticket=0 and  " +
            " name_route like concat('%',:#{#ticketSearch.routeCode},'%')" +
            "and date_departure like  :#{#ticketSearch.departureDate} ", nativeQuery = true)
    Page<ITicketProjection> searchRouteTicket(@Param("ticketSearch") TicketSearch ticketSearch, Pageable pageable);

    /**
     * task get all tickets  unbooked from database
     *
     * @param pageable
     * @return Page<Ticket>
     * @Method findAllTicketUnbooked
     * @author Nhàn NA
     */
    @Query(value = "select id_seat as id ,position_seat as positionSeat,name_type_seat as typeSeat, name_route as nameRoute,name_departure as nameDeparture , name_destination as  nameDestination, time_departure as timeDeparture  from seat s\n" +
            "join type_seat ts on ts.id_type_seat=s.id_type_seat\n" +
            "join route r on r.id_route=s.id_route\n" +
            "join destination d on d.id_destination = r.id_destination\n" +
            "join air_craft ac on ac.id_air_craft = r.id_air_craft\n" +
            "join departure de on de.id_departure=r.id_departure\n" +
            "where s.flag_seat=0", nativeQuery = true)
    Page<ITicketUnbookedProjection> findAllTicketUnbooked(Pageable pageable);

    /**
     * task get search all tickets unbooked from database
     *
     * @param pageable,idTypeSeat,positionSeat,nameRoute,nameDeparture,timeDeparture
     * @return Page<Ticket>
     * @Method searchTicketUnbooked
     * @author Nhàn NA
     */


    @Query(value = "select id_seat as id ,position_seat as positionSeat,name_type_seat as typeSeat, name_route as nameRoute,name_departure as nameDeparture , name_destination as  nameDestination, time_departure as timeDeparture  from seat s\n" +
            "join type_seat ts on ts.id_type_seat=s.id_type_seat\n" +
            "join route r on r.id_route=s.id_route\n" +
            "join destination d on d.id_destination = r.id_destination\n" +
            "join air_craft ac on ac.id_air_craft = r.id_air_craft\n" +
            "join departure de on de.id_departure=r.id_departure\n" +
            "where s.flag_seat=0 and  name_route like concat('%',:#{#ticketSearch.routeCode},'%') and position_seat like concat('%',:#{#ticketSearch.chairCode},'%')  ", nativeQuery = true)
    Page<ITicketUnbookedProjection> searchTicketUnbooked(@Param("ticketSearch") TicketSearch ticketSearch, Pageable pageable);

//    @Query(value = "select id_seat as id ,position_seat as positionSeat,name_type_seat as typeSeat, name_route as nameRoute,name_departure as nameDeparture , name_destination as  nameDestination, time_departure as timeDeparture  from seat s\n" +
//            "join type_seat ts on ts.id_type_seat=s.id_type_seat\n" +
//            "join route r on r.id_route=s.id_route\n" +
//            "join destination d on d.id_destination = r.id_destination\n" +
//            "join air_craft ac on ac.id_air_craft = r.id_air_craft\n" +
//            "join departure de on de.id_departure=r.id_departure\n" +
//            "where s.flag_seat=0 and ts.id_type_seat=:idTypeSeat and position_seat Like concat('%',:positionSeat,'%') and name_route like concat('%',:nameRoute,'%') and name_departure like concat('%',:nameDeparture,'%') and name_destination like concat('%',nameDestination,'%')",nativeQuery = true)
//    Page<ITicketUnbookedProjection> searchTicketUnbooked(@Param("idTypeSeat")Long idTypeSeat,@Param("positionSeat")String positionSeat,@Param("nameRoute")String nameRoute,@Param("nameDeparture") String nameDeparture,@Param("nameDestination")String nameDestination,Pageable pageable);


    /**
     * Create by: ThanhVH
     * Date create: 10/08/2023
     * Function:getListPaymentHistory
     *
     * @param id,pageable
     * @return Page<Ticket>
     */

    @Query(nativeQuery = true, value = "SELECT MAX(ticket.id_ticket) AS idTicket, customer.name_customer as nameCustomer ,route.name_route as nameRoute , departure.name_departure as nameDeparture, destination.name_destination as nameDestination ,\n" +
            "                                 route.date_departure as dateDeparture, route.date_arrival as dateArrival , ticket.date_booking as dateBooking,\n" +
            "                                 sum(ticket.price_ticket) as priceTicket \n" +
            "FROM ticket\n" +
            "JOIN customer ON customer.id_customer = ticket.customer_id_customer\n" +
            "JOIN seat ON seat.id_seat = ticket.seat_id_seat\n" +
            "JOIN route ON route.id_route = seat.id_route\n" +
            "JOIN air_craft ON air_craft.id_air_craft = route.id_air_craft\n" +
            "JOIN destination ON destination.id_destination = route.id_destination\n" +
            "JOIN departure ON departure.id_departure = route.id_departure\n" +
            "JOIN type_seat ON seat.id_type_seat = type_seat.id_type_seat\n" +
            "JOIN luggage ON luggage.id_luggage = ticket.luggage_id_luggage\n" +
            "JOIN type_ticket ON type_ticket.id_type_ticket = ticket.type_ticket_id_type_ticket\n" +
            "JOIN type_passenger ON type_passenger.id_type_passenger = ticket.type_passenger_id_type_passenger\n" +
            "WHERE customer.id_customer = :id \n" +
            "  AND name_departure LIKE concat('%',:departure,'%')\n" +
            "   AND name_destination LIKE concat('%',:destination,'%')\n" +
            "  AND flag_ticket = true\n" +
            "GROUP BY  route.name_route, departure.name_departure,destination.name_destination,ticket.date_booking, route.date_departure, route.date_arrival\n" +
            "ORDER BY MAX(ticket.date_booking) DESC")
    Page<TicketProjection> searchAllListPaymentByCustomerById(@Param("id") Long id, Pageable pageable,
                                                              @Param("departure") String departure, @Param("destination") String destination);

    @Modifying
    @Query(nativeQuery = true, value = "UPDATE ticket " +
            "SET ticket.flag_ticket = true \n" +
            "WHERE ticket.id_ticket = :id")
    void updateTicketByIdTicket(@Param("id") Long id);

    @Query(value = "select  * from ticket where ticket.flag_ticket=0 and ticket.id_ticket=:id", nativeQuery = true)
    Ticket findByTicketById(@Param("id") Long id);

    @Query(value = "select id_ticket as id, date_booking as dateBooking, name_passenger as namePassenger, name_route as nameRoute,name_departure as nameDeparture , name_destination as  nameDestination, time_departure as timeDeparture,price_ticket as priceTicket  from ticket t \n" +
            "            join type_ticket tt on t.type_ticket_id_type_ticket = tt.id_type_ticket\n" +
            "            join type_passenger tp on tp.id_type_passenger = t.type_passenger_id_type_passenger\n" +
            "            join customer c on c.id_customer = t.customer_id_customer\n" +
            "            join seat s on s.id_seat=t.seat_id_seat\n" +
            "            join type_seat ts on ts.id_type_seat=s.id_type_seat\n" +
            "            join route r on r.id_route=s.id_route\n" +
            "            join destination d on d.id_destination = r.id_destination\n" +
            "            join air_craft ac on ac.id_air_craft = r.id_air_craft\n" +
            "            join departure de on de.id_departure=r.id_departure\n" +
            "            where :#{#ticketSearch.destinationDate} in (\n" +
            "            select * from( select r.date_departure from route r\n" +
            "            join departure de on r.id_departure=de.id_departure\n" +
            "            join seat s on s.id_route=r.id_route\n" +
            "            join ticket t on t.seat_id_seat=s.id_seat\n" +
            "            join type_ticket tt on t.type_ticket_id_type_ticket = tt.id_type_ticket\n" +
            "            join type_passenger tp on tp.id_type_passenger = t.type_passenger_id_type_passenger\n" +
            "            join customer c on c.id_customer = t.customer_id_customer\n" +
            "            join type_seat ts on ts.id_type_seat=s.id_type_seat\n" +
            "            join destination d on d.id_destination = r.id_destination\n" +
            "            join air_craft ac on ac.id_air_craft = r.id_air_craft\n" +
            "            where t.type_ticket_id_type_ticket=2 and de.name_departure like concat('',:#{#ticketSearch.departure})\n" +
            "            and d.name_destination like concat('%',:#{#ticketSearch.destination}) and t.namePassenger like concat('%',:#{#ticketSearch.passenger})" +
            "            ) as ticket_a);\n", nativeQuery = true)
    Page<ITicketProjection> getSearchReturn(@Param("ticketSearch") TicketSearch ticketSearch, Pageable pageable);

    @Query(nativeQuery = true, value = "select * from ticket " +
            "join customer on customer.id_customer = ticket.customer_id_customer \n" +
            "join seat on seat.id_seat = ticket.seat_id_seat \n" +
            "join route on route.id_route = seat.id_route \n " +
            "join air_craft on air_craft.id_air_craft = route.id_air_craft\n" +
            "join destination on destination.id_destination = route.id_destination \n" +
            "join departure on departure.id_departure = route.id_departure \n" +
            "join type_seat on seat.id_type_seat = type_seat.id_type_seat \n" +
            "join luggage on luggage.id_luggage = ticket.luggage_id_luggage \n" +
            "join type_ticket on type_ticket.id_type_ticket = ticket.type_ticket_id_type_ticket \n" +
            "join type_passenger on type_passenger.id_type_passenger = ticket.type_passenger_id_type_passenger \n" +
            "where customer.id_customer = :id \n" +
            "and flag_ticket = false " +
            "order by ticket.date_booking desc limit :num")
    List<Ticket> getListTicketByIdCustomer(@Param("id") Long id, @Param("num") Integer num);
            "and flag_ticket = false")
    List<Ticket> getListTicketByIdCustomer(@Param("id") Long id);
    @Query(nativeQuery = true, value = "select * from ticket " +
            "join customer on customer.id_customer = ticket.customer_id_customer \n" +
            "join seat on seat.id_seat = ticket.seat_id_seat \n" +
            "join route on route.id_route = seat.id_route \n " +
            "join air_craft on air_craft.id_air_craft = route.id_air_craft\n" +
            "join destination on destination.id_destination = route.id_destination \n" +
            "join departure on departure.id_departure = route.id_departure \n" +
            "join type_seat on seat.id_type_seat = type_seat.id_type_seat \n" +
            "join luggage on luggage.id_luggage = ticket.luggage_id_luggage \n" +
            "join type_ticket on type_ticket.id_type_ticket = ticket.type_ticket_id_type_ticket \n" +
            "join type_passenger on type_passenger.id_type_passenger = ticket.type_passenger_id_type_passenger \n" +
            "where name_departure like concat('%', :nameDeparture,'%') " +
            "and name_destination like concat('%',:nameDestination ,'%') \n" +
            "and date_booking = :dateBooking \n" +
            "and flag_ticket = true")
    List<Ticket> getListTicketByRoute (@Param("nameDeparture") String nameDeparture,
                                       @Param("nameDestination") String nameDestination,
                                       @Param("dateBooking") String dateBooking);


    @Modifying
    @Query(nativeQuery = true, value = "delete from ticket\n" +
            "where flag_ticket = false and customer_id_customer = :customer_id_customer  ")
    void deleteTicketFlagIsFalse(@Param("customer_id_customer") Long customer_id_customer);

}
