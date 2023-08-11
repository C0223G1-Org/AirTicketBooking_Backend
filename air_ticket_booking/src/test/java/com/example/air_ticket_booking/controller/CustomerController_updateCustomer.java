package com.example.air_ticket_booking.controller;

import com.example.air_ticket_booking.dto.customer.CustomerDto;
import com.example.air_ticket_booking.model.account.Account;
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

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerController_updateCustomer {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


//    Name
    @Test
    public void updateCustomer_name_19() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setNameCustomer(null);
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("31/01/2000");
        Account account = new Account();
        account.setIdAccount(1L);
        customerDto.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customers/{id}","1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON).characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateCustomer_name_20() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setNameCustomer("");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("31/01/2000");
        Account account = new Account();
        account.setIdAccount(1L);
        customerDto.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customers/{id}","1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE).characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateCustomer_name_21() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setNameCustomer("Hoa123");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("31/01/2000");
        Account account = new Account();
        account.setIdAccount(1L);
        customerDto.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customers/{id}","1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE).characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateCustomer_name_22() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setNameCustomer("Ho");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("31/01/2000");
        Account account = new Account();
        account.setIdAccount(1L);
        customerDto.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customers/{id}","1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE).characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateCustomer_name_23() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setNameCustomer("Hoaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("31/01/2000");
        Account account = new Account();
        account.setIdAccount(1L);
        customerDto.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customers/{id}","1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE).characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateCustomer_name_24() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("31/01/2000");
        Account account = new Account();
        account.setIdAccount(1L);
        customerDto.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customers/{id}","1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE).characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    //    Email
    @Test
    public void updateCustomer_emailCustomer_19() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer(null);
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("31/01/2000");
        Account account = new Account();
        account.setIdAccount(1L);
        customerDto.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customers/{id}","1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON).characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateCustomer_emailCustomer_20() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("31/01/2000");
        Account account = new Account();
        account.setIdAccount(1L);
        customerDto.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customers/{id}","1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE).characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateCustomer_emailCustomer_21() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("31/01/2000");
        Account account = new Account();
        account.setIdAccount(1L);
        customerDto.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customers/{id}","1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE).characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateCustomer_emailCustomer_22() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("h@gmail.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("31/01/2000");
        Account account = new Account();
        account.setIdAccount(1L);
        customerDto.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customers/{id}","1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE).characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateCustomer_emailCustomer_23() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.commmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("31/01/2000");
        Account account = new Account();
        account.setIdAccount(1L);
        customerDto.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customers/{id}","1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE).characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateCustomer_emailCustomer_24() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("31/01/2000");
        Account account = new Account();
        account.setIdAccount(1L);
        customerDto.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customers/{id}","1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE).characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    //    Telephone number
    @Test
    public void updateCustomer_telCustomer_19() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer(null);
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("31/01/2000");
        Account account = new Account();
        account.setIdAccount(1L);
        customerDto.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customers/{id}","1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON).characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateCustomer_telCustomer_20() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("31/01/2000");
        Account account = new Account();
        account.setIdAccount(1L);
        customerDto.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customers/{id}","1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE).characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateCustomer_telCustomer_21() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gmail.com");
        customerDto.setTelCustomer("7397215463");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("31/01/2000");
        Account account = new Account();
        account.setIdAccount(1L);
        customerDto.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customers/{id}","1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE).characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateCustomer_telCustomer_22() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("03972154");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("31/01/2000");
        Account account = new Account();
        account.setIdAccount(1L);
        customerDto.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customers/{id}","1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE).characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateCustomer_telCustomer_23() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("039721546321");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("31/01/2000");
        Account account = new Account();
        account.setIdAccount(1L);
        customerDto.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customers/{id}","1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE).characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateCustomer_telCustomer_24() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("31/01/2000");
        Account account = new Account();
        account.setIdAccount(1L);
        customerDto.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customers/{id}","1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE).characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    //    Address
    @Test
    public void updateCustomer_addressCustomer_19() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer(null);
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("31/01/2000");
        Account account = new Account();
        account.setIdAccount(1L);
        customerDto.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customers/{id}","1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON).characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateCustomer_addressCustomer_20() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("31/01/2000");
        Account account = new Account();
        account.setIdAccount(1L);
        customerDto.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customers/{id}","1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE).characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateCustomer_addressCustomer_22() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("31/01/2000");
        Account account = new Account();
        account.setIdAccount(1L);
        customerDto.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customers/{id}","1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE).characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateCustomer_addressCustomer_23() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Quang Nammmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("31/01/2000");
        Account account = new Account();
        account.setIdAccount(1L);
        customerDto.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customers/{id}","1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE).characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateCustomer_addressCustomer_24() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("31/01/2000");
        Account account = new Account();
        account.setIdAccount(1L);
        customerDto.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customers/{id}","1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE).characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    //    Nationality
    @Test
    public void updateCustomer_nationalityCustomer_19() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer(null);
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("31/01/2000");
        Account account = new Account();
        account.setIdAccount(1L);
        customerDto.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customers/{id}","1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON).characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateCustomer_nationalityCustomer_20() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("31/01/2000");
        Account account = new Account();
        account.setIdAccount(1L);
        customerDto.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customers/{id}","1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE).characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void updateCustomer_nationalityCustomer_24() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("31/01/2000");
        Account account = new Account();
        account.setIdAccount(1L);
        customerDto.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customers/{id}","1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE).characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    //    ID Card
    @Test
    public void updateCustomer_idCardCustomer_19() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer(null);
        customerDto.setDateCustomer("31/01/2000");
        Account account = new Account();
        account.setIdAccount(1L);
        customerDto.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customers/{id}","1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON).characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateCustomer_idCardCustomer_20() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("");
        customerDto.setDateCustomer("31/01/2000");
        Account account = new Account();
        account.setIdAccount(1L);
        customerDto.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customers/{id}","1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE).characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateCustomer_idCardCustomer_21() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gmail.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("123456asc");
        customerDto.setDateCustomer("31/01/2000");
        Account account = new Account();
        account.setIdAccount(1L);
        customerDto.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customers/{id}","1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE).characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateCustomer_idCardCustomer_22() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("01234578");
        customerDto.setDateCustomer("31/01/2000");
        Account account = new Account();
        account.setIdAccount(1L);
        customerDto.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customers/{id}","1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE).characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateCustomer_idCardCustomer_23() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("0123456789741");
        customerDto.setDateCustomer("31/01/2000");
        Account account = new Account();
        account.setIdAccount(1L);
        customerDto.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customers/{id}","1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE).characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateCustomer_idCardCustomer_24() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("31/01/2000");
        Account account = new Account();
        account.setIdAccount(1L);
        customerDto.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customers/{id}","1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE).characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    //    Date of birth
    @Test
    public void updateCustomer_dateOfBirthCustomer_19() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer(null);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customers/{id}","1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON).characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateCustomer_dateOfBirthCustomer_20() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("");
        Account account = new Account();
        account.setIdAccount(1L);
        customerDto.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customers/{id}","1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE).characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateCustomer_dateOfBirthCustomer_21() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gmail.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Đại Lộc,Quảng Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("31/01/2008");
        Account account = new Account();
        account.setIdAccount(1L);
        customerDto.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customers/{id}","1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE).characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateCustomer_dateOfBirthCustomer_24() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("31/01/2000");
        Account account = new Account();
        account.setIdAccount(1L);
        customerDto.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customers/{id}","1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE).characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
