package com.example.air_ticket_booking.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerController_deleteCustomer {
    @Autowired
    private MockMvc mockMvc;
    /**
     * Create by: TàiMP
     * Date create: 11/08/2023
     * Method: deleteCustomer_id_90 have param id don't have in database so return status 4xx
     * @throws Exception
     */
    @Test
    public void deleteCustomer_id_90() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.put("/customers/delete/{id}","20"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }
    /**
     * Create by: TàiMP
     * Date create: 11/08/2023
     * Method: deleteCustomer_id_89 have param id is empty so return status 4xx
     * @throws Exception
     */
    @Test
    public void deleteCustomer_id_89() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.put("/customers/delete/{id}",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
        /**
         * Create by: TàiMP
         * Date create: 11/08/2023
         * Method: deleteCustomer_id_88 have param id is null so return status 4xx
         * @throws Exception
         */
    } @Test
    public void deleteCustomer_id_88() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.put("/customers/delete/{id}","null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: TàiMP
     * Date create: 11/08/2023
     * Method: deleteCustomer_id_87 have name delete but only set flag customer = true because database need Keep data for statistics and id have in DB so return status 2xx
     * @throws Exception
     */

    @Test
    public void deleteCustomer_id_87() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.put("/customers/delete/{id}","4"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
