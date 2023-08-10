package com.example.air_ticket_booking.repository.luggage;

import com.example.air_ticket_booking.model.luggage.Luggage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILuggageRepository extends JpaRepository<Luggage,Long> {

}
