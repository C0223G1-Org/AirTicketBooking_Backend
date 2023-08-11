
package com.example.air_ticket_booking.repository.ticket;

import com.example.air_ticket_booking.model.ticket.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ITicketRepository extends JpaRepository<Ticket, Long> {
    /**
     *method :findTicketByNameAndIdCardPassengers()
     * created by :KietNT
     * date create: 10/08/2023
     * @param namePassenger,idCardPassenger
     * return List Ticket
     */
    @Query(nativeQuery = true,
            value = " select * from ticket t\n" +
                    "    join type_ticket tt on tt.id_type_ticket = t.type_ticket_id_type_ticket\n" +
                    "    join luggage l on l.id_luggage = t.luggage_id_luggage\n" +
                    "    join type_passenger tp on t.type_passenger_id_type_passenger = tp.id_type_passenger\n" +
                    "    join seat s on t.seat_id_seat = s.id_seat\n" +
                    "    join type_seat ts on s.id_type_seat = ts.id_type_seat\n" +
                    "    join route r on s.id_route = r.id_route\n" +
                    "    join air_craft ac on ac.id_air_craft = r.id_air_craft\n" +
                    "    join destination d on d.id_destination = r.id_destination\n" +
                    "    join departure dt on dt.id_departure = r.id_departure\n" +
                    "    where t.name_passenger like concat('%', :namePassenger, '%') and t.id_card_passenger = :idCardPassenger;")
    List<Ticket> findTicketByNameAndIdCardPassengers(@Param("namePassenger") String namePassenger,
                                                     @Param("idCardPassenger") String idCardPassenger);
}
