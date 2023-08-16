package com.example.air_ticket_booking.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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
public class PostController_findPostsById {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Create By : TriPD
     * Date Create : 11/08/2023
     * Post findPostsById = Successful
     *
     * @throws Exception
     */
    @Test
    public void findPostsById_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/post/findPost/15"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create By : TriPD
     * Date Create : 11/08/2023
     * Post findPostsById = null
     *
     * @throws Exception
     */

    @Test
    public void findPostsById_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/post/findPost/","null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Create By : TriPD
     * Date Create : 11/08/2023
     * Post findPostsById = ""
     *
     * @throws Exception
     */

    @Test
    public void findPostsById_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/post/findPost/",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Create By : TriPD
     * Date Create : 11/08/2023
     * Post findPostsById = "Không nằm trong DB"
     *
     * @throws Exception
     */

    @Test
    public void findPostsById_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/post/findPost/1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
