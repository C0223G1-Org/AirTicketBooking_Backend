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
public class EmployeeController_deleteEmployee {
    @Autowired
    private MockMvc mockMvc;


    /**
     * Create by: HuyHD;
     * Date create: 11/08/2023
     * Test case to delete an existing employee by ID = "".
     * @throws Exception if an error occurs during the test
     */
    @Test
    public void delete_Employee_26() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/api/employee/delete/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HuyHD;
     * Date create: 11/08/2023
     * Test case to delete an existing employee by ID no cos in data
     * @throws Exception if an error occurs during the test
     */
    @Test
    public void delete_Employee_27() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/api/employee/delete/{id}", 1000))

                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create by: HuyHD;
     * Date create: 11/08/2023
     * Function: Test case for deleting an existing employee by ID.
     * @throws Exception if an error occurs during the test
     */

    @Test
    public void delete_Employee_28() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/api/employee/delete/{id}", 2))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
