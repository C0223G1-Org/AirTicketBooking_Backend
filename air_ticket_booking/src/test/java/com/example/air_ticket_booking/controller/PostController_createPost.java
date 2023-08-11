package com.example.air_ticket_booking.controller;

import com.example.air_ticket_booking.dto.post.PostDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

public class PostController_createPost {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Test
    public void createPost_title_13() throws Exception{
        PostDto postDto=new PostDto();

    }
}
