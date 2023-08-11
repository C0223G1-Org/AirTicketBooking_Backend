package com.example.air_ticket_booking.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest
@AutoConfigureMockMvc
public class PostRestController_getListPost {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getListPost_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("api/post/{page}/{limit}", "1","10"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
}
