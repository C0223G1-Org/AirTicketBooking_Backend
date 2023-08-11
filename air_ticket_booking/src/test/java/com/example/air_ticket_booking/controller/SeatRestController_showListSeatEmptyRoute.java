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
public class SeatRestController_showListSeatEmptyRoute {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void showListSeatEmptyRoute_idRoute_7 () throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/seat/seat-empty/{idRoute}", (Object) null))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void showListSeatEmptyRoute_idRoute_8 () throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/seat/seat-empty/{idRoute}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void showListSeatEmptyRoute_idRoute_9 () throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/seat/seat-empty/{idRoute}", 10))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void showListSeatEmptyRoute_idRoute_11 () throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/seat/seat-empty/{idRoute}", 1))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("[0].idTypeSeat").value(1))
                .andExpect(jsonPath("[0].nameTypeSeat").value("BUSSINESS"))
                .andExpect(jsonPath("[0].countSeatEmpty").value("5"))
                .andExpect(jsonPath("[1].idTypeSeat").value(2))
                .andExpect(jsonPath("[1].nameTypeSeat").value("skyBOSS"))
                .andExpect(jsonPath("[1].countSeatEmpty").value("5"))
                .andExpect(jsonPath("[2].idTypeSeat").value(3))
                .andExpect(jsonPath("[2].nameTypeSeat").value("VELUXE"))
                .andExpect(jsonPath("[2].countSeatEmpty").value("5"))
                .andExpect(jsonPath("[3].idTypeSeat").value(4))
                .andExpect(jsonPath("[3].nameTypeSeat").value("ECO"))
                .andExpect(jsonPath("[3].countSeatEmpty").value("5"));
    }
}
