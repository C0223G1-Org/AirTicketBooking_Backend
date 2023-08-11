package com.example.air_ticket_booking.controller.controller;

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
public class AirTicketBookingController_findTicketByNameAndIdCardPassenger {
    @Autowired
    private MockMvc mockMvc;


    @Test
    public void findTicketByNameAndIdCardPassenger_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/tickets/search-ticket/{namePassenger}/{idCardPassenger}",
                                        "Nhàn", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findTicketByNameAndIdCardPassenger_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/tickets/search-ticket/{namePassenger}/{idCardPassenger}",
                                        "", "201923248"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findTicketByNameAndIdCardPassenger_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/tickets/search-ticket/{namePassenger}/{idCardPassenger}",
                                "Hưng", "2019232483"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findTicketByNameAndIdCardPassenger_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/tickets/search-ticket/{namePassenger}/{idCardPassenger}",
                                        "Nhàn", "201923248"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void findTicketByNameAndIdCardPassenger_Page() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/tickets/search-ticket/{namePassenger}/{idCardPassenger}?page=0",
                                        "Nhàn", "201923248"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(2))
                .andExpect(jsonPath("content[0].id_ticket").value("1"))
                .andExpect(jsonPath("content[0].price_ticket").value("1600000"))
                .andExpect(jsonPath("content[0].name_passenger").value("Nguyễn Anh Nhàn"))
                .andExpect(jsonPath("content[0].id_card_passenger").value("201923248"))
                .andExpect(jsonPath("content[0].date_booking").value("2023-03-29"))
                .andExpect(jsonPath("content[0].name_type_passenger").value("Khách phổ thông"))
                .andExpect(jsonPath("content[0].name_luggage").value("Hành lý phổ thông"))
                .andExpect(jsonPath("content[0].name_type_ticket").value("Một chiều"))
                .andExpect(jsonPath("content[0].position_seat").value("A-01"))
                .andExpect(jsonPath("content[0].name_type_seat").value("Hạng Thương Gia"))
                .andExpect(jsonPath("content[0].name_route").value("AL-0001"))
                .andExpect(jsonPath("content[0].time_arrival").value("09:30:15"))
                .andExpect(jsonPath("content[0].time_departure").value("08:30:15"))
                .andExpect(jsonPath("content[0].date_arrival").value("2023-04-25"))
                .andExpect(jsonPath("content[0].date_departure").value("2023-04-25"))
                .andExpect(jsonPath("content[0].name_destination").value("Hà Nội"))
                .andExpect(jsonPath("content[0].name_departure").value("Hải Phong"))
                .andExpect(jsonPath("content[0].name_air_craft").value("Airbus A320neo"))
                .andExpect(jsonPath("content[1].id_ticket").value("1"))
                .andExpect(jsonPath("content[1].price_ticket").value("1600000"))
                .andExpect(jsonPath("content[1].name_passenger").value("Nguyễn Anh Nhàn"))
                .andExpect(jsonPath("content[1].id_card_passenger").value("201923248"))
                .andExpect(jsonPath("content[1].date_booking").value("2023-03-29"))
                .andExpect(jsonPath("content[1].name_type_passenger").value("Khách phổ thông"))
                .andExpect(jsonPath("content[1].name_luggage").value("Hành lý phổ thông"))
                .andExpect(jsonPath("content[1].name_type_ticket").value("Một chiều"))
                .andExpect(jsonPath("content[1].position_seat").value("A-01"))
                .andExpect(jsonPath("content[1].name_type_seat").value("Hạng Thương Gia"))
                .andExpect(jsonPath("content[1].name_route").value("AL-0001"))
                .andExpect(jsonPath("content[1].time_arrival").value("09:30:15"))
                .andExpect(jsonPath("content[1].time_departure").value("08:30:15"))
                .andExpect(jsonPath("content[1].date_arrival").value("2023-04-25"))
                .andExpect(jsonPath("content[1].date_departure").value("2023-04-25"))
                .andExpect(jsonPath("content[1].name_destination").value("Hà Nội"))
                .andExpect(jsonPath("content[1].name_departure").value("Hải Phong"))
                .andExpect(jsonPath("content[1].name_air_craft").value("Airbus A320neo"));

        ;
    }
}
