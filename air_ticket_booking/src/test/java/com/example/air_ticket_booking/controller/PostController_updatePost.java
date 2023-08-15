package com.example.air_ticket_booking.controller;

import com.example.air_ticket_booking.dto.post.PostDto;
import com.example.air_ticket_booking.model.employee.Employee;
import com.example.air_ticket_booking.model.post.Post;
import com.fasterxml.jackson.core.JsonProcessingException;
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
public class PostController_updatePost {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Create by TriPD
     * Date create 11/08/2023
     * Test method updatePost
     * @expect successful and status HttpStatus.is2xxSuccessful
     * @throws Exception
     */

    @Test
    public void updatePost_24() throws Exception {
        PostDto postDto=new PostDto();
        postDto.setId(8L);
        postDto.setTitle("vé rẻ");
        postDto.setDatePost("2023-03-09");
        postDto.setImage("airplan.jpg");
        postDto.setContent("giá rẻ bất ngờ sao không bay");
        Employee employee=new Employee();
        employee.setIdEmployee(Long.valueOf(1));
        postDto.setEmployee(employee);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/post/updatePost")
                        .content(this.objectMapper.writeValueAsString(postDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }




    /**
     * Create by TriPD
     * Date create 11/08/2023
     * Test method createPost [item] null
     * @expect Error and status HttpStatus.4x
     * @throws Exception
     */
    @Test
    public void updatePost_title_19() throws Exception {
        PostDto postDto=new PostDto();
        postDto.setId(8L);
        postDto.setTitle(null);
        postDto.setDatePost("2023-03-09");
        postDto.setImage("airplan.jpg");
        postDto.setContent("giá rẻ bất ngờ sao không bay");
        Employee employee=new Employee();
        employee.setIdEmployee(Long.valueOf(1));
        postDto.setEmployee(employee);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/post/updatePost")
                        .content(this.objectMapper.writeValueAsString(postDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updatePost_datePost_19() throws Exception {
        PostDto postDto=new PostDto();
        postDto.setId(8L);
        postDto.setTitle("vé rẻ");
        postDto.setDatePost(null);
        postDto.setImage("airplan.jpg");
        postDto.setContent("giá rẻ bất ngờ sao không bay");
        Employee employee=new Employee();
        employee.setIdEmployee(Long.valueOf(1));
        postDto.setEmployee(employee);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/post/updatePost")
                        .content(this.objectMapper.writeValueAsString(postDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updatePost_image_19() throws Exception {
        PostDto postDto=new PostDto();
        postDto.setId(8L);
        postDto.setTitle("vé rẻ");
        postDto.setDatePost("2023-03-09");
        postDto.setImage(null);
        postDto.setContent("giá rẻ bất ngờ sao không bay");
        Employee employee=new Employee();
        employee.setIdEmployee(Long.valueOf(1));
        postDto.setEmployee(employee);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/post/updatePost")
                        .content(this.objectMapper.writeValueAsString(postDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updatePost_content_19() throws Exception {
        PostDto postDto=new PostDto();
        postDto.setId(8L);
        postDto.setTitle("vé rẻ");
        postDto.setDatePost("2023-03-09");
        postDto.setImage("airplan.jpg");
        postDto.setContent(null);
        Employee employee=new Employee();
        employee.setIdEmployee(Long.valueOf(1));
        postDto.setEmployee(employee);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/post/updatePost")
                        .content(this.objectMapper.writeValueAsString(postDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }



    /**
     * Create by TriPD
     * Date create 11/08/2023
     * Test method createPost [item] ""
     * @expect Error and status HttpStatus.4x
     * @throws Exception
     */

    @Test
    public void updatePost_title_20() throws Exception {
        PostDto postDto=new PostDto();
        postDto.setId(8L);
        postDto.setTitle("");
        postDto.setDatePost("2023-03-09");
        postDto.setImage("airplan.jpg");
        postDto.setContent("giá rẻ bất ngờ sao không bay");
        Employee employee=new Employee();
        employee.setIdEmployee(Long.valueOf(1));
        postDto.setEmployee(employee);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/post/updatePost")
                        .content(this.objectMapper.writeValueAsString(postDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updatePost_datePost_20() throws Exception {
        PostDto postDto=new PostDto();
        postDto.setId(8L);
        postDto.setTitle("vé rẻ");
        postDto.setDatePost("");
        postDto.setImage("airplan.jpg");
        postDto.setContent("giá rẻ bất ngờ sao không bay");
        Employee employee=new Employee();
        employee.setIdEmployee(Long.valueOf(1));
        postDto.setEmployee(employee);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/post/updatePost")
                        .content(this.objectMapper.writeValueAsString(postDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updatePost_image_20() throws Exception {
        PostDto postDto=new PostDto();
        postDto.setId(8L);
        postDto.setTitle("vé rẻ");
        postDto.setDatePost("2023-03-09");
        postDto.setImage("");
        postDto.setContent("giá rẻ bất ngờ sao không bay");
        Employee employee=new Employee();
        employee.setIdEmployee(Long.valueOf(1));
        postDto.setEmployee(employee);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/post/updatePost")
                        .content(this.objectMapper.writeValueAsString(postDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void updatePost_content_20() throws Exception {
        PostDto postDto=new PostDto();
        postDto.setId(8L);
        postDto.setTitle("vé rẻ");
        postDto.setDatePost("2023-03-09");
        postDto.setImage("airplan.jpg");
        postDto.setContent("");
        Employee employee=new Employee();
        employee.setIdEmployee(Long.valueOf(1));
        postDto.setEmployee(employee);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/post/updatePost")
                        .content(this.objectMapper.writeValueAsString(postDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
