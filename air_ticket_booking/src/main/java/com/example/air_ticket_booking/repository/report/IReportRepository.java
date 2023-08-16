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
    @Query(value = "SELECT t.date_booking as dateBooking, SUM(t.price_ticket) AS priceTicket\n" +
            "            FROM ticket as t\n" +
            "            WHERE t.flag_ticket=false\n" +
            "            AND t.date_booking BETWEEN :startDate AND :endDate\n" +
            "            GROUP BY date_booking", nativeQuery = true)
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
            "    YEAR(t.date_booking) AS year,\n" +
            "    FLOOR((MONTH(t.date_booking) - 1) / 3) + 1 AS dateBooking,\n" +
            "    MIN(t.date_booking) AS quarter_start,\n" +
            "    MAX(t.date_booking) AS quarter_end,\n" +
            "    SUM(t.price_ticket) AS priceTicket\n" +
            "FROM\n" +
            "    ticket AS t\n" +
            "WHERE\n" +
            "    t.flag_ticket = false\n" +
            "    AND t.date_booking BETWEEN :startDate AND :endDate\n" +
            "GROUP BY\n" +
            "    year, dateBooking\n" +
            "ORDER BY\n" +
            "    year, dateBooking;", nativeQuery = true)
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
            "    t.date_booking AS dateBooking,\n" +
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
            "    t.date_booking", nativeQuery = true)
    List<IReport> getRevenue(@Param("startDate") String startDate, @Param("endDate") String endDate);
}
