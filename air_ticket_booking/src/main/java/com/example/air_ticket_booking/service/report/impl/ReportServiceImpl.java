package com.example.air_ticket_booking.service.report.impl;

import com.example.air_ticket_booking.dto.report.IReport;
import com.example.air_ticket_booking.repository.report.IReportRepository;
import com.example.air_ticket_booking.service.report.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.*;
import java.time.temporal.IsoFields;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReportServiceImpl implements IReportService {

    @Autowired
    private IReportRepository reportRepository;

    /**
     * Created by: KhangPVA
     * Date created: 10/08/2023
     * Function: create report
     * @param timeRange
     * @return revenue data
     */
    @Override
    public List<IReport> getCurrentRevenue(String timeRange) {
        LocalDate currentDate;
        LocalDate startDate;
        LocalDate endDate;
        int currentYear;
        List<IReport> reports; // Khai báo biến reports để lưu kết quả trước khi trả về

        switch (timeRange) {
            case "week":
                currentDate = LocalDate.now();
                startDate = currentDate.with(TemporalAdjusters.previousOrSame(java.time.DayOfWeek.MONDAY));
                endDate = currentDate.with(TemporalAdjusters.nextOrSame(java.time.DayOfWeek.SUNDAY));
                reports = reportRepository.getCurrentRevenue(startDate, endDate); // Gán kết quả vào biến reports
                break;
            case "month":
                currentDate = LocalDate.now();
                Month currentMonth = currentDate.getMonth();
                YearMonth yearMonth = YearMonth.now();
                startDate = yearMonth.atDay(1);
                endDate = yearMonth.atEndOfMonth();
                reports = reportRepository.getCurrentRevenue(startDate, endDate); // Gán kết quả vào biến reports
                break;
            case "quarter":
                currentDate = LocalDate.now();
                currentYear = currentDate.getYear();
                int currentQuarter = currentDate.get(IsoFields.QUARTER_OF_YEAR);
                startDate = LocalDate.of(currentYear, Month.of((currentQuarter - 1) * 3 + 1), 1);
                endDate = startDate.plusMonths(3).minusDays(1);
                reports = reportRepository.getCurrentRevenue(startDate, endDate); // Gán kết quả vào biến reports
                break;
            case "year":
                currentDate = LocalDate.now();
                currentYear = Year.now().getValue();
                startDate = YearMonth.of(currentYear, 1).atDay(1);
                endDate = YearMonth.of(currentYear, 12).atEndOfMonth();
                reports = reportRepository.getCurrentRevenue(startDate, endDate); // Gán kết quả vào biến reports
                break;
            default:
                reports = new ArrayList<>(); // Trường hợp không hợp lệ, gán reports là một danh sách rỗng
                break;
        }

        return reports; // Trả về danh sách reports đã tạo trong các trường hợp hợp lệ
    }

    /**
     * Created by: KhangPVA
     * Date created: 10/08/2023
     * Function: create report
     * @param timeRange
     * @return revenue data
     */
    @Override
    public List<IReport> getPreviousRevenue(String timeRange) {
        LocalDate currentDate;
        LocalDate startDate;
        LocalDate endDate;
        int currentYear;
        List<IReport> reports; // Khai báo biến reports để lưu kết quả trước khi trả về

        switch (timeRange) {
            case "week":
                currentDate = LocalDate.now();
                startDate = currentDate.with(TemporalAdjusters.previousOrSame(java.time.DayOfWeek.MONDAY)).minusWeeks(1); // Tuần trước
                endDate = currentDate.with(TemporalAdjusters.nextOrSame(java.time.DayOfWeek.SUNDAY)).minusWeeks(1); // Tuần trước
                reports = reportRepository.getCurrentRevenue(startDate, endDate); // Gán kết quả vào biến reports
                break;
            case "month":
                currentDate = LocalDate.now();
                Month currentMonth = currentDate.getMonth();
                YearMonth yearMonth = YearMonth.now().minusMonths(1); // Tháng trước
                startDate = yearMonth.atDay(1);
                endDate = yearMonth.atEndOfMonth();
                reports = reportRepository.getCurrentRevenue(startDate, endDate); // Gán kết quả vào biến reports
                break;
            case "quarter":
                currentDate = LocalDate.now();
                currentYear = currentDate.getYear();
                int currentQuarter = currentDate.get(IsoFields.QUARTER_OF_YEAR);
                startDate = LocalDate.of(currentYear, Month.of((currentQuarter - 1) * 3 + 1), 1).minusMonths(3); // Quý trước
                endDate = startDate.plusMonths(3).minusDays(1);
                reports = reportRepository.getCurrentRevenue(startDate, endDate); // Gán kết quả vào biến reports
                break;
            case "year":
                currentDate = LocalDate.now();
                currentYear = Year.now().getValue() - 1; // Năm trước
                startDate = YearMonth.of(currentYear, 1).atDay(1);
                endDate = YearMonth.of(currentYear, 12).atEndOfMonth();
                reports = reportRepository.getCurrentRevenue(startDate, endDate); // Gán kết quả vào biến reports
                break;
            default:
               return null;
        }

        return reports; // Trả về danh sách reports đã tạo trong các trường hợp hợp lệ
    }


    /**
     * Created by: KhangPVA
     * Date created: 10/08/2023
     * Function: create report
     * @param startDate
     * @param endDate
     * @return revenue data
     */
    @Override
    public List<IReport> getRevenue(String startDate, String endDate) {
        return reportRepository.getRevenue(startDate,endDate);
    }
}
