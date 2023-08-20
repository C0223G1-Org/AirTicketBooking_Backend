package com.example.air_ticket_booking.repository.ticket;


import com.example.air_ticket_booking.model.customer.Customer;
import com.example.air_ticket_booking.model.luggage.Luggage;
import com.example.air_ticket_booking.model.seat.Seat;
import com.example.air_ticket_booking.model.ticket.Ticket;
import com.example.air_ticket_booking.model.ticket.TicketSearch;
import com.example.air_ticket_booking.model.ticket.TypeTicket;
import com.example.air_ticket_booking.model.type_passenger.TypePassenger;
import com.example.air_ticket_booking.projection.ITicketPassengerProjection;
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

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface ITicketRepository extends JpaRepository<Ticket, Long> {
    /**
     *method :findTicketByNameAndIdCardPassengers()
     * created by :KietNT
     * date create: 10/08/2023
     * @param namePassenger,idCardPassenger
     * return List Ticket
     */
    @Query(nativeQuery = true,
            value = "select t.id_ticket as id,t.tel_passenger as telPassenger,t.price_ticket as priceTicket,t.name_passenger as namePassenger," +
                    "t.id_card_passenger as idCardPassenger,t.date_booking as dateBooking," +
                    "tp.name_type_passenger as nameTypePassenger,l.name_luggage as nameLuggage," +
                    "tt.name_type_ticket as nameTypeTicket,s.position_seat as positionSeat,ts.name_type_seat as nameTypeSeat," +
                    "r.name_route as nameRoute,r.time_arrival as timeArrival,r.time_departure as timeDeparture," +
                    "r.date_arrival as dateArrival,r.date_departure as dateDeparture,d.name_destination as nameDestination," +
                    "dt.name_departure as nameDeparture,ac.name_air_craft as nameAirCraft from ticket t \n" +
                    "    join type_ticket tt on tt.id_type_ticket = t.type_ticket_id_type_ticket \n" +
                    "    join luggage l on l.id_luggage = t.luggage_id_luggage\n" +
                    "    join type_passenger tp on t.type_passenger_id_type_passenger = tp.id_type_passenger \n" +
                    "    join seat s on t.seat_id_seat = s.id_seat \n" +
                    "    join type_seat ts on s.id_type_seat = ts.id_type_seat \n" +
                    "    join route r on s.id_route = r.id_route \n" +
                    "    join air_craft ac on ac.id_air_craft = r.id_air_craft \n" +
                    "    join destination d on d.id_destination = r.id_destination \n" +
                    "    join departure dt on dt.id_departure = r.id_departure \n" +
                    "    where t.name_passenger like concat('%', :namePassenger, '%') and t.id_card_passenger = :idCardPassenger")

    Page<ITicketPassengerProjection> findTicketByNameAndIdCardPassengers(@Param("namePassenger") String namePassenger,
                                                                         @Param("idCardPassenger") String idCardPassenger, Pageable pageable);

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
        /**
         *Create by: VuDT
         *Date create: 10/08/2023
         * Function:updateTicket()
         * @Param: ticketDto
         * @Return: update Ticket
         */

        @Modifying
        @Query(value = "UPDATE ticket  JOIN customer on ticket.customer_id_customer= customer.id_customer  " +
                "SET ticket.name_passenger = :name, customer.email_customer = :email " +
                "WHERE ticket.id_ticket = :id", nativeQuery = true)
        void updateTicket(@Param("id") Long id, @Param("name") String name, @Param("email") String email);
    @Query(value = "select * from customer where id_customer = :id",nativeQuery = true)
    Customer findCustomerById(@Param("id") Long id);

    /**
     * task take  data from database
     * @Method findAllTickets
     * @param pageable
     * @return Page<Ticket>
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
            "where t.flag_ticket=0 and s.flag_seat=1",nativeQuery = true)
    Page<ITicketProjection> findAllTickets(Pageable pageable);
    /**
     * task delete ticket by ID database
     * @Method deleteTicketById
     * @param id
     * @return
     * @author Nhàn NA
     */
    @javax.transaction.Transactional
    @Modifying
    @Query(value = "update ticket set ticket.flag_ticket=1 where ticket.id_ticket=:id",nativeQuery = true)
    void deleteTicketById(@Param("id")Long id);
    /**
     * task get Ticket by id
     * @Method findByTicket
     * @param id
     * @return
     * @author Nhàn NA
     */
    @Query(value = "select  * from ticket where ticket.flag_ticket=0 and ticket.id_ticket=:id",nativeQuery = true)
    Optional<Ticket> findByTicket(@Param("id")Long id);

    @Query(value ="select id_ticket as id, date_booking as dateBooking, name_passenger as namePassenger, name_route as nameRoute,name_departure as nameDeparture , name_destination as  nameDestination, time_departure as timeDeparture,price_ticket as priceTicket  from ticket t \n" +
            "            join type_ticket tt on t.type_ticket_id_type_ticket = tt.id_type_ticket\n" +
            "            join type_passenger tp on tp.id_type_passenger = t.type_passenger_id_type_passenger\n" +
            "            join customer c on c.id_customer = t.customer_id_customer\n" +
            "            join seat s on s.id_seat=t.seat_id_seat\n" +
            "            join type_seat ts on ts.id_type_seat=s.id_type_seat\n" +
            "            join route r on r.id_route=s.id_route\n" +
            "            join destination d on d.id_destination = r.id_destination\n" +
            "            join air_craft ac on ac.id_air_craft = r.id_air_craft\n" +
            "            join departure de on de.id_departure=r.id_departure\n" +
            "            where  t.flag_ticket=0 and s.flag_seat=1 and  name_passenger like concat('%',:#{#ticketSearch.passenger},'%') and name_departure like concat('%',:#{#ticketSearch.departure},'%') and name_destination like concat('%',:#{#ticketSearch.destination},'%')  and " +
            "            date_departure like concat('%',:#{#ticketSearch.departureDate})",nativeQuery = true)
    Page<ITicketProjection> searchTicketOne(@Param("ticketSearch")TicketSearch ticketSearch, Pageable pageable);
    @Query(value = "SELECT id_ticket AS id,date_booking AS dateBooking,name_passenger AS namePassenger,name_route AS nameRoute,\n" +
            "  name_departure AS nameDeparture,name_destination AS nameDestination,time_departure AS timeDeparture,price_ticket AS priceTicket\n" +
            "FROM\n" +
            "  ticket t\n" +
            "  JOIN seat s ON s.id_seat = t.seat_id_seat\n" +
            "  JOIN route r ON r.id_route = s.id_route\n" +
            "  JOIN departure de ON de.id_departure = r.id_departure\n" +
            "  JOIN destination d ON d.id_destination = r.id_destination\n" +
            "  JOIN type_ticket tt ON t.type_ticket_id_type_ticket = tt.id_type_ticket\n" +
            "  JOIN type_passenger tp ON tp.id_type_passenger = t.type_passenger_id_type_passenger\n" +
            "  JOIN customer c ON c.id_customer = t.customer_id_customer\n" +
            "  JOIN type_seat ts ON ts.id_type_seat = s.id_type_seat\n" +
            "  JOIN air_craft ac ON ac.id_air_craft = r.id_air_craft\n" +
            "WHERE t.flag_ticket=0 and s.flag_seat=1 and :#{#ticketSearch.destinationDate} IN (\n" +
            "    SELECT r.date_departure\n" +
            "    FROM route r\n" +
            "    JOIN seat s ON s.id_route = r.id_route\n" +
            "    JOIN ticket t ON s.id_seat = t.seat_id_seat\n" +
            "    WHERE name_passenger LIKE concat('%',:#{#ticketSearch.passenger},'%') and name_destination Like concat('%',:#{#ticketSearch.departure},'%') and name_departure like concat('%',:#{#ticketSearch.destination},'%')\n" +
            "  )\n" +
            "  AND :#{#ticketSearch.departureDate} IN (\n" +
            "    SELECT r.date_departure\n" +
            "    FROM route r\n" +
            "    JOIN seat s ON s.id_route = r.id_route\n" +
            "    JOIN ticket t ON s.id_seat = t.seat_id_seat\n" +
            "    WHERE  name_passenger LIKE concat('%',:#{#ticketSearch.passenger},'%') and name_departure Like concat('%',:#{#ticketSearch.destination},'%') and name_destination like concat('%',:#{#ticketSearch.departure},'%')\n" +
            "  )",nativeQuery = true)
    Page<ITicketProjection> searchTicketReturn(@Param("ticketSearch")TicketSearch ticketSearch, Pageable pageable);
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
            "where t.flag_ticket=0 and s.flag_seat=1 and  name_passenger like concat('%',:#{#ticketSearch.passenger},'%') " +
            " and position_seat like concat('%',:#{#ticketSearch.chairCode},'%')",nativeQuery = true)
    Page<ITicketProjection> searchSeatPosition(@Param("ticketSearch")TicketSearch ticketSearch, Pageable pageable);
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
            "            where t.flag_ticket=0 and s.flag_seat=1 and  \n" +
            "            name_route like concat('%',:#{#ticketSearch.routeCode},'%')\n" +
            "            and date_departure like  concat('%',:#{#ticketSearch.departureDate},'%')", nativeQuery = true)
    Page<ITicketProjection> searchRouteTicket(@Param("ticketSearch") TicketSearch ticketSearch, Pageable pageable);
    /**
     * task get all tickets  unbooked from database
     * @Method findAllTicketUnbooked
     * @param pageable
     * @return Page<Ticket>
     * @author Nhàn NA
     */
    @Query(value = "SELECT r.id_route AS idRoute, r.name_route AS nameRoute, de.name_departure AS nameDeparture, d.name_destination AS nameDestination, r.time_departure AS timeDeparture, COUNT(*) AS 'soVe'\n" +
            "FROM seat s\n" +
            "JOIN type_seat ts ON ts.id_type_seat = s.id_type_seat\n" +
            "JOIN route r ON r.id_route = s.id_route\n" +
            "JOIN destination d ON d.id_destination = r.id_destination\n" +
            "JOIN air_craft ac ON ac.id_air_craft = r.id_air_craft\n" +
            "JOIN departure de ON de.id_departure = r.id_departure\n" +
            "GROUP BY r.id_route, r.name_route, de.name_departure, d.name_destination, r.time_departure\n" +
            "order by r.id_route ;",nativeQuery = true)
    Page<ITicketUnbookedProjection> findAllTicketUnbooked(Pageable pageable);
    /**
     * task get search all tickets unbooked from database
     * @Method searchTicketUnbooked
     * @param pageable,idTypeSeat,positionSeat,nameRoute,nameDeparture,timeDeparture
     * @return Page<Ticket>
     * @author Nhàn NA
     */



    @Query(value = "SELECT r.id_route AS id, r.name_route AS nameRoute, de.name_departure AS nameDeparture, d.name_destination AS nameDestination,r.date_departure as departureDate, r.time_departure AS timeDeparture,r.price_route as priceTicket ,COUNT(*) AS 'countEmpty'\n" +
            "            FROM seat s\n" +
            "            JOIN type_seat ts ON ts.id_type_seat = s.id_type_seat\n" +
            "            JOIN route r ON r.id_route = s.id_route\n" +
            "            JOIN destination d ON d.id_destination = r.id_destination\n" +
            "            JOIN air_craft ac ON ac.id_air_craft = r.id_air_craft\n" +
            "            JOIN departure de ON de.id_departure = r.id_departure\n" +
            "            where s.flag_seat=0 and name_route like concat('%',:#{#ticketSearch.routeCode},'%')\n" +
            "            GROUP BY r.id_route, r.name_route, de.name_departure, d.name_destination, r.time_departure\n" +
            "            order by r.id_route",
            nativeQuery = true)
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
     *Create by: ThanhVH
     *Date create: 10/08/2023
     * Function:getListPaymentHistory
     * @param id,pageable
     * @return Page<Ticket>
     */

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
            "where customer.id_customer = :id " +
            "and  name_departure like concat('%',:departure, '%')" +
            "and name_destination like concat('%',:destination,'%')" +
            "and flag_ticket = true \n" +
            "order by date_booking desc")
    Page<Ticket> searchAllListPaymentByCustomerById(@Param("id") Long id, Pageable pageable,
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
            "            where t.flag_ticket=0 and s.flag_seat=1 and :#{#ticketSearch.destinationDate} in (\n" +
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
            "and flag_ticket = false")
    List<Ticket> getListTicketByIdCustomer(@Param("id") Long id);


}
