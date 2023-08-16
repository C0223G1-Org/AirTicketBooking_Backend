package com.example.air_ticket_booking.controller;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
public class AccountRestController_updateAccount {
    @Autowired
    private MockMvc mockMvc;


    /**
     * create by : SangTDN
     * check requestBody is empty
     * @throws Exception
     */
    @Test
    public void updateAccount_accountDTO_20 () throws Exception{
        String requestBody = "";
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/account/{id}",
                                        1)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestBody))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * create by : SangTDN
     * check validate properties :oldPassword
     * @throws Exception
     */
    @Test
    public void updateAccount_accountDTO_oldPassword_validRegexNoNum_21 () throws Exception{
        String requestBody = "{\n" +
                "    \"id\" :1,\n" +
                "\"oldPassword\" : \"Sangdolphin\",\n" +
                "\"newPassword\" : \"Sanglong87\"\n" +
                "}";
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/account/{id}",
                                        1)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestBody))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * create by : SangTDN
     * check validate properties :oldPassword
     * @throws Exception
     */
    @Test
    public void updateAccount_accountDTO_oldPassword_validRegexNoUppercase_21 () throws Exception{
        String requestBody = "{\n" +
                "    \"id\" :1,\n" +
                "\"oldPassword\" : \"sangdolphin98\",\n" +
                "\"newPassword\" : \"Sanglong87\"\n" +
                "}";
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/account/{id}",
                                        1)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestBody))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * create by : SangTDN
     * check min size properties :oldPassword
     * @throws Exception
     */
    @Test
    public void updateAccount_accountDTO_oldPassword_minLenght_22 () throws Exception{
        String requestBody = "{\n" +
                "    \"id\" :1,\n" +
                "\"oldPassword\" : \"Sang98\",\n" +
                "\"newPassword\" : \"Sanglong87\"\n" +
                "}";
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/account/{id}",
                                        1)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestBody))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * create by : SangTDN
     * check max size properties :oldPassword
     * @throws Exception
     */
    @Test
    public void updateAccount_accountDTO_oldPassword_maxLenght_23 () throws Exception{
        String requestBody = "{\n" +
                "    \"id\" :1,\n" +
                "\"oldPassword\" : \"Sangdolphin98Sangdolphin98Sangdolphin98Sangdolphin98Sangdolphin98\",\n" +
                "\"newPassword\" : \"Sanglong87\"\n" +
                "}";
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/account/{id}",
                                        1)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestBody))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * create by : SangTDN
     * check validate properties :newPassword
     * @throws Exception
     */
    @Test
    public void updateAccount_accountDTO_newPassword_validRegexNoNum_21 () throws Exception{
        String requestBody = "{\n" +
                "    \"id\" :1,\n" +
                "\"oldPassword\" : \"Sangdolphin98\",\n" +
                "\"newPassword\" : \"Sanglong\"\n" +
                "}";
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/account/{id}",
                                        1)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestBody))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * create by : SangTDN
     * check validate properties :newPassword
     * @throws Exception
     */
    @Test
    public void updateAccount_accountDTO_newPassword_validRegexNoUppercase_21 () throws Exception{
        String requestBody = "{\n" +
                "    \"id\" :1,\n" +
                "\"oldPassword\" : \"sangdolphin98\",\n" +
                "\"newPassword\" : \"sanglong87\"\n" +
                "}";
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/account/{id}",
                                        1)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestBody))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * create by : SangTDN
     * check min size properties :newPassword
     * @throws Exception
     */
    @Test
    public void updateAccount_accountDTO_newPassword_minLenght_22 () throws Exception{
        String requestBody = "{\n" +
                "    \"id\" :1,\n" +
                "\"oldPassword\" : \"Sanglong98\",\n" +
                "\"newPassword\" : \"Sang87\"\n" +
                "}";
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/account/{id}",
                                        1)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestBody))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * create by : SangTDN
     * check max size properties :newPassword
     * @throws Exception
     */
    @Test
    public void updateAccount_accountDTO_newPassword_maxLenght_23 () throws Exception{
        String requestBody = "{\n" +
                "    \"id\" :1,\n" +
                "\"oldPassword\" : \"Sangdolphin\",\n" +
                "\"newPassword\" : \"Sanglong8798Sangdolphin98Sangdolphin98Sangdolphin98Sangdolphin98\"\n" +
                "}";
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/account/{id}",
                                        1)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestBody))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * create by: SangTDN
     * id does not exist
     * @throws Exception
     */
    @Test
    public void updateAccount_id_99 () throws Exception{
        String requestBody = "{\n" +
                "    \"id\" :2000,\n" +
                "\"oldPassword\" : \"Sanglong98\",\n" +
                "\"newPassword\" : \"Sang87\"\n" +
                "}";
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/account/{id}",
                                        2000)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestBody))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * create by : SangTDN
     * Change password successfully
     * @throws Exception
     */
    @Test
    public void updateAccount_24 () throws Exception{
        String requestBody = "{\n" +
                "    \"id\" :1,\n" +
                "\"oldPassword\" : \"Sangdolphin98\",\n" +
                "\"newPassword\" : \"Sanglong87\"\n" +
                "}";
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/account/{id}",
                                        1)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestBody))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    /**
     * create by : SangTDN
     * password no match
     * @throws Exception
     */
    @Test
    public void updateAccount_oldPassword_98 () throws Exception{
        String requestBody = "{\n" +
                "    \"id\" :1,\n" +
                "\"oldPassword\" : \"Sanglsfggg98\",\n" +
                "\"newPassword\" : \"Sangđsadsad87\"\n" +
                "}";
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/account/{id}",
                                        1)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestBody))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * create by : SangTDN
     * requestBody is null
     * @throws Exception
     */
    @Test
    public void updateAccount_accountDTO_19 () throws Exception{
        String requestBody = null;
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/account/{id}",
                                        1)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content((String) requestBody))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
