package com.example.air_ticket_booking.repository.ticket;

import com.example.air_ticket_booking.model.ticket.TypeTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITypeTicketRepository extends JpaRepository<TypeTicket,Long> {
    @Query(nativeQuery = true,value = "select * from type_ticket")
    List<TypeTicket> findAllTypeTicket();
}
