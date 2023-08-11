package com.example.air_ticket_booking.controller.account;

import com.example.air_ticket_booking.reponse.JwtRequest;
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
public class AccountController_login {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    /**
     * Created by: NhanDT
     * Date created: 11/08/2023
     *
     * Check case null name
     * @throws Exception
     */
    @Test
    public void loginAuthentication_username_13() throws Exception {
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setUsername(null);
        jwtRequest.setPassword("123");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/account/login")
                        .content(this.objectMapper.writeValueAsString(jwtRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Created by: NhanDT
     * Date created: 11/08/2023
     *
     * Check case empty name
     * @throws Exception
     */
    @Test
    public void loginAuthentication_username_14() throws Exception {
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setUsername("");
        jwtRequest.setPassword("123");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/account/login")
                        .content(this.objectMapper.writeValueAsString(jwtRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Created by: NhanDT
     * Date created: 11/08/2023
     *
     * Check case null password
     * @throws Exception
     */
    @Test
    public void loginAuthentication_password_13() throws Exception {
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setUsername("nhan1@123");
        jwtRequest.setPassword(null);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/account/login")
                        .content(this.objectMapper.writeValueAsString(jwtRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Created by: NhanDT
     * Date created: 11/08/2023
     *
     * Check case empty password
     * @throws Exception
     */
    @Test
    public void loginAuthentication_password_14() throws Exception {
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setUsername("nhan1@123");
        jwtRequest.setPassword("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/account/login")
                        .content(this.objectMapper.writeValueAsString(jwtRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Created by: NhanDT
     * Date created: 11/08/2023
     *
     * Check case all item success
     * @throws Exception
     */
    @Test
    public void loginAuthentication_username_password_18() throws Exception {
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setUsername("nhan1@123");
        jwtRequest.setPassword("123");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/account/login")
                        .content(this.objectMapper.writeValueAsString(jwtRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
