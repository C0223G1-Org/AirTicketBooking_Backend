package com.example.air_ticket_booking.repository.route;

import com.example.air_ticket_booking.model.route.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IDestinationRepository extends JpaRepository<Destination, Long> {
    /**
     * method dùng để lấy danh sách tất cả các điểm đến để hiển thị lên form tìm kiếm chuyến bay
     * @author ThaiVV
     * @since 10/08/2023
     * @return List<Destination>
     */
    @Query(nativeQuery = true, value = "select * from destination")
    List<Destination> getAllDestination();
}
