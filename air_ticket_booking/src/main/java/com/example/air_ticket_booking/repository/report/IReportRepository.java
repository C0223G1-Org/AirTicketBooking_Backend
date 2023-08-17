package com.example.air_ticket_booking.repository.report;

import com.example.air_ticket_booking.dto.report.IReport;
import com.example.air_ticket_booking.model.ticket.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IReportRepository extends JpaRepository<Ticket, Long> {
    /**
     * Created by: KhangPVA
     * Date created: 10/08/2023
     * Function: create report
     *
     * @param startDate
     * @param endDate
     * @return revenue data
     */
    @Query(value = "SELECT\n" +
            "    t.date_booking AS date_booking,\n" +
            "    SUM(t.price_ticket) AS priceTicket,\n" +
            "    DAYNAME(t.date_booking) AS date_Booking,\n" +
            "    CASE\n" +
            "        WHEN DAYNAME(t.date_booking) = 'Monday' THEN 'Thứ Hai'\n" +
            "        WHEN DAYNAME(t.date_booking) = 'Tuesday' THEN 'Thứ Ba'\n" +
            "        WHEN DAYNAME(t.date_booking) = 'Wednesday' THEN 'Thứ Tư'\n" +
            "        WHEN DAYNAME(t.date_booking) = 'Thursday' THEN 'Thứ Năm'\n" +
            "        WHEN DAYNAME(t.date_booking) = 'Friday' THEN 'Thứ Sáu'\n" +
            "        WHEN DAYNAME(t.date_booking) = 'Saturday' THEN 'Thứ Bảy'\n" +
            "        WHEN DAYNAME(t.date_booking) = 'Sunday' THEN 'Chủ Nhật'\n" +
            "        ELSE DAYNAME(t.date_booking)\n" +
            "        END AS dateBooking\n" +
            "FROM\n" +
            "    ticket AS t\n" +
            "WHERE\n" +
            "        t.flag_ticket = false\n" +
            "  AND t.date_booking BETWEEN :startDate AND :endDate\n" +
            "GROUP BY\n" +
            "    date_booking, dateBooking", nativeQuery = true)
    List<IReport> getWeekRevenue(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query(value = "   SELECT\n" +
            "    YEAR(t.date_booking) AS year,\n" +
            "    MONTH(t.date_booking) AS month,\n" +
            "    FLOOR((DAY(t.date_booking) - 1) / 7) + 1 AS dateBooking,\n" +
            "    MIN(t.date_booking) AS week_start,\n" +
            "    MAX(t.date_booking) AS week_end,\n" +
            "    SUM(t.price_ticket) AS priceTicket\n" +
            "FROM\n" +
            "    ticket AS t\n" +
            "WHERE\n" +
            "        t.flag_ticket = false\n" +
            "  AND t.date_booking BETWEEN :startDate AND :endDate\n" +
            "GROUP BY\n" +
            "    year, month, dateBooking\n" +
            "ORDER BY\n" +
            "    year, month, dateBooking", nativeQuery = true)
    List<IReport> getMonthRevenue(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query(value = "  SELECT\n" +
            "    WEEK(t.date_booking) AS dateBooking,\n" +
            "    MIN(t.date_booking) AS week_start,\n" +
            "    MAX(t.date_booking) AS week_end,\n" +
            "    SUM(t.price_ticket) AS priceTicket\n" +
            "FROM\n" +
            "    ticket AS t\n" +
            "WHERE\n" +
            "        t.flag_ticket = false\n" +
            "  AND t.date_booking BETWEEN :startDate AND :endDate\n" +
            "GROUP BY\n" +
            "    dateBooking\n" +
            "ORDER BY\n" +
            "    dateBooking;;", nativeQuery = true)
    List<IReport> getQuarterRevenue(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query(value = "  SELECT\n" +
            "    YEAR(t.date_booking) AS year,\n" +
            "    MONTH(t.date_booking) AS dateBooking,\n" +
            "    MIN(t.date_booking) AS month_start,\n" +
            "    MAX(t.date_booking) AS month_end,\n" +
            "    SUM(t.price_ticket) AS priceTicket\n" +
            "FROM\n" +
            "    ticket AS t\n" +
            "WHERE\n" +
            "        t.flag_ticket = false\n" +
            "  AND t.date_booking BETWEEN :startDate AND :endDate\n" +
            "GROUP BY\n" +
            "    year, dateBooking\n" +
            "ORDER BY\n" +
            "    year, dateBooking;", nativeQuery = true)
    List<IReport> getYearRevenue(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);


    /**
     * Created by: KhangPVA
     * Date created: 10/08/2023
     * Function: create report
     *
     * @param startDate
     * @param endDate
     * @return revenue data
     */
    @Query(value = "SELECT\n" +
            "    MONTH(t.date_booking) AS dateBooking,\n" +
            "    SUM(t.price_ticket) AS priceTicket\n" +
            "FROM\n" +
            "    ticket AS t\n" +
            "WHERE\n" +
            "        t.flag_ticket = false\n" +
            "  AND (\n" +
            "        (:startDate IS NULL AND :endDate IS NULL)\n" +
            "        OR (t.date_booking >= :startDate AND t.date_booking <= :endDate)\n" +
            "    )\n" +
            "GROUP BY\n" +
            "    MONTH(t.date_booking);", nativeQuery = true)
    List<IReport> getRevenue(@Param("startDate") String startDate, @Param("endDate") String endDate);
}
