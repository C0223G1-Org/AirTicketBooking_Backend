package com.example.air_ticket_booking.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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
public class EmployeeController_searchEmployee {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Create by: HuyHD;
     * Date create: 11/08/2023
     * Test case searches for employees with incorrect "gender" and "name" parameters
     */
    @Test
    public void searchEmployee_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/search")
                                .param("gender", "false")
                                .param("name", "a")
                                .param("page", "0")
                                .param("size", "2"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HuyHD;
     * Date create: 11/08/2023
     * Test case searching for employees with incorrect "gender" parameter
     */
    @Test
    public void searchEmployee_7_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/search")
                                .param("gender", "aaaa")
                                .param("page", "0")
                                .param("size", "2"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HuyHD;
     * Date create: 11/08/2023
     * Test case searching for employees with incorrect "name" parameter
     */
    @Test
    public void searchEmployee_7_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/search")
                                .param("name", "1111")
                                .param("page", "0")
                                .param("size", "2"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HuyHD;
     * Date create: 11/08/2023
     * Function: Test case for searching employees with specific "gender" parameters and validating the response JSON.
     */
    @Test
    public void searchEmployee_11_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/search")
                                .param("gender", "true")
                                .param("page", "1")
                                .param("size", "2"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(4))
                .andExpect(jsonPath("content[0].idEmployee").value("3"))
                .andExpect(jsonPath("content[0].nameEmployee").value("bbbb"))
                .andExpect(jsonPath("content[0].emailEmployee").value("bbbbb@gmail.com"))
                .andExpect(jsonPath("content[1].idEmployee").value("4"))
                .andExpect(jsonPath("content[1].nameEmployee").value("cccc"))
                .andExpect(jsonPath("content[1].emailEmployee").value("cccc@gmail.com"));
    }

    /**
     * Create by: HuyHD;
     * Date create: 11/08/2023
     * Function: Test case to search for employees with specific "name" parameters and validate response JSON.
     */
    @Test
    public void searchEmployee_11_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/search")
                                .param("name", "b")
                                .param("page", "0")
                                .param("size", "2"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("content[0].idEmployee").value("3"))
                .andExpect(jsonPath("content[0].nameEmployee").value("bbbb"))
                .andExpect(jsonPath("content[0].emailEmployee").value("bbbbb@gmail.com"));
    }

    /**
     * Create by: HuyHD;
     * Date create: 11/08/2023
     * Test case to search for employees with specific "gender" and "name" parameters and validate response JSON.
     */
    @Test
    public void searchEmployee_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/search")
                                .param("gender", "true")
                                .param("name", "a")
                                .param("page", "0")
                                .param("size", "2"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(2))
                .andExpect(jsonPath("content[0].idEmployee").value("1"))
                .andExpect(jsonPath("content[0].nameEmployee").value("admin"))
                .andExpect(jsonPath("content[0].emailEmployee").value("admin@gmail.com"))
                .andExpect(jsonPath("content[1].idEmployee").value("2"))
                .andExpect(jsonPath("content[1].nameEmployee").value("aaaa"))
                .andExpect(jsonPath("content[1].emailEmployee").value("aaaa@gmail.com"));
    }
}
