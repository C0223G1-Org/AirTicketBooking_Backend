package com.example.air_ticket_booking.controller;

import com.example.air_ticket_booking.dto.post.PostDto;
import com.example.air_ticket_booking.model.employee.Employee;
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
public class PostController_createPost {
    @Autowired
    private MockMvc mockMvc;
   @Autowired
    private ObjectMapper objectMapper;

    /**
     * Create by TriPD
     * Date create 11/08/2023
     * Test method createPost
     * @expect successful and status HttpStatus.is2xxSuccessful
     * @throws Exception
     */

    @Test
    public void createPost_18() throws Exception{
        PostDto postDto=new PostDto();
        postDto.setTitle("Gía rẻ bất ngờ");
        postDto.setDatePost("2023-08-09");
        postDto.setImage("airplan.jpg");
        postDto.setContent("Tha hồ bay mà không lo về giá với Air plan");
        Employee employee=new Employee();
        employee.setIdEmployee(1L);
        postDto.setEmployee(employee);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/post")
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
    public void createPost_title_13() throws Exception {
        PostDto postDto=new PostDto();
        postDto.setTitle(null);
        postDto.setDatePost("2023-08-09");
        postDto.setImage("airplan.jpg");
        postDto.setContent("Tha hồ bay mà không lo về giá với Air plan");
        Employee employee=new Employee();
        employee.setIdEmployee(1L);
        postDto.setEmployee(employee);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/post")
                        .content(this.objectMapper.writeValueAsString(postDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void createPost_datePost_13() throws Exception {
        PostDto postDto=new PostDto();
        postDto.setTitle("Gía rẻ bất ngờ");
        postDto.setDatePost(null);
        postDto.setImage("airplan.jpg");
        postDto.setContent("Tha hồ bay mà không lo về giá với Air plan");
        Employee employee=new Employee();
        employee.setIdEmployee(1L);
        postDto.setEmployee(employee);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/post")
                        .content(this.objectMapper.writeValueAsString(postDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createPost_image_13() throws Exception {
        PostDto postDto=new PostDto();
        postDto.setTitle("Gía rẻ bất ngờ");
        postDto.setDatePost("2023-02-03");
        postDto.setImage(null);
        postDto.setContent("Tha hồ bay mà không lo về giá với Air plan");
        Employee employee=new Employee();
        employee.setIdEmployee(1L);
        postDto.setEmployee(employee);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/post")
                        .content(this.objectMapper.writeValueAsString(postDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createPost_content_13() throws Exception {
        PostDto postDto=new PostDto();
        postDto.setTitle("Gía rẻ bất ngờ");
        postDto.setDatePost("2023-02-03");
        postDto.setImage("airplan.jpg");
        postDto.setContent(null);
        Employee employee=new Employee();
        employee.setIdEmployee(1L);
        postDto.setEmployee(employee);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/post")
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
    public void createPost_title_14() throws Exception {
        PostDto postDto=new PostDto();
        postDto.setTitle("");
        postDto.setDatePost("2023-08-09");
        postDto.setImage("airplan.jpg");
        postDto.setContent("Tha hồ bay mà không lo về giá với Air plan");
        Employee employee=new Employee();
        employee.setIdEmployee(1L);
        postDto.setEmployee(employee);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/post")
                        .content(this.objectMapper.writeValueAsString(postDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createPost_datePost_14() throws Exception {
        PostDto postDto=new PostDto();
        postDto.setTitle("Gía rẻ bất ngờ");
        postDto.setDatePost("");
        postDto.setImage("airplan.jpg");
        postDto.setContent("Tha hồ bay mà không lo về giá với Air plan");
        Employee employee=new Employee();
        employee.setIdEmployee(1L);
        postDto.setEmployee(employee);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/post")
                        .content(this.objectMapper.writeValueAsString(postDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createPost_image_14() throws Exception {
        PostDto postDto=new PostDto();
        postDto.setTitle("Gía rẻ bất ngờ");
        postDto.setDatePost("2023-02-03");
        postDto.setImage("");
        postDto.setContent("Tha hồ bay mà không lo về giá với Air plan");
        Employee employee=new Employee();
        employee.setIdEmployee(1L);
        postDto.setEmployee(employee);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/post")
                        .content(this.objectMapper.writeValueAsString(postDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createPost_content_14() throws Exception {
        PostDto postDto=new PostDto();
        postDto.setTitle("Gía rẻ bất ngờ");
        postDto.setDatePost("2023-02-03");
        postDto.setImage("airplan.jpg");
        postDto.setContent("");
        Employee employee=new Employee();
        employee.setIdEmployee(1L);
        postDto.setEmployee(employee);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/post")
                        .content(this.objectMapper.writeValueAsString(postDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createPost_employee_id_14() throws Exception {
        PostDto postDto=new PostDto();
        postDto.setTitle("Gía rẻ bất ngờ");
        postDto.setDatePost("2023-02-03");
        postDto.setImage("airplan.jpg");
        postDto.setContent(null);
        Employee employee=new Employee();
        employee.setIdEmployee(3L);
        postDto.setEmployee(employee);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/post")
                        .content(this.objectMapper.writeValueAsString(postDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
