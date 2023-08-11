package com.example.air_ticket_booking.controller;

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
public class CustomerController_getCustomerDetails {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void getCustomerDetails_id_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/customers/details/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getCustomerDetails_id_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/customers/details/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getCustomerDetails_id_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/customers/details/{id}", "9"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getCustomerDetails_id_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/customers/details/{id}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("idCustomer").value(1))
                .andExpect(jsonPath("nameCustomer").value("Hoa"))
                .andExpect(jsonPath("genderCustomer").value("true"))
                .andExpect(jsonPath("emailCustomer").value("hoa@gmail.com"))
                .andExpect(jsonPath("telCustomer").value("434343434"))
                .andExpect(jsonPath("addressCustomer").value("31hjh"))
                .andExpect(jsonPath("imgCustomer").value("23"))
                .andExpect(jsonPath("nationalityCustomer").value("VN"))
                .andExpect(jsonPath("idCardCustomer").value("7676731"))
                .andExpect(jsonPath("flagCustomer").value("false"))
                .andExpect(jsonPath("dateCustomer").value("31/01/2000"));
    }

}
