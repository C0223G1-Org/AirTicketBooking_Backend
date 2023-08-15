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
public class DepartureController_getAll {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAll_5() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/departure"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getAll_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/departure"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("[0].nameDeparture").value("Cát Bi(HPH) - Hải Phòng"))
                .andExpect(jsonPath("[21].nameDeparture").value("Vân Đồn(VDO) - Quảng Ninh"));
    }
}
