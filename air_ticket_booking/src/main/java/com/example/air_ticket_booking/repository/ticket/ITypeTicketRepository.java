package com.example.air_ticket_booking.repository.ticket;

import com.example.air_ticket_booking.model.ticket.TypeTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITypeTicketRepository extends JpaRepository<TypeTicket, Long> {
    /**
     *method :find  type ticket  by id
     * created by :NamPC
     * date create: 10/08/2023
     * @param id
     * return TypeTicket
     */
    @Query(value = "select * from type_ticket where id_type_ticket=:id", nativeQuery = true)
    TypeTicket findTypeTicketById(@Param("id") Long id);
}
