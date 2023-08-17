package com.example.air_ticket_booking.service.report;

import com.example.air_ticket_booking.dto.report.IReport;


import java.util.List;

public interface IReportService {
    List<IReport> getCurrentRevenue(String timeRange);

    List<IReport> getPreviousRevenue(String timeRange);

    List<IReport> getRevenue(String startDate, String endDate);
}
