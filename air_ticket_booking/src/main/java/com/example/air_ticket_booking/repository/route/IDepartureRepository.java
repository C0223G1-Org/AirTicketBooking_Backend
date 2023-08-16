package com.example.air_ticket_booking.repository.route;

import com.example.air_ticket_booking.model.route.Departure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IDepartureRepository extends JpaRepository<Departure, Long> {
    /**
     * method dùng để lấy danh sách tất cả các điểm đi để hiển thị lên form tìm kiếm chuyến bay
     * @author ThaiVV
     * @since 10/08/2023
     * @return List<Departure>
     */
    @Query(nativeQuery = true, value = "select * from departure")
    List<Departure> getAllDeparture();

}
