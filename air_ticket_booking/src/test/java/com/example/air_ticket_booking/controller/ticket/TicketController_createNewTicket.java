package com.example.air_ticket_booking.controller.ticket;

import com.example.air_ticket_booking.dto.ticket.TicketDto;
import com.example.air_ticket_booking.model.customer.Customer;
import com.example.air_ticket_booking.model.luggage.Luggage;
import com.example.air_ticket_booking.model.route.Route;
import com.example.air_ticket_booking.model.seat.Seat;
import com.example.air_ticket_booking.model.seat.TypeSeat;
import com.example.air_ticket_booking.model.ticket.TypeTicket;
import com.example.air_ticket_booking.model.type_passenger.TypePassenger;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * check case method  new create a ticket
 * create by NamPC
 * date:11/08/2023
 */
@SpringBootTest
@AutoConfigureMockMvc
public class TicketController_createNewTicket {
    @Autowired
    private  MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Check case null name
     * @throws Exception
     */

    @Test
    public void createNewTicket_namePassenger_13() throws Exception{
        TypeTicket typeTicket = new TypeTicket();
        typeTicket.setIdTypeTicket(1L);
        Luggage luggage = new Luggage();
        luggage.setIdLuggage(1L);
        luggage.setPriceLuggage(1000L);
        TypePassenger typePassenger = new TypePassenger();
        typePassenger.setIdTypePassenger(1L);
        Route route = new Route();
        route.setIdRoute(1L);
        route.setPriceRoute(2000L);
        TypeSeat typeSeat = new TypeSeat();
        Seat seat = new Seat();
        seat.setIdSeat(1L);
        seat.setTypeSeat(typeSeat);
        seat.setRoute(route);
        typeSeat.setIdTypeSeat(1L);
        typeSeat.setPriceExtra(2L);
        Customer customer =new Customer();
        customer.setIdCustomer(1L);


        TicketDto ticketDto = new TicketDto();
        ticketDto.setNamePassenger("null");
        ticketDto.setFlagTicket(false);
        ticketDto.setGenderPassenger(false);
        ticketDto.setEmailPassenger("nguyenanhnhan@gmail.com");
        ticketDto.setTelPassenger("0393554072");
        ticketDto.setIdCardPassenger("201923248123");
        ticketDto.setDateBooking("2023-03-29");
        ticketDto.setTypeTicket(typeTicket);
        ticketDto.setLuggage(luggage);
        ticketDto.setTypePassenger(typePassenger);
        ticketDto.setSeat(seat);
        ticketDto.setCustomer(customer);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/tickets")
                .content(this.objectMapper.writeValueAsString(ticketDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * check case empty name
     * @throws Exception
     */
    @Test
    public void createNewTicket_namePassenger_14() throws Exception{
        TypeTicket typeTicket = new TypeTicket();
        typeTicket.setIdTypeTicket(1L);
        Luggage luggage = new Luggage();
        luggage.setIdLuggage(1L);
        luggage.setPriceLuggage(1000L);
        TypePassenger typePassenger = new TypePassenger();
        typePassenger.setIdTypePassenger(1L);
        Route route = new Route();
        route.setIdRoute(1L);
        route.setPriceRoute(2000L);
        TypeSeat typeSeat = new TypeSeat();
        Seat seat = new Seat();
        seat.setIdSeat(1L);
        seat.setTypeSeat(typeSeat);
        seat.setRoute(route);
        typeSeat.setIdTypeSeat(1L);
        typeSeat.setPriceExtra(2L);
        Customer customer =new Customer();
        customer.setIdCustomer(1L);


        TicketDto ticketDto = new TicketDto();
        ticketDto.setNamePassenger("");
        ticketDto.setFlagTicket(false);
        ticketDto.setGenderPassenger(false);
        ticketDto.setEmailPassenger("nguyenanhnhan@gmail.com");
        ticketDto.setTelPassenger("0393554072");
        ticketDto.setIdCardPassenger("201923248123");
        ticketDto.setDateBooking("2023-03-29");
        ticketDto.setTypeTicket(typeTicket);
        ticketDto.setLuggage(luggage);
        ticketDto.setTypePassenger(typePassenger);
        ticketDto.setSeat(seat);
        ticketDto.setCustomer(customer);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/tickets")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * check case input contains numbers in the name
     * input :"NguyenAC12"
     * @throws Exception
     */
    @Test
    public void createNewTicket_namePassenger_15_1() throws Exception{
        TypeTicket typeTicket = new TypeTicket();
        typeTicket.setIdTypeTicket(1L);
        Luggage luggage = new Luggage();
        luggage.setIdLuggage(1L);
        luggage.setPriceLuggage(1000L);
        TypePassenger typePassenger = new TypePassenger();
        typePassenger.setIdTypePassenger(1L);
        Route route = new Route();
        route.setIdRoute(1L);
        route.setPriceRoute(2000L);
        TypeSeat typeSeat = new TypeSeat();
        Seat seat = new Seat();
        seat.setIdSeat(1L);
        seat.setTypeSeat(typeSeat);
        seat.setRoute(route);
        typeSeat.setIdTypeSeat(1L);
        typeSeat.setPriceExtra(2L);
        Customer customer =new Customer();
        customer.setIdCustomer(1L);


        TicketDto ticketDto = new TicketDto();
        ticketDto.setNamePassenger("NguyenAC12");
        ticketDto.setFlagTicket(false);
        ticketDto.setGenderPassenger(false);
        ticketDto.setEmailPassenger("nguyenanhnhan@gmail.com");
        ticketDto.setTelPassenger("0393554072");
        ticketDto.setIdCardPassenger("201923248123");
        ticketDto.setDateBooking("2023-03-29");
        ticketDto.setTypeTicket(typeTicket);
        ticketDto.setLuggage(luggage);
        ticketDto.setTypePassenger(typePassenger);
        ticketDto.setSeat(seat);
        ticketDto.setCustomer(customer);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/tickets")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
    /**
     * check case input incorrect format name
     * input :"Nguyen van hAi"
     * @throws Exception
     */
    @Test
    public void createNewTicket_namePassenger_15_2() throws Exception{
        TypeTicket typeTicket = new TypeTicket();
        typeTicket.setIdTypeTicket(1L);
        Luggage luggage = new Luggage();
        luggage.setIdLuggage(1L);
        luggage.setPriceLuggage(1000L);
        TypePassenger typePassenger = new TypePassenger();
        typePassenger.setIdTypePassenger(1L);
        Route route = new Route();
        route.setIdRoute(1L);
        route.setPriceRoute(2000L);
        TypeSeat typeSeat = new TypeSeat();
        Seat seat = new Seat();
        seat.setIdSeat(1L);
        seat.setTypeSeat(typeSeat);
        seat.setRoute(route);
        typeSeat.setIdTypeSeat(1L);
        typeSeat.setPriceExtra(2L);
        Customer customer =new Customer();
        customer.setIdCustomer(1L);


        TicketDto ticketDto = new TicketDto();
        ticketDto.setNamePassenger("Nguyen van hAi");
        ticketDto.setFlagTicket(false);
        ticketDto.setGenderPassenger(false);
        ticketDto.setEmailPassenger("nguyenanhnhan@gmail.com");
        ticketDto.setTelPassenger("0393554072");
        ticketDto.setIdCardPassenger("201923248123");
        ticketDto.setDateBooking("2023-03-29");
        ticketDto.setTypeTicket(typeTicket);
        ticketDto.setLuggage(luggage);
        ticketDto.setTypePassenger(typePassenger);
        ticketDto.setSeat(seat);
        ticketDto.setCustomer(customer);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/tickets")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
    /**
     * check case input less than 10 characters
     * input :"Nguyen A"
     * @throws Exception
     */
    @Test
    public void createNewTicket_namePassenger_16() throws Exception{
        TypeTicket typeTicket = new TypeTicket();
        typeTicket.setIdTypeTicket(1L);
        Luggage luggage = new Luggage();
        luggage.setIdLuggage(1L);
        luggage.setPriceLuggage(1000L);
        TypePassenger typePassenger = new TypePassenger();
        typePassenger.setIdTypePassenger(1L);
        Route route = new Route();
        route.setIdRoute(1L);
        route.setPriceRoute(2000L);
        TypeSeat typeSeat = new TypeSeat();
        Seat seat = new Seat();
        seat.setIdSeat(1L);
        seat.setTypeSeat(typeSeat);
        seat.setRoute(route);
        typeSeat.setIdTypeSeat(1L);
        typeSeat.setPriceExtra(2L);
        Customer customer =new Customer();
        customer.setIdCustomer(1L);


        TicketDto ticketDto = new TicketDto();
        ticketDto.setNamePassenger("Nguyen A");
        ticketDto.setFlagTicket(false);
        ticketDto.setGenderPassenger(false);
        ticketDto.setEmailPassenger("nguyenanhnhan@gmail.com");
        ticketDto.setTelPassenger("0393554072");
        ticketDto.setIdCardPassenger("201923248123");
        ticketDto.setDateBooking("2023-03-29");
        ticketDto.setTypeTicket(typeTicket);
        ticketDto.setLuggage(luggage);
        ticketDto.setTypePassenger(typePassenger);
        ticketDto.setSeat(seat);
        ticketDto.setCustomer(customer);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/tickets")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * check case input more than 50 characters
     * input :"Nguyen Anh Nhan Nguyen An Nhan Nguyen Anh Nhan Nguyen Anh Nhan Nguyen Anh Nha"
     * @throws Exception
     */
    @Test
    public void createNewTicket_namePassenger_17() throws Exception{
        TypeTicket typeTicket = new TypeTicket();
        typeTicket.setIdTypeTicket(1L);
        Luggage luggage = new Luggage();
        luggage.setIdLuggage(1L);
        luggage.setPriceLuggage(1000L);
        TypePassenger typePassenger = new TypePassenger();
        typePassenger.setIdTypePassenger(1L);
        Route route = new Route();
        route.setIdRoute(1L);
        route.setPriceRoute(2000L);
        TypeSeat typeSeat = new TypeSeat();
        Seat seat = new Seat();
        seat.setIdSeat(1L);
        seat.setTypeSeat(typeSeat);
        seat.setRoute(route);
        typeSeat.setIdTypeSeat(1L);
        typeSeat.setPriceExtra(2L);
        Customer customer =new Customer();
        customer.setIdCustomer(1L);

        TicketDto ticketDto = new TicketDto();
        ticketDto.setNamePassenger("Nguyen Anh Nhan Nguyen An Nhan Nguyen Anh Nhan Nguyen Anh Nhan Nguyen Anh Nha");
        ticketDto.setFlagTicket(false);
        ticketDto.setGenderPassenger(false);
        ticketDto.setEmailPassenger("nguyenanhnhan@gmail.com");
        ticketDto.setTelPassenger("0393554072");
        ticketDto.setIdCardPassenger("201923248123");
        ticketDto.setDateBooking("2023-03-29");
        ticketDto.setTypeTicket(typeTicket);
        ticketDto.setLuggage(luggage);
        ticketDto.setTypePassenger(typePassenger);
        ticketDto.setSeat(seat);
        ticketDto.setCustomer(customer);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/tickets")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * check case input correct format name
     * input :"Nguyen Hung Anh"
     * @throws Exception
     */
    @Test
    public void createNewTicket_namePassenger_18() throws Exception{
        TypeTicket typeTicket = new TypeTicket();
        typeTicket.setIdTypeTicket(1L);
        Luggage luggage = new Luggage();
        luggage.setIdLuggage(1L);
        luggage.setPriceLuggage(1000L);
        TypePassenger typePassenger = new TypePassenger();
        typePassenger.setIdTypePassenger(1L);
        Route route = new Route();
        route.setIdRoute(1L);
        route.setPriceRoute(2000L);
        TypeSeat typeSeat = new TypeSeat();
        Seat seat = new Seat();
        seat.setIdSeat(1L);
        seat.setTypeSeat(typeSeat);
        seat.setRoute(route);
        typeSeat.setIdTypeSeat(1L);
        typeSeat.setPriceExtra(2L);
        Customer customer =new Customer();
        customer.setIdCustomer(1L);


        TicketDto ticketDto = new TicketDto();
        ticketDto.setNamePassenger("Nguyen Hung Anh");
        ticketDto.setFlagTicket(false);
        ticketDto.setGenderPassenger(false);
        ticketDto.setEmailPassenger("hunganh@gmail.com");
        ticketDto.setTelPassenger("0393554072");
        ticketDto.setIdCardPassenger("201923248123");
        ticketDto.setDateBooking("2023-03-29");
        ticketDto.setTypeTicket(typeTicket);
        ticketDto.setLuggage(luggage);
        ticketDto.setTypePassenger(typePassenger);
        ticketDto.setSeat(seat);
        ticketDto.setCustomer(customer);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/tickets")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }
    /**
     * check case select correct format gender
     * input :false
     * @throws Exception
     */
    @Test
    public void createNewTicket_genderPassenger_18() throws Exception{
        TypeTicket typeTicket = new TypeTicket();
        typeTicket.setIdTypeTicket(1L);
        Luggage luggage = new Luggage();
        luggage.setIdLuggage(1L);
        luggage.setPriceLuggage(1000L);
        TypePassenger typePassenger = new TypePassenger();
        typePassenger.setIdTypePassenger(1L);
        Route route = new Route();
        route.setIdRoute(1L);
        route.setPriceRoute(2000L);
        TypeSeat typeSeat = new TypeSeat();
        Seat seat = new Seat();
        seat.setIdSeat(1L);
        seat.setTypeSeat(typeSeat);
        seat.setRoute(route);
        typeSeat.setIdTypeSeat(1L);
        typeSeat.setPriceExtra(2L);
        Customer customer =new Customer();
        customer.setIdCustomer(1L);


        TicketDto ticketDto = new TicketDto();
        ticketDto.setNamePassenger("Nguyen Hung Anh");
        ticketDto.setFlagTicket(false);
        ticketDto.setGenderPassenger(false);
        ticketDto.setEmailPassenger("hunganh@gmail.com");
        ticketDto.setTelPassenger("0393554072");
        ticketDto.setIdCardPassenger("201923248123");
        ticketDto.setDateBooking("2023-03-29");
        ticketDto.setTypeTicket(typeTicket);
        ticketDto.setLuggage(luggage);
        ticketDto.setTypePassenger(typePassenger);
        ticketDto.setSeat(seat);
        ticketDto.setCustomer(customer);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/tickets")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }
    /**
     * check case null gender
     * input :null
     * @throws Exception
     */
    @Test
    public void createNewTicket_genderPassenger_13() throws Exception{
        TypeTicket typeTicket = new TypeTicket();
        typeTicket.setIdTypeTicket(1L);
        Luggage luggage = new Luggage();
        luggage.setIdLuggage(1L);
        luggage.setPriceLuggage(1000L);
        TypePassenger typePassenger = new TypePassenger();
        typePassenger.setIdTypePassenger(1L);
        Route route = new Route();
        route.setIdRoute(1L);
        route.setPriceRoute(2000L);
        TypeSeat typeSeat = new TypeSeat();
        Seat seat = new Seat();
        seat.setIdSeat(1L);
        seat.setTypeSeat(typeSeat);
        seat.setRoute(route);
        typeSeat.setIdTypeSeat(1L);
        typeSeat.setPriceExtra(2L);
        Customer customer =new Customer();
        customer.setIdCustomer(1L);


        TicketDto ticketDto = new TicketDto();
        ticketDto.setNamePassenger("Nguyen Hung Anh");
        ticketDto.setFlagTicket(false);
        ticketDto.setGenderPassenger(null);
        ticketDto.setEmailPassenger("hunganh@gmail.com");
        ticketDto.setTelPassenger("0393554072");
        ticketDto.setIdCardPassenger("201923248123");
        ticketDto.setDateBooking("2023-03-29");
        ticketDto.setTypeTicket(typeTicket);
        ticketDto.setLuggage(luggage);
        ticketDto.setTypePassenger(typePassenger);
        ticketDto.setSeat(seat);
        ticketDto.setCustomer(customer);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/tickets")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * check case correct format email
     * input :hunganh@gmail.com
     * @throws Exception
     */
    @Test
    public void createNewTicket_emailPassenger_18() throws Exception{
        TypeTicket typeTicket = new TypeTicket();
        typeTicket.setIdTypeTicket(1L);
        Luggage luggage = new Luggage();
        luggage.setIdLuggage(1L);
        luggage.setPriceLuggage(1000L);
        TypePassenger typePassenger = new TypePassenger();
        typePassenger.setIdTypePassenger(1L);
        Route route = new Route();
        route.setIdRoute(1L);
        route.setPriceRoute(2000L);
        TypeSeat typeSeat = new TypeSeat();
        Seat seat = new Seat();
        seat.setIdSeat(1L);
        seat.setTypeSeat(typeSeat);
        seat.setRoute(route);
        typeSeat.setIdTypeSeat(1L);
        typeSeat.setPriceExtra(2L);
        Customer customer =new Customer();
        customer.setIdCustomer(1L);


        TicketDto ticketDto = new TicketDto();
        ticketDto.setNamePassenger("Nguyen Hung Anh");
        ticketDto.setFlagTicket(false);
        ticketDto.setGenderPassenger(false);
        ticketDto.setEmailPassenger("hunganh@gmail.com");
        ticketDto.setTelPassenger("0393554072");
        ticketDto.setIdCardPassenger("201923248123");
        ticketDto.setDateBooking("2023-03-29");
        ticketDto.setTypeTicket(typeTicket);
        ticketDto.setLuggage(luggage);
        ticketDto.setTypePassenger(typePassenger);
        ticketDto.setSeat(seat);
        ticketDto.setCustomer(customer);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/tickets")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }
    /**
     * check case input  incorrect format email
     * input :hunganh@gmail
     * @throws Exception
     */
    @Test
    public void createNewTicket_emailPassenger_15_1() throws Exception{
        TypeTicket typeTicket = new TypeTicket();
        typeTicket.setIdTypeTicket(1L);
        Luggage luggage = new Luggage();
        luggage.setIdLuggage(1L);
        luggage.setPriceLuggage(1000L);
        TypePassenger typePassenger = new TypePassenger();
        typePassenger.setIdTypePassenger(1L);
        Route route = new Route();
        route.setIdRoute(1L);
        route.setPriceRoute(2000L);
        TypeSeat typeSeat = new TypeSeat();
        Seat seat = new Seat();
        seat.setIdSeat(1L);
        seat.setTypeSeat(typeSeat);
        seat.setRoute(route);
        typeSeat.setIdTypeSeat(1L);
        typeSeat.setPriceExtra(2L);
        Customer customer =new Customer();
        customer.setIdCustomer(1L);


        TicketDto ticketDto = new TicketDto();
        ticketDto.setNamePassenger("Nguyen Hung Anh");
        ticketDto.setFlagTicket(false);
        ticketDto.setGenderPassenger(false);
        ticketDto.setEmailPassenger("hunganh@.com");
        ticketDto.setTelPassenger("0393554072");
        ticketDto.setIdCardPassenger("201923248123");
        ticketDto.setDateBooking("2023-03-29");
        ticketDto.setTypeTicket(typeTicket);
        ticketDto.setLuggage(luggage);
        ticketDto.setTypePassenger(typePassenger);
        ticketDto.setSeat(seat);
        ticketDto.setCustomer(customer);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/tickets")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * check case input special characters in email
     * input :hung12%g*@gmail.com
     * @throws Exception
     */
    @Test
    public void createNewTicket_emailPassenger_15_2() throws Exception{
        TypeTicket typeTicket = new TypeTicket();
        typeTicket.setIdTypeTicket(1L);
        Luggage luggage = new Luggage();
        luggage.setIdLuggage(1L);
        luggage.setPriceLuggage(1000L);
        TypePassenger typePassenger = new TypePassenger();
        typePassenger.setIdTypePassenger(1L);
        Route route = new Route();
        route.setIdRoute(1L);
        route.setPriceRoute(2000L);
        TypeSeat typeSeat = new TypeSeat();
        Seat seat = new Seat();
        seat.setIdSeat(1L);
        seat.setTypeSeat(typeSeat);
        seat.setRoute(route);
        typeSeat.setIdTypeSeat(1L);
        typeSeat.setPriceExtra(2L);
        Customer customer =new Customer();
        customer.setIdCustomer(1L);


        TicketDto ticketDto = new TicketDto();
        ticketDto.setNamePassenger("Nguyen Hung Anh");
        ticketDto.setFlagTicket(false);
        ticketDto.setGenderPassenger(false);
        ticketDto.setEmailPassenger("hung12%g*@gmail.com");
        ticketDto.setTelPassenger("0393554072");
        ticketDto.setIdCardPassenger("201923248123");
        ticketDto.setDateBooking("2023-03-29");
        ticketDto.setTypeTicket(typeTicket);
        ticketDto.setLuggage(luggage);
        ticketDto.setTypePassenger(typePassenger);
        ticketDto.setSeat(seat);
        ticketDto.setCustomer(customer);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/tickets")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * check case input incorrect format phone number
     * input :0012768341
     * @throws Exception
     */
    @Test
    public void createNewTicket_telPassenger_15() throws Exception{
        TypeTicket typeTicket = new TypeTicket();
        typeTicket.setIdTypeTicket(1L);
        Luggage luggage = new Luggage();
        luggage.setIdLuggage(1L);
        luggage.setPriceLuggage(1000L);
        TypePassenger typePassenger = new TypePassenger();
        typePassenger.setIdTypePassenger(1L);
        Route route = new Route();
        route.setIdRoute(1L);
        route.setPriceRoute(2000L);
        TypeSeat typeSeat = new TypeSeat();
        Seat seat = new Seat();
        seat.setIdSeat(1L);
        seat.setTypeSeat(typeSeat);
        seat.setRoute(route);
        typeSeat.setIdTypeSeat(1L);
        typeSeat.setPriceExtra(2L);
        Customer customer =new Customer();
        customer.setIdCustomer(1L);


        TicketDto ticketDto = new TicketDto();
        ticketDto.setNamePassenger("Nguyen Hung Anh");
        ticketDto.setFlagTicket(false);
        ticketDto.setGenderPassenger(false);
        ticketDto.setEmailPassenger("hung123@yahoo.com.vn");
        ticketDto.setTelPassenger("0012768341");
        ticketDto.setIdCardPassenger("201923248123");
        ticketDto.setDateBooking("2023-03-29");
        ticketDto.setTypeTicket(typeTicket);
        ticketDto.setLuggage(luggage);
        ticketDto.setTypePassenger(typePassenger);
        ticketDto.setSeat(seat);
        ticketDto.setCustomer(customer);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/tickets")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * check case input correct phone number
     * input :0979274983
     * @throws Exception
     */
    @Test
    public void createNewTicket_telPassenger_18() throws Exception{
        TypeTicket typeTicket = new TypeTicket();
        typeTicket.setIdTypeTicket(1L);
        Luggage luggage = new Luggage();
        luggage.setIdLuggage(1L);
        luggage.setPriceLuggage(1000L);
        TypePassenger typePassenger = new TypePassenger();
        typePassenger.setIdTypePassenger(1L);
        Route route = new Route();
        route.setIdRoute(1L);
        route.setPriceRoute(2000L);
        TypeSeat typeSeat = new TypeSeat();
        Seat seat = new Seat();
        seat.setIdSeat(1L);
        seat.setTypeSeat(typeSeat);
        seat.setRoute(route);
        typeSeat.setIdTypeSeat(1L);
        typeSeat.setPriceExtra(2L);
        Customer customer =new Customer();
        customer.setIdCustomer(1L);


        TicketDto ticketDto = new TicketDto();
        ticketDto.setNamePassenger("Nguyen Hung Anh");
        ticketDto.setFlagTicket(false);
        ticketDto.setGenderPassenger(false);
        ticketDto.setEmailPassenger("namhung024@gmail.com");
        ticketDto.setTelPassenger("0979274983");
        ticketDto.setIdCardPassenger("201923248123");
        ticketDto.setDateBooking("2023-03-29");
        ticketDto.setTypeTicket(typeTicket);
        ticketDto.setLuggage(luggage);
        ticketDto.setTypePassenger(typePassenger);
        ticketDto.setSeat(seat);
        ticketDto.setCustomer(customer);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/tickets")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }

    /**
     * check case identity card of passenger null
     * input :null
     * @throws Exception
     */
    @Test
    public void createNewTicket_idCardPassenger_13() throws Exception{
        TypeTicket typeTicket = new TypeTicket();
        typeTicket.setIdTypeTicket(1L);
        Luggage luggage = new Luggage();
        luggage.setIdLuggage(1L);
        luggage.setPriceLuggage(1000L);
        TypePassenger typePassenger = new TypePassenger();
        typePassenger.setIdTypePassenger(1L);
        Route route = new Route();
        route.setIdRoute(1L);
        route.setPriceRoute(2000L);
        TypeSeat typeSeat = new TypeSeat();
        Seat seat = new Seat();
        seat.setIdSeat(1L);
        seat.setTypeSeat(typeSeat);
        seat.setRoute(route);
        typeSeat.setIdTypeSeat(1L);
        typeSeat.setPriceExtra(2L);
        Customer customer =new Customer();
        customer.setIdCustomer(1L);


        TicketDto ticketDto = new TicketDto();
        ticketDto.setNamePassenger("Nguyen Hung Anh");
        ticketDto.setFlagTicket(false);
        ticketDto.setGenderPassenger(false);
        ticketDto.setEmailPassenger("namhung024@gmail.com");
        ticketDto.setTelPassenger("0979274983");
        ticketDto.setIdCardPassenger("null");
        ticketDto.setDateBooking("2023-03-29");
        ticketDto.setTypeTicket(typeTicket);
        ticketDto.setLuggage(luggage);
        ticketDto.setTypePassenger(typePassenger);
        ticketDto.setSeat(seat);
        ticketDto.setCustomer(customer);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/tickets")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * check case identity card of passenger is empty
     * input :""
     * @throws Exception
     */
    @Test
    public void createNewTicket_idCardPassenger_14() throws Exception{
        TypeTicket typeTicket = new TypeTicket();
        typeTicket.setIdTypeTicket(1L);
        Luggage luggage = new Luggage();
        luggage.setIdLuggage(1L);
        luggage.setPriceLuggage(1000L);
        TypePassenger typePassenger = new TypePassenger();
        typePassenger.setIdTypePassenger(1L);
        Route route = new Route();
        route.setIdRoute(1L);
        route.setPriceRoute(2000L);
        TypeSeat typeSeat = new TypeSeat();
        Seat seat = new Seat();
        seat.setIdSeat(1L);
        seat.setTypeSeat(typeSeat);
        seat.setRoute(route);
        typeSeat.setIdTypeSeat(1L);
        typeSeat.setPriceExtra(2L);
        Customer customer =new Customer();
        customer.setIdCustomer(1L);


        TicketDto ticketDto = new TicketDto();
        ticketDto.setNamePassenger("Nguyen Hung Anh");
        ticketDto.setFlagTicket(false);
        ticketDto.setGenderPassenger(false);
        ticketDto.setEmailPassenger("namhung024@gmail.com");
        ticketDto.setTelPassenger("0979274983");
        ticketDto.setIdCardPassenger("");
        ticketDto.setDateBooking("2023-03-29");
        ticketDto.setTypeTicket(typeTicket);
        ticketDto.setLuggage(luggage);
        ticketDto.setTypePassenger(typePassenger);
        ticketDto.setSeat(seat);
        ticketDto.setCustomer(customer);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/tickets")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * check case id card correct format
     * input :B2745913
     * @throws Exception
     */
    @Test
    public void createNewTicket_idCardPassenger_15() throws Exception{
        TypeTicket typeTicket = new TypeTicket();
        typeTicket.setIdTypeTicket(1L);
        Luggage luggage = new Luggage();
        luggage.setIdLuggage(1L);
        luggage.setPriceLuggage(1000L);
        TypePassenger typePassenger = new TypePassenger();
        typePassenger.setIdTypePassenger(1L);
        Route route = new Route();
        route.setIdRoute(1L);
        route.setPriceRoute(2000L);
        TypeSeat typeSeat = new TypeSeat();
        Seat seat = new Seat();
        seat.setIdSeat(1L);
        seat.setTypeSeat(typeSeat);
        seat.setRoute(route);
        typeSeat.setIdTypeSeat(1L);
        typeSeat.setPriceExtra(2L);
        Customer customer =new Customer();
        customer.setIdCustomer(1L);


        TicketDto ticketDto = new TicketDto();
        ticketDto.setNamePassenger("Pham Cong Nam");
        ticketDto.setFlagTicket(false);
        ticketDto.setGenderPassenger(false);
        ticketDto.setEmailPassenger("namhung024@gmail.com");
        ticketDto.setTelPassenger("0979274983");
        ticketDto.setIdCardPassenger("B2745913");
        ticketDto.setDateBooking("2023-03-29");
        ticketDto.setTypeTicket(typeTicket);
        ticketDto.setLuggage(luggage);
        ticketDto.setTypePassenger(typePassenger);
        ticketDto.setSeat(seat);
        ticketDto.setCustomer(customer);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/tickets")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
