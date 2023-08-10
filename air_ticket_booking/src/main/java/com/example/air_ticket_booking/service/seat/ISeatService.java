package com.example.air_ticket_booking.service.seat;

import com.example.air_ticket_booking.model.projection_tdns.SeatProjection;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISeatService {
    List<SeatProjection> showListSeatEmptyByRoute( Long idRoute );
}
