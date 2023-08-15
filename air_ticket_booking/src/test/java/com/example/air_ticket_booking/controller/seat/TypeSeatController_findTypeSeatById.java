package com.example.air_ticket_booking.controller.seat;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * check case method  get TypeSeat by id
 * create by NamPC
 * date:11/08/2023
 */
@SpringBootTest
@AutoConfigureMockMvc
public class TypeSeatController_findTypeSeatById {


    @Autowired
    private MockMvc mockMvc;


    /**
     * check case id of type seat null
     * input :null
     * @throws Exception
     */
    @Test
    public void findTypeSeatById_id_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/type-seat/detail/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());


    }
    /**
     * check case id of type seat empty
     * input :" "
     * @throws Exception
     */
    @Test
    public void findTypeSeatById_id_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/type-seat/detail/{id}",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());


    }
    /**
     * check case id of type seat not exits in database
     * input :20
     * @throws Exception
     */
    @Test
    public void findTypeSeatById_id_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/type-seat/detail/{id}","20"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * check case id of type seat exits in database
     * input :2
     * @throws Exception
     */

    @Test
    public void findTypeSeatById_id_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/type-seat/detail/{id}","2"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("idTypeSeat").value(2))
                .andExpect(jsonPath("nameTypeSeat").value("Hạng Phổ Thông"));

    }
}
