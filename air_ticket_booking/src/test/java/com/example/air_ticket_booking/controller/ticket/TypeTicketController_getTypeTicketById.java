package com.example.air_ticket_booking.controller.ticket;

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
 * check case method  get type ticket by id
 * create by NamPC
 * date:11/08/2023
 */
@SpringBootTest
@AutoConfigureMockMvc
public class TypeTicketController_getTypeTicketById {
    @Autowired
    private MockMvc mockMvc;


    /**
     * check case id of type ticket null
     * input :null
     * @throws Exception
     */
    @Test
    public void getTypeTicketById_id_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/type-tickets/{id}","null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());


    }
    /**
     * check case id of type ticket empty
     * input :" "
     * @throws Exception
     */
    @Test
    public void getRouterById_id_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/type-tickets/{id}",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());


    }
    /**
     * check case id of type ticket not exits in database
     * input :" "
     * @throws Exception
     */
    @Test
    public void getRouterById_id_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/type-tickets/{id}","20"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * check case id of type ticket exits in database
     * input :" "
     * @throws Exception
     */

    @Test
    public void getRouterById_id_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/type-tickets/{id}","1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("idTypeTicket").value(1))
                .andExpect(jsonPath("nameTypeTicket").value("Một chiều"));

    }
}
