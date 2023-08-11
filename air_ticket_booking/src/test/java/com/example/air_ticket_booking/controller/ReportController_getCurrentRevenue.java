package com.example.air_ticket_booking.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ReportController_getCurrentRevenue {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Create by : KhangPVA
     * Date create: 11/08/2023
     * Gets the sales of each day in the selected current period
     *
     * @return No data
     * @throws Exception
     * @ param timeRange = "week"
     */
    @Test
    public void getCurrentRevenue_5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/report/current-revenue?timeRange=week"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by :KhangPVA
     * Date create: 11/08/2023
     * Gets the sales of each day in the selected current period
     *
     * @return Have data
     * @throws Exception
     * @ param timeRange = "year"
     */
    @Test
    public void getCurrentRevenue_6() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/report/current-revenue?timeRange=year"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create by :KhangPVA
     * Date create: 11/08/2023
     * Gets the sales of each day in the selected current period
     *
     * @return Return FieldError error content in REST
     * @throws Exception
     * @ param timeRange = null
     */
    @Test
    public void getCurrentRevenue_99() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/report/current-revenue?timeRange=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by :KhangPVA
     * Date create: 11/08/2023
     * Gets the sales of each day in the selected current period
     *
     * @return Returns all revenue
     * @throws Exception
     * @ param timeRange = ""
     */
    @Test
    public void getCurrentRevenue_98() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/report/current-revenue?timeRange=''"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
