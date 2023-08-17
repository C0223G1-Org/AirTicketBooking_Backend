package com.example.air_ticket_booking.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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
public class EmployeeRestController_findByIdEmployee {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * findById employee [id] = null
     *
     * @throws Exception
     */
    @Test
    public void EmployeeById_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/employee/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * findById employee [id] = ""
     *
     * @throws Exception
     */
    @Test
    public void EmployeeById_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/employee/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * findById employee [id] = No existing in dB
     *
     * @throws Exception
     */
    @Test
    public void EmployeeById_3() throws Exception {
        Long employeeId = 26L;
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/employee/30"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * findById employee [id] = noise in db
     *
     * @throws Exception
     */
    @Test
    public void EmployeeById_4() throws Exception {
        Long employeeId = 1L;
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/employee/{id}", employeeId))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
