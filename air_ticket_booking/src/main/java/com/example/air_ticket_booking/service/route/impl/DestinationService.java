package com.example.air_ticket_booking.service.route.impl;

import com.example.air_ticket_booking.model.route.Destination;
import com.example.air_ticket_booking.repository.route.IDestinationRepository;
import com.example.air_ticket_booking.service.route.IDestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationService implements IDestinationService {
    @Autowired
    private IDestinationRepository destinationRepository;
    /**
     * method dùng để lấy danh sách tất cả các điểm đến để hiển thị lên form tìm kiếm chuyến bay
     * @author ThaiVV
     * @since 10/08/2023
     * @return List<Destination>
     */
    @Override
    public List<Destination> getAll() {
        return destinationRepository.getAllDestination();
    }
}
