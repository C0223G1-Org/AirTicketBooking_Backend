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
public class TypeSeatRestController_getListTypeSeat {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getListTypeSeat_5()throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/type-seat/"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void getListTypeSeat_6()throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/type-seat"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("[0].idTypeSeat").value(1))
                .andExpect(jsonPath("[0].nameTypeSeat").value("BUSSINESS"))
                .andExpect(jsonPath("[0].priceExtra").value(1))
                .andExpect(jsonPath("[3].idTypeSeat").value(4))
                .andExpect(jsonPath("[3].nameTypeSeat").value("ECO"))
                .andExpect(jsonPath("[3].priceExtra").value(1));
    }


}
