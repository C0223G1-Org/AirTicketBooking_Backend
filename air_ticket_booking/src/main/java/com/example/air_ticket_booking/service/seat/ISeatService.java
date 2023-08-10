package com.example.air_ticket_booking.service.seat;
import com.example.air_ticket_booking.model.projection_tdns.SeatProjection;
import java.util.List;

import com.example.air_ticket_booking.model.seat.Seat;
import com.example.air_ticket_booking.model.seat.TypeSeat;

public interface ISeatService {
    /**
     * create by : SangTDN
     * @param idRoute
     * @return list SeatProjection (see details in path air_ticket_booking/model/projection_tdns/SeatProjection.java)
     * it is abstract method
     */
    List<SeatProjection> showListSeatEmptyByRoute( Long idRoute );
    /**
     *method :find seat  by id in service
     * created by :NamPC
     * date create: 10/08/2023
     * @param id
     * return Seat
     */
    Seat findSeatById(Long id);
}
