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
public class ReportController_getAboutRevenue {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Create by : KhangPVA
     * Date create: 11/08/2023
     * Gets the sales of each day in the selected period
     *
     * @return No data
     * @throws Exception
     * @ param startDate= 2023-01-01, endDate= 2023-02-01
     */
    @Test
    public void getAboutRevenue_5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/report/about-revenue?startDate=2023-01-01&endDate=2023-02-01"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by :KhangPVA
     * Date create: 11/08/2023
     * Gets the sales of each day in the selected period
     *
     * @return Have data
     * @throws Exception
     * @ param startDate= 2023-03-01, endDate= 2023-08-10
     */
    @Test
    public void getAboutRevenue_6() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/report/about-revenue?startDate=2023-03-01&endDate=2023-08-10"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create by :KhangPVA
     * Date create: 11/08/2023
     * Gets the sales of each day in the selected period
     *
     * @return Return FieldError error content in REST
     * @throws Exception
     * @ param startDate= null, endDate= null
     */
    @Test
    public void getAboutRevenue_99() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/report/about-revenue?startDate=null&endDate=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by :KhangPVA
     * Date create: 11/08/2023
     * Gets the sales of each day in the selected period
     *
     * @return Returns all revenue
     * @throws Exception
     * @ param startDate="", endDate=""
     */
    @Test
    public void getAboutRevenue_98() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/report/about-revenue?startDate=&endDate="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create by :KhangPVA
     * Date create: 11/08/2023
     * Gets the sales of each day in the selected period
     *
     * @return Returns the revenue for that day
     * @throws Exception
     * @ param startDate= 2023-03-29, endDate=""
     */
    @Test
    public void getAboutRevenue_97() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/report/about-revenue?startDate=2023-03-29&endDate="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create by :KhangPVA
     * Date create: 11/08/2023
     * Gets the sales of each day in the selected period
     *
     * @return Returns the revenue from start to endDate
     * @throws Exception
     * @ param startDate="", endDate= 2023-08-05
     */
    @Test
    public void getAboutRevenue_96() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/report/about-revenue?startDate=&endDate=2023-08-05"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
