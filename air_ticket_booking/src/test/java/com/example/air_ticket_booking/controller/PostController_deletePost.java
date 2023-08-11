package com.example.air_ticket_booking.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostController_deletePost {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Author: SonTT
     * Date create: 11/08/2023
     * Handling: Input 1 null media type to the path
     * @throws Exception
     */
    @Test
    public void deletePost_25() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/post/delete")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Author: SonTT
     * Date create: 11/08/2023
     * Handling: Input 1 "" media type to the path
     * @throws Exception
     */
    @Test
    public void deletePost_26() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/post/delete")
                        .param("id","")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Author: SonTT
     * Date create: 11/08/2023
     * Handling: Input 1 "thanh🥰" media type to the path
     * @throws Exception
     */
    @Test
    public void deletePost_26_1() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/post/delete")
                        .param("id","thanh🥰")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Author: SonTT
     * Date create: 11/08/2023
     * Handling: Enter an id with an external value, media type the path
     * @throws Exception
     */
    @Test
    public void deletePost_27() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/post/delete")
                        .param("id",String.valueOf(2L))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Author: SonTT
     * Date create: 11/08/2023
     * Handling: Enter an id , media type the path
     * @throws Exception
     */
    @Test
    public void deletePost_28() throws Exception {
        Long id = 2L;
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/post/delete")
                        .param("id",String.valueOf(id))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }
}
