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

    /**
     * Create by: HoaLTY
     * Date create: 11/08/2023
     * Function: test id parameter is null
     * @throws Exception
     */
    @Test
    public void getCustomerDetails_id_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/customers/details/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HoaLTY
     * Date create: 11/08/2023
     * Function: test id parameter is empty
     * @throws Exception
     */
    @Test
    public void getCustomerDetails_id_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/customers/details/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HoaLTY
     * Date create: 11/08/2023
     * Function: test id parameter doesn't exist
     * @throws Exception
     */
    @Test
    public void getCustomerDetails_id_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/customers/details/{id}", "9"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HoaLTY
     * Date create: 11/08/2023
     * Function: test id parameter exist
     * @throws Exception
     */
    @Test
    public void getCustomerDetails_id_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/customers/details/{id}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("idCustomer").value(1))
                .andExpect(jsonPath("nameCustomer").value("Lê Thị Yến Hoa"))
                .andExpect(jsonPath("genderCustomer").value("true"))
                .andExpect(jsonPath("emailCustomer").value("lsyh31@gmail.com"))
                .andExpect(jsonPath("telCustomer").value("0397215463"))
                .andExpect(jsonPath("addressCustomer").value("Dai Loc,Quang Nam"))
                .andExpect(jsonPath("imgCustomer").value(""))
                .andExpect(jsonPath("nationalityCustomer").value("Viet Nam"))
                .andExpect(jsonPath("idCardCustomer").value("012345678974"))
                .andExpect(jsonPath("flagCustomer").value("false"))
                .andExpect(jsonPath("dateCustomer").value("31/01/2000"));
    }

    /**
     * Create by: HoaLTY
     * Date create: 11/08/2023
     * Function: test id parameter invalid
     * @throws Exception
     */
    @Test
    public void getCustomerDetails_id() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/customers/details/{id}", "a"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
