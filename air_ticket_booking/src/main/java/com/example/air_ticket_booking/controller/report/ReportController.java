package com.example.air_ticket_booking.controller.report;

import com.example.air_ticket_booking.dto.report.IReport;
import com.example.air_ticket_booking.service.report.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/report")
@CrossOrigin("*")
public class ReportController {
    @Autowired
    private IReportService reportService;


    /**
     * Created by: KhangPVA
     * Date created: 10/08/2023
     * Function: create report
     * @param timeRange
     * @return revenue data
     */
    @GetMapping("/current-revenue")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EMPLOYEE')")
    public ResponseEntity<List<IReport>> getCurrentRevenue(@RequestParam("timeRange") String timeRange) {
        List<IReport> reportList = reportService.getCurrentRevenue(timeRange);
        if (reportList.size() == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(reportList, HttpStatus.OK);
    }


    /**
     * Created by: KhangPVA
     * Date created: 10/08/2023
     * Function: create report
     * @param timeRange
     * @return revenue data
     */
    @GetMapping("/previous-revenue")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EMPLOYEE')")
    public ResponseEntity<List<IReport>> getPreviousRevenue(@RequestParam("timeRange") String timeRange) {
        List<IReport> reportList = reportService.getPreviousRevenue(timeRange);
        if (reportList.size() == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(reportList, HttpStatus.OK);
    }

    /**
     * Created by: KhangPVA
     * Date created: 10/08/2023
     * Function: create report
     * @param startDate
     * @param endDate
     * @return revenue data
     */
    @GetMapping("/about-revenue")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EMPLOYEE')")
    public ResponseEntity<List<IReport>> getAboutRevenue(@RequestParam(value = "startDate", defaultValue = "")String startDate,
                                                    @RequestParam(value = "endDate", defaultValue = "")String endDate) {
        List<IReport> reportList = reportService.getRevenue(startDate,endDate);
        if (reportList.size() == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(reportList, HttpStatus.OK);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not Found");
    }
}
