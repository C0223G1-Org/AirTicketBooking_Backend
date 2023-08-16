package com.example.air_ticket_booking.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 *Create by: ThanhVH
 *Date create: 11/08/2023
 * Function: updateTicketByIdTicket
 **/
@SpringBootTest
@AutoConfigureMockMvc
public class PaymentController_updateTicketByIdTicket {
    @Autowired
    private MockMvc mockMvc;
    /**
     *Create by: ThanhVH
     *Date create: 11/08/2023
     * description: test id = null
     **/
    @Test
    public void updateTicketByIdTicket_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/payment/callback/{id}", (Object) null))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     *Create by: ThanhVH
     *Date create: 11/08/2023
     * description: test id is empty
     **/
    @Test
    public void updateTicketByIdTicket_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/payment/callback/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     *Create by: ThanhVH
     *Date create: 11/08/2023
     * description: test id is not exits
     **/
    @Test
    public void updateTicketByIdTicket_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/payment/callback/{id}", "10"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     *Create by: ThanhVH
     *Date create: 11/08/2023
     * description: test id is negative
     **/
    @Test
    public void updateTicketByIdTicket_3a() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/payment/callback/{id}", "-1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     *Create by: ThanhVH
     *Date create: 11/08/2023
     * description: test id is not a number
     **/
    @Test
    public void updateTicketByIdTicket_3b() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/payment/callback/{id}", "a"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     *Create by: ThanhVH
     *Date create: 11/08/2023
     * description: test id = 0
     **/
    @Test
    public void updateTicketByIdTicket_3c() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/payment/callback/{id}", "0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     *Create by: ThanhVH
     *Date create: 11/08/2023
     * description: test true
     **/
    @Test
    public void updateTicketByIdTicket_24() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/payment/callback/{id}","1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    /**
     *Create by: ThanhVH
     *Date create: 11/08/2023
     * description: test if status from PayPal return is false
     **/
    @Test
    public void updateTicketByIdTicket_failed() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/payment/callback/{id}/status","10","CANCELLED"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
