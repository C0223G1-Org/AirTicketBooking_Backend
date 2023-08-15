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
                                .param("gender", "true")
                                .param("name", "aaaa")
                                .param("page", "0")
                                .param("size", "2"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create by: HuyHD;
     * Date create: 11/08/2023
     * Test case searches for employees with incorrect "gender" and "name" parameters
     * @throws Exception
     */
    @Test
    public void searchEmployee_11_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/search")
                                .param("page", "0")
                                .param("size", "2"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
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
                                .param("page", "0")
                                .param("size", "5"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(5))
                .andExpect(jsonPath("content[0].idEmployee").value("1"))
                .andExpect(jsonPath("content[0].nameEmployee").value("admin"))
                .andExpect(jsonPath("content[0].emailEmployee").value("admin@gmail.com"))
                .andExpect(jsonPath("content[4].idEmployee").value("10"))
                .andExpect(jsonPath("content[4].nameEmployee").value("Nguyễn Quốc Công"))
                .andExpect(jsonPath("content[4].emailEmployee").value("quoccong@gmail.com"));
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
                                .param("name", "viet")
                                .param("page", "0")
                                .param("size", "5"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("content[0].idEmployee").value("2005"))
                .andExpect(jsonPath("content[0].nameEmployee").value("Nguyễn Quốc Việt"))
                .andExpect(jsonPath("content[0].emailEmployee").value("quocviet@gmail.com"));
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
                                .param("size", "5"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(3))
                .andExpect(jsonPath("content[0].idEmployee").value("2001"))
                .andExpect(jsonPath("content[0].nameEmployee").value("admin"))
                .andExpect(jsonPath("content[0].emailEmployee").value("admin@gmail.com"))
                .andExpect(jsonPath("content[2].idEmployee").value("2007"))
                .andExpect(jsonPath("content[2].nameEmployee").value("Nguyễn Hoàng Nam"))
                .andExpect(jsonPath("content[2].emailEmployee").value("hoangnam@gmail.com"));
    }
}
