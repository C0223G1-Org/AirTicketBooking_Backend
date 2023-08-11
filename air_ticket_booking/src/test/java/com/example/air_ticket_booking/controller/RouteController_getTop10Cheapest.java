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
public class RouteController_getTop10Cheapest {

    @Autowired
    private MockMvc mockMvc;

    /**
     *Method test result is a List<Route> isEmpty!
     * @actor ThaiVV
     * @return 4xxClientError
     * @throws Exception
     */
    @Test
    public void getTop10Cheapest_5() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/route/top10"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     *Method test result is a List<Route> has 10 record
     * @actor ThaiVV
     * @return is2xxSuccessful, List<Route>
     * @throws Exception
     */
    @Test
    public void getTop10Cheapest_6() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.
                        get("/route/top10"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("[0].nameRoute").value("AL-0005"))
                .andExpect(jsonPath("[0].timeDeparture").value("23:00:00"))
                .andExpect(jsonPath("[0].timeArrival").value("01:06:08"))
                .andExpect(jsonPath("[0].dateDeparture").value("2023-08-15"))
                .andExpect(jsonPath("[0].dateArrival").value("2023-08-16"))
                .andExpect(jsonPath("[0].priceRoute").value(1000))
                .andExpect(jsonPath("[0].departure.nameDeparture").value("Hải Phòng(HPH)"))
                .andExpect(jsonPath("[0].destination.nameDestination").value("Hà Nội(HAN)"))
                .andExpect(jsonPath("[0].airCraft.nameAirCraft").value("Airbus A320neo"))
                .andExpect(jsonPath("[9].nameRoute").value("AL-0001"))
                .andExpect(jsonPath("[9].timeDeparture").value("08:30:15"))
                .andExpect(jsonPath("[9].timeArrival").value("11:01:47"))
                .andExpect(jsonPath("[9].dateDeparture").value("2023-09-11"))
                .andExpect(jsonPath("[9].dateArrival").value("2023-09-11"))
                .andExpect(jsonPath("[9].priceRoute").value(15000))
                .andExpect(jsonPath("[9].departure.nameDeparture").value("Hải Phòng(HPH)"))
                .andExpect(jsonPath("[9].destination.nameDestination").value("Hà Nội(HAN)"))
                .andExpect(jsonPath("[9].airCraft.nameAirCraft").value("Airbus A320neo"));
    }

    /**
     *Method test result is a List<Route> has more than letter 10 record
     * @actor ThaiVV
     * @return is2xxSuccessful, List<Route>
     * @throws Exception
     */
    @Test
    public void getTop10Cheapest_7() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/route/top10"))
                .andDo(print())
                .andExpect(jsonPath("[0].nameRoute").value("AL-0002"))
                .andExpect(jsonPath("[0].timeDeparture").value("12:47:08"))
                .andExpect(jsonPath("[0].timeArrival").value("12:47:00"))
                .andExpect(jsonPath("[0].dateDeparture").value("2023-08-13"))
                .andExpect(jsonPath("[0].dateDestination").value("2023-08-13"))
                .andExpect(jsonPath("[0].priceRoute").value(4000))
                .andExpect(jsonPath("[0].departure.nameDeparture").value("Đà Lạt(DLI)"))
                .andExpect(jsonPath("[0].destination.nameDestination").value("Hồ Chí(SGN)"))
                .andExpect(jsonPath("[0].airCraft.nameAirCraft").value("Airbus A350-900 XWB"))
                .andExpect(jsonPath("[3].nameRoute").value("AL-0002"))
                .andExpect(jsonPath("[3].timeDeparture").value("12:47:08"))
                .andExpect(jsonPath("[3].timeArrival").value("12:47:00"))
                .andExpect(jsonPath("[3].dateDeparture").value("2023-08-13"))
                .andExpect(jsonPath("[3].dateDestination").value("2023-08-13"))
                .andExpect(jsonPath("[3].priceRoute").value(4000))
                .andExpect(jsonPath("[3].departure.nameDeparture").value("Đà Lạt(DLI)"))
                .andExpect(jsonPath("[3].destination.nameDestination").value("Hồ Chí(SGN)"))
                .andExpect(jsonPath("[3].airCraft.nameAirCraft").value("Airbus A350-900 XWB"));
    }
}
