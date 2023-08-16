package com.example.air_ticket_booking.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
public class TicketController_showAllTickets {
    @Autowired
    private MockMvc mockMvc;
    /**
     * check showAllTickets page doesn't exist
     * input page -1
     * date create: 11/08/2023
     * @return void
     * @author Nhàn NA
     * @throws Exception
     */
    @Test
    public void showAllTickets_page_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/tickets/booked/{page}",-1))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void showAllTickets_page_0() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/tickets/booked/{page}","nhan"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * check showAllTickets data page does exist
     * input page 0
     * date create: 11/08/2023
     * @return void
     * @author Nhàn NA
     * @throws Exception
     */
    @Test
    public void showAllTickets_page_5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/tickets/booked/{page}",0))
                .andDo(print())
                .andExpect(jsonPath("totalElements").value(2))
                .andExpect(jsonPath("content[0].id").value(1))
                .andExpect(jsonPath("content[1].id").value(2))
                .andExpect(jsonPath("content[0].nameRoute").value("AL-0001"))
                .andExpect(jsonPath("content[1].nameRoute").value("AL-0001"))
                .andExpect(status().is2xxSuccessful());

    }
    /**
     * check  showAllTickets
     * input page null
     * date create: 11/08/2023
     * @return void
     * @author Nhàn NA
     * @throws Exception
     */
    @Test
    public void showAllTickets_page_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/tickets/booked/{page}", (Object) null))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * check  showAllTickets
     * input page is a larger number
     * date create: 11/08/2023
     * @return void
     * @author Nhàn NA
     * @throws Exception
     */
    @Test
    public void showAllTickets_page_35() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/tickets/booked/{page}", 1000000000L))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * check  deleteTicket
     * input id ""
     * date create: 11/08/2023
     * @return void
     * @author Nhàn NA
     * @throws Exception
     */
    @Test
    public void deleteTicket_page_26() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/tickets/{id}",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * check  deleteTicket
     * input id null
     * date create: 11/08/2023
     * @return void
     * @author Nhàn NA
     * @throws Exception
     */
    @Test
    public void deleteTicket_page_25() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/tickets/{id}", (Object) null))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * check  deleteTicket
     * input id doesn't exist
     * date create: 11/08/2023
     * @return void
     * @author Nhàn NA
     * @throws Exception
     */
    @Test
    public void deleteTicket_page_27() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/tickets/{id}",-1))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * check  deleteTicket
     * input id is a larger number
     * date create: 11/08/2023
     * @return void
     * @author Nhàn NA
     * @throws Exception
     */
    @Test
    public void deleteTicket_page_35() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/tickets/{id}",10000000000L))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * check  deleteTicket
     * input id  exist
     * date create: 11/08/2023
     * @return void
     * @author Nhàn NA
     * @throws Exception
     */
    @Test
    public void deleteTicket_page_28() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/tickets/{id}",1))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    /**
     * check deleteTicket
     * input double
     * date create: 11/08/2023
     * @return HttpStatus
     * @author Nhàn NA
     * @throws Exception
     */
    @Test
    public void deleteTicket_page_29() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/tickets/{id}", 0.5))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * check request format"int,string,string,string,string" is decimal
     * @Method searchTickets
     * date create: 11/08/2023
      * param idTypeTicket,tên khách hàng,ngày bay,nơi đến
     * input "1,a,a,a,a" page=0
     * @author Nhàn NA
     * @throws Exception
     */
    @Test
    public void searchTickets_item_page_30() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/tickets/search/{item}/{page}", "1,a,a,a,",0))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    /**
     * check request format"string,string,string,string,string" is decimal
     * @Method searchTickets
     * param idTypeTicket,tên khách hàng,ngày bay,nơi đến
     * input "a,a,a,,",page=0
     * date create: 11/08/2023
     * @author Nhàn NA
     * @throws Exception
     */
    @Test
    public void searchTickets_item_page_31() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/tickets/search/{item}/{page}", "a,a,a,,",0))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * check request String "number,string,string" is decimal
     * @Method searchTickets
     * param idTypeTicket,tên khách hàng,ngày bay,nơi đến
     * date create: 11/08/2023
     * input item="5,a,a"
     * @author Nhàn NA
     * @throws Exception
     */
    @Test
    public void searchTickets_item_page_32() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/tickets/search/{item}/{page}", "5,a,a",0))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * check request String "number,string,string,string,string" is decimal
     * @Method searchTickets
     * date create: 11/08/2023
     * out is empty
     * param idTypeTicket,tên khách hàng,ngày bay,nơi đến
     * input item="5,a,a,a,a" page=4
     * @author Nhàn NA
     * @throws Exception
     */
    @Test
    public void searchTickets_item_page_5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/tickets/search/{item}/{page}", "5,a,a,a,a",4))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    /**
     * @Method searchTickets
     * date create: 11/08/2023
     * output data
     * param idTypeTicket,tên khách hàng,ngày bay,nơi đến
     * input "1,a,a,a," ,page=0
     * @author Nhàn NA
     * @throws Exception
     */
    @Test
    public void searchTickets_item_page_6() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/tickets/search/{item}/{page}", "1,a,a,a,",0))
                .andDo(print())
                .andExpect(jsonPath("content[0].id").value(1))
                .andExpect(jsonPath("content[0].nameRoute").value("AL-0001"))
                .andExpect(status().is2xxSuccessful());
    }
    /**
     * check request String "number,string,string" is decimal
     * @Method searchTickets
     * date create: 11/08/2023
     * output data
     * param idTypeTicket,tên khách hàng,ngày bay,nơi đến
     * input "1,a,a,a," ,page=0
     * @author Nhàn NA
     * @throws Exception
     */
    @Test
    public void searchTickets_item_page_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/tickets/search/{item}/{page}", ",'','','',''",0))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * check request String "number,string,string" is decimal
     * @Method searchTickets
     * date create: 11/08/2023
     * param idTypeTicket,tên khách hàng,ngày bay,nơi đến
     * output data
     * input "1,,,," ,page=10000000000
     * @author Nhàn NA
     * @throws Exception
     */
    @Test
    public void searchTickets_item_page_35() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/tickets/search/{item}/{page}", "1,'','','',''",10000000000L))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * check data ticket unbooked
     * @Method findAllTicketUnbooked
     * date create: 11/08/2023
     * output data
     * param idTypeTicket,tên ghế,ngày bay,nơi đến
     * input "1,a,a,a," ,page=0
     * @author Nhàn NA
     * @throws Exception
     */
    @Test
    public void findAllTicketUnbooked_page_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/tickets/unbooked/{page}", (Object) null))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * check data ticket unbooked
     * @Method findAllTicketUnbooked
     * date create: 11/08/2023
     * param idTypeTicket,tên ghế,ngày bay,nơi đến
     * output data
     * input page doesn't exist
     * @author Nhàn NA
     * @throws Exception
     */
    @Test
    public void findAllTicketUnbooked_page_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/tickets/unbooked/{page}", -1))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * check data ticket unbooked
     * @Method findAllTicketUnbooked
     * date create: 11/08/2023
     * param idTypeTicket,tên ghế,ngày bay,nơi đến
     * output data
     * input page is empty
     * @author Nhàn NA
     * @throws Exception
     */
    @Test
    public void findAllTicketUnbooked_page_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/tickets/unbooked/{page}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * check data ticket unbooked
     * @Method findAllTicketUnbooked
     * date create: 11/08/2023
     * param idTypeTicket,tên ghế,ngày bay,nơi đến
     * output data
     * input page larger number
     * @author Nhàn NA
     * @throws Exception
     */
    @Test
    public void findAllTicketUnbooked_page_35() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/tickets/unbooked/{page}", 100000000000L))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * check data ticket unbooked
     * @Method findAllTicketUnbooked
     * date create: 11/08/2023
     * param idTypeTicket,tên ghế,ngày bay,nơi đến
     * output data
     * input page =0
     * @author Nhàn NA
     * @throws Exception
     */
    @Test
    public void findAllTicketUnbooked_page_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/tickets/unbooked/{page}", 0))
                .andDo(print())
                .andExpect(jsonPath("content[0].id").value(3))
                .andExpect(jsonPath("content[0].positionSeat").value("A-03"))
                .andExpect(jsonPath("content[4].id").value(7))
                .andExpect(jsonPath("content[4].positionSeat").value("B-03"))
                .andExpect(status().is2xxSuccessful());
    }
    /**
     * check indAllTicketUnbooked
     * @Method search unbooked ticket
     * date create: 11/08/2023
     * param idTypeTicket,tên ghế,ngày bay,nơi đến
     * input page = double
     * @author Nhàn NA
     * @throws Exception
     */
    @Test
    public void findAllTicketUnbooked_page_29() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/tickets/unbooked/{page}", 1.5))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * check indAllTicketUnbooked
     * @Method search unbooked ticket
     * date create: 11/08/2023
     * param idTypeTicket,tên ghế,ngày bay,nơi đến
     * input page = 0 ,item="1,a,a,,"
     * @author Nhàn NA
     * @throws Exception
     */
    @Test
    public void findAllTicketUnbooked_item_page_30() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/tickets/search/{item}/{page}", "1,a,a,,",0))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    /**
     * check searchTicketsUnBooked
     * @Method search ticket
     * param idTypeTicket,tên ghế,ngày bay,nơi đến
     * input item="a,a,a,,",page=0
     * date create: 11/08/2023
     * @author Nhàn NA
     * @throws Exception
     */
    @Test
    public void searchTicketsUnBooked_item_page_31() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/tickets/search/{item}/{page}", "a,a,a,,",0))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * check searchTicketsUnBooked
     * @Method search unbooked ticket
     * param idTypeTicket,tên ghế,ngày bay,nơi đến
     * input item="5,a,a",page=0
     * date create: 11/08/2023
     * @author Nhàn NA
     * @throws Exception
     */
    @Test
    public void searchTicketsUnBooked_item_page_32() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/tickets/search/{item}/{page}", "5,a,a",0))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * check searchTicketsUnBooked
     * @Method search unbooked ticket
     * param idTypeTicket,tên ghế,ngày bay,nơi đến
     * input "5,a,a,a,a",page=4
     * date create: 11/08/2023
     * @author Nhàn NA
     * @throws Exception
     */
    @Test
    public void searchTicketsUnBooked_item_page_5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/tickets/search/{item}/{page}", "5,a,a,a,a",4))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    /**
     * check searchTicketsUnBooked
     * @Method search unbooked ticket
     * param idTypeTicket,tên ghế,ngày bay,nơi đến
     * input "1,a,a,a,",page=0
     * date create: 11/08/2023
     * @author Nhàn NA
     * @throws Exception
     */
    @Test
    public void searchTicketsUnBooked_item_page_6() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/tickets/search/{item}/{page}", "1,a,a,a,",0))
                .andDo(print())
                .andExpect(jsonPath("content[0].id").value(1))
                .andExpect(jsonPath("content[0].nameRoute").value("AL-0001"))
                .andExpect(status().is2xxSuccessful());
    }
}
