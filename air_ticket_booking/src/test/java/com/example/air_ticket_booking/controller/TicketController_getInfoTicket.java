package com.example.air_ticket_booking.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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
public class TicketController_getInfoTicket {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Create by: VuDt
     * Date create: 11/08/2023
     * Check case: getInfoTicker_id
     * input: " "
     * @throws Exception
     */
    @Test
    public void getInfoTicker_id_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/studentRest/detail/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VuDt
     * Date create: 11/08/2023
     * Check case: getInfoTicker_id
     * input: null
     * @throws Exception
     */
    @Test
    public void getInfoTicker_id_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/studentRest/detail/{id}", (Object) null))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Create by: VuDt
     * Date create: 11/08/2023
     * Check case: getInfoTicker_id
     * input: 1
     * @throws Exception
     */
    @Test
    public void getInfoTicket_id_4() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/tickets/{id}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("idTicket").value(1L))
                .andExpect(jsonPath("priceTicket").value(123111111111111111L))
                .andExpect(jsonPath("flagTicket").value(true))
                .andExpect(jsonPath("namePassenger").value("Tuan Vu"))
                .andExpect(jsonPath("emailPassenger").value("tuanvu@gmail.com"))
                .andExpect(jsonPath("telPassenger").value("0867041299"))
                .andExpect(jsonPath("idCardPassenger").value("312313124"))
                .andExpect(jsonPath("dateBooking").value("04-12-2023"))
                .andExpect(jsonPath("typeTicket.idTypeTicket").value(1L))
                .andExpect(jsonPath("luggage.idLuggage").value(1L))
                .andExpect(jsonPath("typePassenger.idTypePassenger").value(1L))
                .andExpect(jsonPath("seat.idSeat").value(1L))
                .andExpect(jsonPath("customer.idCustomer").value(1L));

    }
}
