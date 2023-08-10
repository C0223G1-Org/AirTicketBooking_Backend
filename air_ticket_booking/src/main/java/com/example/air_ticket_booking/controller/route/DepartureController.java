package com.example.air_ticket_booking.controller.route;

import com.example.air_ticket_booking.service.route.IDepartureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departure")
@CrossOrigin("*")
public class DepartureController {
    @Autowired
    private IDepartureService departureService;
    /**
     * method dùng để lấy danh sách tất cả các điểm đi để hiển thị lên form tìm kiếm chuyến bay
     * @author ThaiVV
     * @since 10/08/2023
     * @return ResponseEntity
     */
    @GetMapping()
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(departureService.getAll(), HttpStatus.OK);
    }
}
