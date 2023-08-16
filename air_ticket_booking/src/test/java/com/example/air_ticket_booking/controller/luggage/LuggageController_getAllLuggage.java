package com.example.air_ticket_booking.controller.luggage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



/**
 * test case method  get all luggage in database
 * create by NamPC
 * date:11/08/2023
 */
@SpringBootTest
@AutoConfigureMockMvc
public class LuggageController_getAllLuggage {
    @Autowired
    private MockMvc mockMvc;


    /**
     * check case get all Luggage in database
     * @throws Exception
     */

    @Test
    public void getAllLuggage_6() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/luggage/list"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("[0].nameLuggage").value("Hành lý phổ thông"))
                .andExpect(jsonPath("[2].nameLuggage").value("Hành lý ý tê"));
    }

    /**
     * check case Luggage not exist in database
     * @throws Exception
     */
    @Test
    public void getAllLuggage_5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/luggage/list"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
