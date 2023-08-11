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
public class PostRestController_getListPost {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getListPost_5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/post/{page}/{limit}", 1, 5))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getListPost_6() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/post/{page}/{limit}", 0, 5))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(5))
                .andExpect(jsonPath("content[0].title").value("Ngày quốc khánh 2/9"))
                .andExpect(jsonPath("content[0].datePost").value("2023-08-10 13:37:49"));
    }
}
