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
    List<IReport> getCurrentRevenue(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);


    /**
     * Created by: KhangPVA
     * Date created: 10/08/2023
     * Function: create report
     *
     * @param startDate
     * @param endDate
     * @return revenue data
     */
    @Query(value = "SELECT t.date_booking AS dateBooking, SUM(t.price_ticket) AS priceTicket\n" +
            "FROM ticket AS t\n" +
            "WHERE t.flag_ticket = false\n" +
            "AND (\n" +
            "    (:startDate = '' AND :endDate = '' AND t.date_booking LIKE '%%')\n" +
            "    OR (:startDate = '' AND t.date_booking LIKE CONCAT('%', :endDate, '%'))\n" +
            "    OR (:endDate = '' AND t.date_booking LIKE CONCAT('%', :startDate, '%'))\n" +
            "    OR (t.date_booking BETWEEN COALESCE(:startDate, t.date_booking) AND COALESCE(:endDate, t.date_booking))\n" +
            ")\n" +
            "GROUP BY t.date_booking;", nativeQuery = true)
    List<IReport> getRevenue(@Param("startDate") String startDate, @Param("endDate") String endDate);
}
