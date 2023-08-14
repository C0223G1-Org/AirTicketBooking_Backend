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

    /**
     * Create by: HoaLTY
     * Date create: 11/08/2023
     * Function: test the name field is null
     * @throws Exception
     */
    @Test
    public void updateCustomer_name_19() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setIdCustomer(1L);
        customerDto.setFlagCustomer(false);
        customerDto.setNameCustomer(null);
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("2000-01-31");
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

    /**
     * Create by: HoaLTY
     * Date create: 11/08/2023
     * Function: test the name field is empty
     * @throws Exception
     */
    @Test
    public void updateCustomer_name_20() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setIdCustomer(1L);
        customerDto.setFlagCustomer(false);
        customerDto.setNameCustomer("");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("2000-01-31");
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

    /**
     * Create by: HoaLTY
     * Date create: 11/08/2023
     * Function: test the name field contains number
     * @throws Exception
     */
    @Test
    public void updateCustomer_name_21() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setIdCustomer(1L);
        customerDto.setFlagCustomer(false);
        customerDto.setNameCustomer("Hoa123");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("2000-01-31");
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

    /**
     * Create by: HoaLTY
     * Date create: 11/08/2023
     * Function: test the length of the name field is less than 3 characters
     * @throws Exception
     */
    @Test
    public void updateCustomer_name_22() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setIdCustomer(1L);
        customerDto.setFlagCustomer(false);
        customerDto.setNameCustomer("Ho");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("2000-01-31");
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

    /**
     * Create by: HoaLTY
     * Date create: 11/08/2023
     * Function: test the length of the name field is greater than 30 characters
     * @throws Exception
     */
    @Test
    public void updateCustomer_name_23() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setIdCustomer(1L);
        customerDto.setFlagCustomer(false);
        customerDto.setNameCustomer("Hoaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("2000-01-31");
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

    /**
     * Create by: HoaLTY
     * Date create: 11/08/2023
     * Function: test name field is valid
     * @throws Exception
     */
    @Test
    public void updateCustomer_name_24() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setIdCustomer(1L);
        customerDto.setFlagCustomer(false);
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("2000-01-31");
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

    /**
     * Create by: HoaLTY
     * Date create: 11/08/2023
     * Function: test the email field is null
     * @throws Exception
     */
    @Test
    public void updateCustomer_emailCustomer_19() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setIdCustomer(1L);
        customerDto.setFlagCustomer(false);
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer(null);
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("2000-01-31");
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

    /**
     * Create by: HoaLTY
     * Date create: 11/08/2023
     * Function: test the field email is empty
     * @throws Exception
     */
    @Test
    public void updateCustomer_emailCustomer_20() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setIdCustomer(1L);
        customerDto.setFlagCustomer(false);
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("2000-01-31");
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

    /**
     * Create by: HoaLTY
     * Date create: 11/08/2023
     * Function: test the email field invalid
     * @throws Exception
     */
    @Test
    public void updateCustomer_emailCustomer_21() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setIdCustomer(1L);
        customerDto.setFlagCustomer(false);
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("2000-01-31");
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

    /**
     * Create by: HoaLTY
     * Date create: 11/08/2023
     * Function: test the length of the email field is less than 12 characters
     * @throws Exception
     */
    @Test
    public void updateCustomer_emailCustomer_22() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setIdCustomer(1L);
        customerDto.setFlagCustomer(false);
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("h@gmail.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("2000-01-31");
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

    /**
     * Create by: HoaLTY
     * Date create: 11/08/2023
     * Function: test the length of the email field is greater than 50 characters
     * @throws Exception
     */
    @Test
    public void updateCustomer_emailCustomer_23() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setIdCustomer(1L);
        customerDto.setFlagCustomer(false);
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.commmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("2000-01-31");
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

    /**
     * Create by: HoaLTY
     * Date create: 11/08/2023
     * Function: test the email field is valid
     * @throws Exception
     */
    @Test
    public void updateCustomer_emailCustomer_24() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setIdCustomer(1L);
        customerDto.setFlagCustomer(false);
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("2000-01-31");
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

    /**
     * Create by: HoaLTY
     * Date create: 11/08/2023
     * Function: test the tel_customer field is null
     * @throws Exception
     */
    @Test
    public void updateCustomer_telCustomer_19() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setIdCustomer(1L);
        customerDto.setFlagCustomer(false);
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer(null);
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("2000-01-31");
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

    /**
     * Create by: HoaLTY
     * Date create: 11/08/2023
     * Function: test the tel_customer field is empty
     * @throws Exception
     */
    @Test
    public void updateCustomer_telCustomer_20() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setIdCustomer(1L);
        customerDto.setFlagCustomer(false);
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("2000-01-31");
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

    /**
     * Create by: HoaLTY
     * Date create: 11/08/2023
     * Function: test the tel_customer field invalid
     * @throws Exception
     */
    @Test
    public void updateCustomer_telCustomer_21() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setIdCustomer(1L);
        customerDto.setFlagCustomer(false);
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gmail.com");
        customerDto.setTelCustomer("7397215463");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("2000-01-31");
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

    /**
     * Create by: HoaLTY
     * Date create: 11/08/2023
     * Function: test the length of the tel_customer field is less than 10 numbers
     * @throws Exception
     */
    @Test
    public void updateCustomer_telCustomer_22() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setIdCustomer(1L);
        customerDto.setFlagCustomer(false);
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("03972154");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("2000-01-31");
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

    /**
     * Create by: HoaLTY
     * Date create: 11/08/2023
     * Function: test the length of the tel_customer field is greater than 10 numbers
     * @throws Exception
     */
    @Test
    public void updateCustomer_telCustomer_23() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setIdCustomer(1L);
        customerDto.setFlagCustomer(false);
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("039721546321");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("2000-01-31");
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

    /**
     * Create by: HoaLTY
     * Date create: 11/08/2023
     * Function: test the tel_customer field is valid
     * @throws Exception
     */
    @Test
    public void updateCustomer_telCustomer_24() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setIdCustomer(1L);
        customerDto.setFlagCustomer(false);
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("2000-01-31");
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

    /**
     * Create by: HoaLTY
     * Date create: 11/08/2023
     * Function: test the address field is null
     * @throws Exception
     */
    @Test
    public void updateCustomer_addressCustomer_19() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setIdCustomer(1L);
        customerDto.setFlagCustomer(false);
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer(null);
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("2000-01-31");
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

    /**
     * Create by: HoaLTY
     * Date create: 11/08/2023
     * Function: test the address field is empty
     * @throws Exception
     */
    @Test
    public void updateCustomer_addressCustomer_20() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setIdCustomer(1L);
        customerDto.setFlagCustomer(false);
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("2000-01-31");
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

    /**
     * Create by: HoaLTY
     * Date create: 11/08/2023
     * Function: test the length of the address field is less than  10 characters
     * @throws Exception
     */
    @Test
    public void updateCustomer_addressCustomer_22() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setIdCustomer(1L);
        customerDto.setFlagCustomer(false);
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("2000-01-31");
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

    /**
     * Create by: HoaLTY
     * Date create: 11/08/2023
     * Function: test the length of the address field is greater than  100 characters
     * @throws Exception
     */
    @Test
    public void updateCustomer_addressCustomer_23() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setIdCustomer(1L);
        customerDto.setFlagCustomer(false);
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Quang Nammmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("2000-01-31");
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

    /**
     * Create by: HoaLTY
     * Date create: 11/08/2023
     * Function: test the address field is valid
     * @throws Exception
     */
    @Test
    public void updateCustomer_addressCustomer_24() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setIdCustomer(1L);
        customerDto.setFlagCustomer(false);
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Dai Loc,Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("2000-01-31");
        Account account = new Account();
        account.setIdAccount(1L);
        customerDto.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customers/{id}","1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    //    Nationality

    /**
     * Create by: HoaLTY
     * Date create: 11/08/2023
     * Function: test the nationality field is null
     * @throws Exception
     */
    @Test
    public void updateCustomer_nationalityCustomer_19() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setIdCustomer(1L);
        customerDto.setFlagCustomer(false);
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Dai Loc,Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer(null);
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("2000-01-31");
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

    /**
     * Create by: HoaLTY
     * Date create: 11/08/2023
     * Function: test the nationality field is empty
     * @throws Exception
     */
    @Test
    public void updateCustomer_nationalityCustomer_20() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setIdCustomer(1L);
        customerDto.setFlagCustomer(false);
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Dai Loc,Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("2000-01-31");
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

    /**
     * Create by: HoaLTY
     * Date create: 11/08/2023
     * Function: test the nationality field is valid
     * @throws Exception
     */
    @Test
    public void updateCustomer_nationalityCustomer_24() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setIdCustomer(1L);
        customerDto.setFlagCustomer(false);
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Dai Loc,Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("2000-01-31");
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

    /**
     * Create by: HoaLTY
     * Date create: 11/08/2023
     * Function: test the ID card field is null
     * @throws Exception
     */
    @Test
    public void updateCustomer_idCardCustomer_19() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setIdCustomer(1L);
        customerDto.setFlagCustomer(false);
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Dai Loc,Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer(null);
        customerDto.setDateCustomer("2000-01-31");
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

    /**
     * Create by: HoaLTY
     * Date create: 11/08/2023
     * Function: test the ID card field is empty
     * @throws Exception
     */
    @Test
    public void updateCustomer_idCardCustomer_20() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setIdCustomer(1L);
        customerDto.setFlagCustomer(false);
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Dai Loc,Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("");
        customerDto.setDateCustomer("2000-01-31");
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

    /**
     * Create by: HoaLTY
     * Date create: 11/08/2023
     * Function: test the ID card field invalid
     * @throws Exception
     */
    @Test
    public void updateCustomer_idCardCustomer_21() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setIdCustomer(1L);
        customerDto.setFlagCustomer(false);
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gmail.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Dai Loc,Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("123456asc");
        customerDto.setDateCustomer("2000-01-31");
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

    /**
     * Create by: HoaLTY
     * Date create: 11/08/2023
     * Function: test the length of the ID card field is less than 9 characters
     * @throws Exception
     */
    @Test
    public void updateCustomer_idCardCustomer_22() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setIdCustomer(1L);
        customerDto.setFlagCustomer(false);
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Dai Loc,Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("01234578");
        customerDto.setDateCustomer("2000-01-31");
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

    /**
     * Create by: HoaLTY
     * Date create: 11/08/2023
     * Function: test the length of the ID card field is greater than 12 characters
     * @throws Exception
     */
    @Test
    public void updateCustomer_idCardCustomer_23() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setIdCustomer(1L);
        customerDto.setFlagCustomer(false);
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Dai Loc,Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("0123456789741");
        customerDto.setDateCustomer("2000-01-31");
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

    /**
     * Create by: HoaLTY
     * Date create: 11/08/2023
     * Function: test the ID card field is valid
     * @throws Exception
     */
    @Test
    public void updateCustomer_idCardCustomer_24() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setIdCustomer(1L);
        customerDto.setFlagCustomer(false);
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Dai Loc, Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("2000-01-31");
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

    /**
     * Create by: HoaLTY
     * Date create: 11/08/2023
     * Function: test the date of birth field is null
     * @throws Exception
     */
    @Test
    public void updateCustomer_dateOfBirthCustomer_19() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setIdCustomer(1L);
        customerDto.setFlagCustomer(false);
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Dai Loc,Quang Nam");
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

    /**
     * Create by: HoaLTY
     * Date create: 11/08/2023
     * Function: test the date of birth field is empty
     * @throws Exception
     */
    @Test
    public void updateCustomer_dateOfBirthCustomer_20() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setIdCustomer(1L);
        customerDto.setFlagCustomer(false);
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Dai Loc,Quang Nam");
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

    /**
     * Create by: HoaLTY
     * Date create: 11/08/2023
     * Function: test the date of birth field is less than 18 years old
     * @throws Exception
     */
    @Test
    public void updateCustomer_dateOfBirthCustomer_21() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setIdCustomer(1L);
        customerDto.setFlagCustomer(false);
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gmail.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Đại Lộc,Quảng Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("2008-01-01");
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

    /**
     * Create by: HoaLTY
     * Date create: 11/08/2023
     * Function: test the date of birth field is valid
     * @throws Exception
     */
    @Test
    public void updateCustomer_dateOfBirthCustomer_24() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setIdCustomer(1L);
        customerDto.setFlagCustomer(false);
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Dai Loc,Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("2000-01-31");
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

    /**
     * Create by: HoaLTY
     * Date create: 11/08/2023
     * Function: test the date of birth field invalid
     * @throws Exception
     */
    @Test
    public void updateCustomer_dateOfBirthCustomer() throws Exception {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setIdCustomer(1L);
        customerDto.setFlagCustomer(false);
        customerDto.setNameCustomer("Lê Thị Yến Hoa");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("lsyh31@gamil.com");
        customerDto.setTelCustomer("0397215463");
        customerDto.setAddressCustomer("Dai Loc,Quang Nam");
        customerDto.setImgCustomer("");
        customerDto.setNationalityCustomer("Viet Nam");
        customerDto.setIdCardCustomer("012345678974");
        customerDto.setDateCustomer("2000/01/01");
        Account account = null;
//        account.setIdAccount(1L);
        customerDto.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customers/{id}","1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE).characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
