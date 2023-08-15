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
 * check case method  get Luggage by id
 * create by NamPC
 * date:11/08/2023
 */
@SpringBootTest
@AutoConfigureMockMvc
public class LuggageController_getLuggageById {
    @Autowired
    private MockMvc mockMvc;


    /**
     * check case id of Luggage null
     * input :null
     * @throws Exception
     */
    @Test
    public void getLuggageById_id_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/luggage/{id}","null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());


    }
    /**
     * check case id of Luggage empty
     * input :" "
     * @throws Exception
     */
    @Test
    public void getLuggageById_id_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/luggage/{id}",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());


    }
    /**
     * check case id of Luggage not exits in database
     * input :" "
     * @throws Exception
     */
    @Test
    public void getLuggageById_id_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/luggage/{id}","20"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * check case id of Luggage exits in database
     * input :2
     * @throws Exception
     */

    @Test
    public void getLuggageId_id_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/luggage/{id}","2"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("idLuggage").value(2))
                .andExpect(jsonPath("nameLuggage").value("Hành lý đặt biệt"));

    }
}
