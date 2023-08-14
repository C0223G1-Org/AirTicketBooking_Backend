package com.example.air_ticket_booking.controller.route;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * test case method  get route by id
 * create by NamPC
 * date:11/08/2023
 */
@SpringBootTest
@AutoConfigureMockMvc
public class RouterController_getRouteById {
    @Autowired
    private MockMvc mockMvc;


    /**
     * check case id of route null
     * input :null
     * @throws Exception
     */
    @Test
    public void getRouterById_id_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/route/{id}"))
                .andDo(print())
                .andExpect(status().is4xxClientError());


    }
    /**
     * check case id of route empty
     * input :" "
     * @throws Exception
     */
    @Test
    public void getRouterById_id_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/route/{id}",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());


    }
    /**
     * check case id of router not exits in database
     * input :3
     * @throws Exception
     */
    @Test
    public void getRouterById_id_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/route/{id}","3"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
    /**
     * check case id of route was found in database
     * input :1
     * @throws Exception
     */
    @Test
    public void getRouterById_id_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/route/{id}","1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("idRoute").value(1))
                .andExpect(jsonPath("dateArrival").value("2023-04-25"))
                .andExpect(jsonPath("dateDeparture").value("2023-04-25"))
                .andExpect(jsonPath("flagRoute").value(false))
                .andExpect(jsonPath("nameRoute").value("AL-0001"))
                .andExpect(jsonPath("priceRoute").value(15000))
                .andExpect(jsonPath("timeArrival").value("09:30:15"))
                .andExpect(jsonPath("timeDeparture").value("08:30:15"))
                .andExpect(jsonPath("airCraft.nameAirCraft").value("Airbus A320neo"))
                .andExpect(jsonPath("departure.nameDeparture").value("Hải Phong"))
                .andExpect(jsonPath("destination.nameDestination").value("Hà Nội"));
    }

}
