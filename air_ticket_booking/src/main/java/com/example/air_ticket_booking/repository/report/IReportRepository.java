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
            "FROM ticket as t\n" +
            "WHERE t.date_booking BETWEEN :startDate AND :endDate\n" +
            "GROUP BY date_booking", nativeQuery = true)
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
    @Query(value = "SELECT t.date_booking as dateBooking, SUM(t.price_ticket) AS priceTicket\n" +
            "FROM ticket as t\n" +
            "WHERE t.date_booking \n" +
            "  and case\n" +
            "          WHEN :startDate = '' and :endDate = '' THEN t.date_booking LIKE '%%'\n" +
            "          WHEN :startDate = '' THEN t.date_booking LIKE concat('%', :endDate, '%')\n" +
            "          WHEN :endDate = '' THEN t.date_booking LIKE concat('%', :startDate, '%')\n" +
            "          WHEN :startDate != '' and :endDate != ''\n" +
            "              then t.date_booking between COALESCE(:startDate, t.date_booking) and COALESCE(:endDate, t.date_booking)\n" +
            "    END\n" +
            "GROUP BY date_booking", nativeQuery = true)
    List<IReport> getRevenue(@Param("startDate") String startDate, @Param("endDate") String endDate);
}
