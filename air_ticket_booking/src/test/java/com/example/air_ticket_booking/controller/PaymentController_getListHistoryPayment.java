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
/**
 *Create by: ThanhVH
 *Date create: 11/08/2023
 * Function:getListHistoryPayment()
 **/
@SpringBootTest
@AutoConfigureMockMvc
public class PaymentController_getListHistoryPayment {

    @Autowired
    private MockMvc mockMvc;

    /**
     *Create by: ThanhVH
     *Date create: 11/08/2023
     * description: test id = null
     **/
    @Test
    public void getListHistoryPayment_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/payment/history/{id}", (Object) null))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     *Create by: ThanhVH
     *Date create: 11/08/2023
     * description: test id is empty
     **/
    @Test
    public void getListHistoryPayment_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/payment/history/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     *Create by: ThanhVH
     *Date create: 11/08/2023
     * description: test id not exits
     **/
    @Test
    public void getListHistoryPayment_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/payment/history/{id}", "10"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     *Create by: ThanhVH
     *Date create: 11/08/2023
     * description: test id is negative
     **/
    @Test
    public void getListHistoryPayment_3a() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/payment/history/{id}", "-1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     *Create by: ThanhVH
     *Date create: 11/08/2023
     * description: test id is not a number
     **/
    @Test
    public void getListHistoryPayment_3b() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/payment/history/{id}", "a"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     *Create by: ThanhVH
     *Date create: 11/08/2023
     * description: test id is 0
     **/
    @Test
    public void getListHistoryPayment_3c() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/payment/history/{id}", "0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     *Create by: ThanhVH
     *Date create: 11/08/2023
     * description: test true
     **/
    @Test
    public void getListHistoryPayment_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/payment/history/{id}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.content[0].idTicket").value(1))
                .andExpect(jsonPath("$.content[0].customer.nameCustomer").value("Nguyễn Anh Nhàn"))
                .andExpect(jsonPath("$.content[0].seat.route.destination.nameDestination").value("Hà Nội"))
                .andExpect(jsonPath("$.content[0].seat.route.departure.nameDeparture").value("Hải Phong"))
                .andExpect(jsonPath("$.content[0].seat.route.timeArrival").value("09:30:15"))
                .andExpect(jsonPath("$.content[0].seat.route.timeDeparture").value("08:30:15"))
                .andExpect(jsonPath("$.content[0].seat.route.dateArrival").value("2023-04-25"))
                .andExpect(jsonPath("$.content[0].seat.route.dateDeparture").value("2023-04-25"))
                .andExpect(jsonPath("$.content[0].dateBooking").value("2023-03-29"))
                .andExpect(jsonPath("$.content[0].priceTicket").value("1600000"));
    }
}
