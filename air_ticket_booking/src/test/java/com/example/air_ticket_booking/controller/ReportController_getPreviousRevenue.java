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
public class ReportController_getPreviousRevenue {
    @Autowired
    private MockMvc mockMvc;


    /**
     * Create by : KhangPVA
     * Date create: 11/08/2023
     * Get the sales of each day in the previous selected period
     *
     * @return No data
     * @throws Exception
     * @ param timeRange = "year"
     */
    @Test
    public void getPreviousRevenue_5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/report/previous-revenue?timeRange=year"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by : KhangPVA
     * Date create: 11/08/2023
     * Get the sales of each day in the previous selected period
     *
     * @return Have data
     * @throws Exception
     * @ param timeRange = "week"
     */
    @Test
    public void getPreviousRevenue_6() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/report/previous-revenue?timeRange=week"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create by : KhangPVA
     * Date create: 11/08/2023
     * Get the sales of each day in the previous selected period
     *
     * @return Return FieldError error content in REST
     * @throws Exception
     * @ param timeRange = null
     */
    @Test
    public void getPreviousRevenue_99() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/report/previous-revenue?timeRange=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by : KhangPVA
     * Date create: 11/08/2023
     * Get the sales of each day in the previous selected period
     *
     * @return Returns all revenue
     * @throws Exception
     * @ param timeRange = ""
     */
    @Test
    public void getPreviousRevenue_98() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/report/previous-revenue?timeRange=''"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
