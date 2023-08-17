//package com.example.air_ticket_booking.controller;
//
//import com.example.air_ticket_booking.dto.ticket.TicketDto;
//import com.example.air_ticket_booking.model.customer.Customer;
//import com.example.air_ticket_booking.model.luggage.Luggage;
//import com.example.air_ticket_booking.model.seat.Seat;
//import com.example.air_ticket_booking.model.ticket.TypeTicket;
//import com.example.air_ticket_booking.model.type_passenger.TypePassenger;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.mock.web.MockHttpServletRequest;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class TicketController_updateTicket {
//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    /**
//     * Create by: VuDt
//     * Date create: 11/08/2023
//     * Check case: updateTicket_namePassenger
//     * input: " "
//     * @throws Exception
//     */
//    @Test
//    public void updateTicket_namePassenger_20() throws Exception{
//        TicketDto ticketDto= new TicketDto();
//        ticketDto.setIdCustomer(1L);
//        ticketDto.setDateBooking("04-12-2023");
//        ticketDto.setPriceTicket(123111111111111111L);
//        ticketDto.setEmailPassenger("tuanvu@gmail.com");
//        ticketDto.setGenderPassenger(true);
//        ticketDto.setIdTypeTicket(1L);
//        Luggage luggage= new Luggage();
//        luggage.setIdLuggage(1L);
//        ticketDto.setIdLuggage(1L);
//        ticketDto.setIdCardPassenger("01234567");
//        ticketDto.setNamePassenger("");
//        ticketDto.setTelPassenger("0867041299");
//        ticketDto.setIdSeat(1L);
//        ticketDto.setIdTypePassenger(1L);
//
//
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/tickets/updateTicket/{id}","1")
//                        .content(this.objectMapper.writeValueAsString(ticketDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * Create by: VuDt
//     * Date create: 11/08/2023
//     * Check case: updateTicket_namePassenger
//     * input: < 10 characters
//     * @throws Exception
//     */
//    @Test
//    public void updateTicket_namePassenger_22() throws Exception{
//        TicketDto ticketDto= new TicketDto();
//        ticketDto.setIdCustomer(1L);
//        ticketDto.setDateBooking("04-12-2023");
//        ticketDto.setPriceTicket(123111111111111111L);
//        ticketDto.setEmailPassenger("tuanvu@gmail.com");
//        ticketDto.setGenderPassenger(true);
//        ticketDto.setIdTypeTicket(1L);
//        ticketDto.setIdLuggage(1L);
//        ticketDto.setIdCardPassenger("01234567");
//        ticketDto.setNamePassenger("Tuan Vu");
//        ticketDto.setTelPassenger("0867041299");
//        ticketDto.setIdSeat(1L);
//        ticketDto.setIdTypePassenger(1L);
//
//
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/tickets/updateTicket/{id}","1")
//                        .content(this.objectMapper.writeValueAsString(ticketDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    /**
//     * Create by: VuDt
//     * Date create: 11/08/2023
//     * Check case: updateTicket_namePassenger
//     * input: > 50 characters
//     * @throws Exception
//     */
//    @Test
//    public void updateTicket_namePassenger_23() throws Exception{
//        TicketDto ticketDto= new TicketDto();
//        ticketDto.setIdCustomer(1L);
//        ticketDto.setDateBooking("04-12-2023");
//        ticketDto.setPriceTicket(123111111111111111L);
//        ticketDto.setEmailPassenger("tuanvu@gmail.com");
//        ticketDto.setGenderPassenger(true);
//        ticketDto.setIdTypeTicket(1L);
//        ticketDto.setIdLuggage(1L);
//        ticketDto.setIdCardPassenger("01234567");
//        ticketDto.setNamePassenger("Tuan Vuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
//        ticketDto.setTelPassenger("0867041299");
//        ticketDto.setIdSeat(1L);
//        ticketDto.setIdTypePassenger(1L);
//
//
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/tickets/updateTicket/{id}","1")
//                        .content(this.objectMapper.writeValueAsString(ticketDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    /**
//     * Create by: VuDt
//     * Date create: 11/08/2023
//     * Check case: updateTicket_emailCustomer
//     * input: customer email incorrect format
//     * @throws Exception
//     */
//    @Test
//    public void updateTicket_emailCustomer_21() throws Exception{
//        TicketDto ticketDto= new TicketDto();
//        ticketDto.setIdCustomer(1L);
//        ticketDto.setDateBooking("04-12-2023");
//        ticketDto.setPriceTicket(123111111111111111L);
//        ticketDto.setEmailPassenger("tuanvu@gmail.com");
//        ticketDto.setGenderPassenger(true);
//        ticketDto.setIdTypeTicket(1L);
//        ticketDto.setIdLuggage(1L);
//        ticketDto.setIdCardPassenger("01234567");
//        ticketDto.setNamePassenger("");
//        ticketDto.setTelPassenger("0867041299");
//        ticketDto.setIdSeat(1L);
//        ticketDto.setIdTypePassenger(1L);
//
//
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/tickets/updateTicket/{id}","1")
//                        .content(this.objectMapper.writeValueAsString(ticketDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * Create by: VuDt
//     * Date create: 11/08/2023
//     * Check case: updateTicket_emailCustomer
//     * input: ""
//     * @throws Exception
//     */
//    @Test
//    public void updateTicket_emailCustomer_19() throws Exception{
//        TicketDto ticketDto= new TicketDto();
//        ticketDto.setIdCustomer(null);
//        ticketDto.setDateBooking("04-12-2023");
//        ticketDto.setPriceTicket(123111111111111111L);
//        ticketDto.setEmailPassenger("tuanvu@gmail.com");
//        ticketDto.setGenderPassenger(true);
//        ticketDto.setIdTypeTicket(1L);
//        ticketDto.setIdLuggage(1L);
//        ticketDto.setIdCardPassenger("01234567");
//        ticketDto.setNamePassenger("Tuan Vu");
//        ticketDto.setTelPassenger("0867041299");
//        ticketDto.setIdSeat(1L);
//        ticketDto.setIdTypePassenger(1L);
//
//
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/tickets/updateTicket/{id}","1")
//                        .content(this.objectMapper.writeValueAsString(ticketDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * Create by: VuDt
//     * Date create: 11/08/2023
//     * Check case: updateTicket
//     * input: correct format of DTO
//     * @throws Exception
//     */
//    @Test
//    public void updateTicket_24() throws Exception{
//        TicketDto ticketDto= new TicketDto();
//        Customer customer= new Customer();
//        ticketDto.setIdCustomer( customer.getIdCustomer());
//        ticketDto.setDateBooking("04-12-2023");
//        ticketDto.setPriceTicket(123111111111111111L);
//        ticketDto.setEmailPassenger("tuanvu0412@gmail.com");
//        ticketDto.setGenderPassenger(true);
//        TypeTicket typeTicket= new TypeTicket();
//        ticketDto.setIdTypeTicket(typeTicket.getIdTypeTicket());
//        Luggage luggage = new Luggage();
//        ticketDto.setIdLuggage( luggage.getIdLuggage());
//        ticketDto.setIdCardPassenger("012345678911");
//        ticketDto.setNamePassenger("Dang Tuan Vu");
//        ticketDto.setTelPassenger("0867041299");
//        Seat seat= new Seat();
//        ticketDto.setIdSeat(seat.getIdSeat());
//        TypePassenger typePassenger= new TypePassenger();
//        ticketDto.setIdTypePassenger(typePassenger.getIdTypePassenger());
//
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/tickets/updateTicket/{id}","1")
//                        .content(this.objectMapper.writeValueAsString(ticketDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//}
