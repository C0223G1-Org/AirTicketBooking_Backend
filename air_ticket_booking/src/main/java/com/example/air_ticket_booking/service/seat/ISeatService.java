package com.example.air_ticket_booking.service.seat;
import com.example.air_ticket_booking.model.projection_tdns.SeatProjection;
import java.util.List;

public interface ISeatService {
    /**
     * create by : SangTDN
     * @param idRoute
     * @return list SeatProjection (see details in path air_ticket_booking/model/projection_tdns/SeatProjection.java)
     * it is abstract method
     */
    List<SeatProjection> showListSeatEmptyByRoute( Long idRoute );
}
