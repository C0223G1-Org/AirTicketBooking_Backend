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

    /**
     * method : search leaves 1 field [idCardPassenger] blank
     * created by :KietNT
     * date create: 11/08/2023
     * throw exception
     */
    @Test
    public void findTicketByNameAndIdCardPassenger_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/tickets/search-ticket/{namePassenger}/{idCardPassenger}",
                                        "Nhàn", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * method : search leaves 1 field [namePassenger] blank
     * created by :KietNT
     * date create: 11/08/2023
     * throw exception
     */
    @Test
    public void findTicketByNameAndIdCardPassenger_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/tickets/search-ticket/{namePassenger}/{idCardPassenger}",
                                        "", "201923248"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * method : search data is not in DB
     * created by :KietNT
     * date create: 11/08/2023
     * throw exception
     */
    @Test
    public void findTicketByNameAndIdCardPassenger_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/tickets/search-ticket/{namePassenger}/{idCardPassenger}",
                                "Hưng", "2019232483"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * method : search data is correct format
     * created by :KietNT
     * date create: 11/08/2023
     * throw exception
     */
    @Test
    public void findTicketByNameAndIdCardPassenger_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/tickets/search-ticket/{namePassenger}/{idCardPassenger}",
                                        "Nhàn", "201923248"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * method : 2 fields are empty
     * created by :KietNT
     * date create: 11/08/2023
     * throw exception
     */
    @Test
    public void findTicketByNameAndIdCardPassenger_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/tickets/search-ticket/{namePassenger}/{idCardPassenger}",
                                        "", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * method : search has data and has page is 0
     * created by :KietNT
     * date create: 11/08/2023
     * throw exception
     */
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
                .andExpect(jsonPath("content[0].id").value("1"))
                .andExpect(jsonPath("content[0].priceTicket").value("1600000"))
                .andExpect(jsonPath("content[0].namePassenger").value("Nguyễn Anh Nhàn"))
                .andExpect(jsonPath("content[0].idCardPassenger").value("201923248"))
                .andExpect(jsonPath("content[0].dateBooking").value("2023-03-29"))
                .andExpect(jsonPath("content[0].nameTypePassenger").value("Khách phổ thông"))
                .andExpect(jsonPath("content[0].nameLuggage").value("Hành lý phổ thông"))
                .andExpect(jsonPath("content[0].nameTypeTicket").value("Một chiều"))
                .andExpect(jsonPath("content[0].positionSeat").value("A-01"))
                .andExpect(jsonPath("content[0].nameTypeSeat").value("Hạng Thương Gia"))
                .andExpect(jsonPath("content[0].nameRoute").value("AL-0001"))
                .andExpect(jsonPath("content[0].timeArrival").value("09:30:15"))
                .andExpect(jsonPath("content[0].timeDeparture").value("08:30:15"))
                .andExpect(jsonPath("content[0].dateArrival").value("2023-04-25"))
                .andExpect(jsonPath("content[0].dateDeparture").value("2023-04-25"))
                .andExpect(jsonPath("content[0].nameDestination").value("Hà Nội"))
                .andExpect(jsonPath("content[0].nameDeparture").value("Hải Phong"))
                .andExpect(jsonPath("content[0].nameAirCraft").value("Airbus A320neo"))
                .andExpect(jsonPath("content[1].id").value("3"))
                .andExpect(jsonPath("content[1].priceTicket").value("1600000"))
                .andExpect(jsonPath("content[1].namePassenger").value("Nguyễn Anh Nhàn"))
                .andExpect(jsonPath("content[1].idCardPassenger").value("201923248"))
                .andExpect(jsonPath("content[1].dateBooking").value("2023-03-29"))
                .andExpect(jsonPath("content[1].nameTypePassenger").value("Khách phổ thông"))
                .andExpect(jsonPath("content[1].nameLuggage").value("Hành lý phổ thông"))
                .andExpect(jsonPath("content[1].nameTypeTicket").value("Một chiều"))
                .andExpect(jsonPath("content[1].positionSeat").value("A-01"))
                .andExpect(jsonPath("content[1].nameTypeSeat").value("Hạng Thương Gia"))
                .andExpect(jsonPath("content[1].nameRoute").value("AL-0001"))
                .andExpect(jsonPath("content[1].timeArrival").value("09:30:15"))
                .andExpect(jsonPath("content[1].timeDeparture").value("08:30:15"))
                .andExpect(jsonPath("content[1].dateArrival").value("2023-04-25"))
                .andExpect(jsonPath("content[1].dateDeparture").value("2023-04-25"))
                .andExpect(jsonPath("content[1].nameDestination").value("Hà Nội"))
                .andExpect(jsonPath("content[1].nameDeparture").value("Hải Phong"))
                .andExpect(jsonPath("content[1].nameAirCraft").value("Airbus A320neo"));
        ;
    }
    /**
     * method :access more than the number of available pages
     * created by :KietNT
     * date create: 11/08/2023
     * throw exception
     */
    @Test
    public void findTicketByNameAndIdCardPassenger_Page_Max() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/tickets/search-ticket/{namePassenger}/{idCardPassenger}?page=10",
                                        "Nhàn", "201923248"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
