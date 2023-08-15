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
public class CustomerController_getListCustomer {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void getListCustomer_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/customers/list?page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(9))
                .andExpect(jsonPath("content[0].addressCustomer").value("Bình An"))
                .andExpect(jsonPath("content[0].dateCustomer").value("11/11/1991"))
                .andExpect(jsonPath("content[0].emailCustomer").value("sieuem2002@gmail.com"))
                .andExpect(jsonPath("content[0].genderCustomer").value(true))
                .andExpect(jsonPath("content[0].nameCustomer").value("Tài"))
                .andExpect(jsonPath("content[0].imgCustomer").value("2"))
                .andExpect(jsonPath("content[0].nationalityCustomer").value("Lào"))
                .andExpect(jsonPath("content[0].telCustomer").value("012345"))
                .andExpect(jsonPath("content[0].flagCustomer").value(false))
                .andExpect(jsonPath("content[4].addressCustomer").value("Đà Nẵng"))
                .andExpect(jsonPath("content[4].dateCustomer").value("11/11/1995"))
                .andExpect(jsonPath("content[4].emailCustomer").value("sieuem2002@gmail.com"))
                .andExpect(jsonPath("content[4].genderCustomer").value(true))
                .andExpect(jsonPath("content[4].nameCustomer").value("Trí"))
                .andExpect(jsonPath("content[4].imgCustomer").value("2"))
                .andExpect(jsonPath("content[4].nationalityCustomer").value("Việt Nam"))
                .andExpect(jsonPath("content[4].telCustomer").value("038300937"))
                .andExpect(jsonPath("content[4].flagCustomer").value(false));
    }
    /**
     * Create by: TàiMP
     * Date create: 11/08/2023
     * Method: get all data in list have page 10 and don't have data and return status 4xx
     * @throws Exception
     */
    @Test
    public void getListCustomer_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/customers/list?page=10"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
    /**
     * Create by: TàiMP
     * Date create: 11/08/2023
     * Method: get all data in list have number page < 0 return status 4xx
     * @throws Exception
     */
    @Test
    public void getListCustomer_86() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/customers/list?page=-12"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
