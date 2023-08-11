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
public class RouteRestController_searchTrips {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void searchTrips_departure_7() throws  Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/route/search-trips/{departure}/{destination}/{dateDeparture}",
                        null,"Hà Nội (HAN)","2023-08-20"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void searchTrips_destination_7() throws  Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/route/search-trips/{departure}/{destination}/{dateDeparture}",
                                "Tp. Hồ Chí Minh (SGN)",null,"2023-08-20"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void searchTrips_dateDeparture_7() throws  Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/route/search-trips/{departure}/{destination}/{dateDeparture}",
                                "Tp. Hồ Chí Minh (SGN)","Hà Nội (HAN)",null))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void searchTrips_departure_8() throws  Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/route/search-trips/{departure}/{destination}/{dateDeparture}",
                                "","Hà Nội (HAN)","2023-08-20"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void searchTrips_destination_8() throws  Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/route/search-trips/{departure}/{destination}/{dateDeparture}",
                                "Tp. Hồ Chí Minh (SGN)","","2023-08-20"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void searchTrips_dateDeparture_8() throws  Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/route/search-trips/{departure}/{destination}/{dateDeparture}",
                                "Tp. Hồ Chí Minh (SGN)","Hà Nội (HAN)",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void searchTrips_departure_9() throws  Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/route/search-trips/{departure}/{destination}/{dateDeparture}",
                                "xxx","Hà Nội (HAN)","2023-08-20"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void searchTrips_destination_9() throws  Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/route/search-trips/{departure}/{destination}/{dateDeparture}",
                                "Tp. Hồ Chí Minh (SGN)","xxx","2023-08-20"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void searchTrips_dateDeparture_9() throws  Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/route/search-trips/{departure}/{destination}/{dateDeparture}",
                                "Tp. Hồ Chí Minh (SGN)","Hà Nội (HAN)","xxx"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void searchTrips_departure_10() throws  Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/route/search-trips/{departure}/{destination}/{dateDeparture}",
                                "Nha Trang(CXR)","Hà Nội (HAN)","2023-08-20"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void searchTrips_destination_10() throws  Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/route/search-trips/{departure}/{destination}/{dateDeparture}",
                                "Tp. Hồ Chí Minh (SGN)","Nha Trang(CXR)","2023-08-20"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void searchTrips_destination_11() throws  Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/route/search-trips/{departure}/{destination}/{dateDeparture}",
                                "Tp. Hồ Chí Minh (SGN)","Hà Nội (HAN)","2023-08-20"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("[0].priceRoute").value(500000))
                .andExpect(jsonPath("[0].nameAirCraft").value("Airbus A.320"))
                .andExpect(jsonPath("[0].nameDeparture").value("Tp. Hồ Chí Minh (SGN)"))
                .andExpect(jsonPath("[0].nameDestination").value("Hà Nội (HAN)"))
                .andExpect(jsonPath("[0].dateArrival").value("2023-08-20"))
                .andExpect(jsonPath("[0].timeArrival").value("09:30:00"))
                .andExpect(jsonPath("[0].nameRoute").value("AL001"))
                .andExpect(jsonPath("[0].idRoute").value(1))
                .andExpect(jsonPath("[0].dateDeparture").value("2023-08-20"))
                .andExpect(jsonPath("[0].timeDeparture").value("08:30:00"))

                .andExpect(jsonPath("[1].priceRoute").value(600000))
                .andExpect(jsonPath("[1].nameAirCraft").value("Boeing 787-3"))
                .andExpect(jsonPath("[1].nameDeparture").value("Tp. Hồ Chí Minh (SGN)"))
                .andExpect(jsonPath("[1].nameDestination").value("Hà Nội (HAN)"))
                .andExpect(jsonPath("[1].dateArrival").value("2023-08-20"))
                .andExpect(jsonPath("[1].timeArrival").value("17:00:00"))
                .andExpect(jsonPath("[1].nameRoute").value("BF245"))
                .andExpect(jsonPath("[1].idRoute").value(3))
                .andExpect(jsonPath("[1].dateDeparture").value("2023-08-20"))
                .andExpect(jsonPath("[1].timeDeparture").value("16:00:00"));


    }

    /**
     * check the case of entering a flight date in the past
     * @throws Exception
     */
    @Test
    public void searchTrips_destination_99() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/route/search-trips/{departure}/{destination}/{dateDeparture}",
                                "Tp. Hồ Chí Minh (SGN)","Hà Nội (HAN)","2023-08-10"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
