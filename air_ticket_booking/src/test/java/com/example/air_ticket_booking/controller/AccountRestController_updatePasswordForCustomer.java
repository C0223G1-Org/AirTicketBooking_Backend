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
public class AccountRestController_updatePasswordForCustomer {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void updatePasswordForCustomer_newPass_99() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/account/change-pass-customer/{newPass}/{oldPass}/{idCustomer}",
                        ""))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
