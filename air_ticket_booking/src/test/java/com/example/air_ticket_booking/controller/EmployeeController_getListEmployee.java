package com.example.air_ticket_booking.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeController_getListEmployee {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Create by: HuyHD;
     * Date create: 11/08/2023
     * Test case for getting a list of employees with specific page and limit.
     */
    @Test
    public void getListEmployee_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/employee/{page}/{limit}", 5, 2))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HuyHD;
     * Date create: 11/08/2023
     * Test case for getting a list of employees with specific page and limit, and validating the response JSON.
     */
    @Test
    public void getListEmployee_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/employee/{page}/{limit}", 0, 2))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(4))
                .andExpect(jsonPath("content[0].idEmployee").value("1"))
                .andExpect(jsonPath("content[0].nameEmployee").value("admin"))
                .andExpect(jsonPath("content[0].emailEmployee").value("admin@gmail.com"))
                .andExpect(jsonPath("content[1].idEmployee").value("2"))
                .andExpect(jsonPath("content[1].nameEmployee").value("aaaa"))
                .andExpect(jsonPath("content[1].emailEmployee").value("aaaa@gmail.com"));
    }
}
