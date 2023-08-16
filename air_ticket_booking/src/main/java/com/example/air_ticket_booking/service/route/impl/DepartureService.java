package com.example.air_ticket_booking.service.route.impl;

import com.example.air_ticket_booking.model.route.Departure;
import com.example.air_ticket_booking.repository.route.IDepartureRepository;
import com.example.air_ticket_booking.service.route.IDepartureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartureService implements IDepartureService {
    @Autowired
    private IDepartureRepository departureRepository;
    /**
     * method dùng để lấy danh sách tất cả các điểm đi để hiển thị lên form tìm kiếm chuyến bay
     * @author ThaiVV
     * @since 10/08/2023
     * @return List<Departure>
     */
    @Override
    public List<Departure> getAll() {
        return departureRepository.getAllDeparture();
    }
}
