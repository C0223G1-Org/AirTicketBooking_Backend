package com.example.air_ticket_booking.controller.account;

import com.example.air_ticket_booking.dto.account.AccountDto;
import com.example.air_ticket_booking.reponse.JwtRequest;
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
public class AccountController_signup {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Created by: NhanDT
     * Date created: 11/08/2023
     *
     * Check case null email
     * @throws Exception
     */
    @Test
    public void signUp_email_13() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setEmailCustomer(null);
        accountDto.setPassword("12345678A");
        accountDto.setTelCustomer("0123456789");
        accountDto.setNameCustomer("Đỗ Thành Nhân");
        accountDto.setDateCustomer("02/02/2000");
        accountDto.setAddressCustomer("Đà Nẵng");
        accountDto.setGenderCustomer(false);
        accountDto.setNationalityCustomer("Viêt Nam");
        accountDto.setIdCardCustomer("012345678912");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/account/signup")
                        .content(this.objectMapper.writeValueAsString(accountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: NhanDT
     * Date created: 11/08/2023
     *
     * Check case null password
     * @throws Exception
     */
    @Test
    public void signUp_password_13() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setEmailCustomer("nhan123@gmail.com");
        accountDto.setPassword(null);
        accountDto.setTelCustomer("0123456789");
        accountDto.setNameCustomer("Đỗ Thành Nhân");
        accountDto.setDateCustomer("02/02/2000");
        accountDto.setAddressCustomer("Đà Nẵng");
        accountDto.setGenderCustomer(false);
        accountDto.setNationalityCustomer("Viêt Nam");
        accountDto.setIdCardCustomer("012345678912");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/account/signup")
                        .content(this.objectMapper.writeValueAsString(accountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Created by: NhanDT
     * Date created: 11/08/2023
     *
     * Check case null phoneNumber
     * @throws Exception
     */
    @Test
    public void signUp_phoneNumber_13() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setEmailCustomer("nhan123@gmail.com");
        accountDto.setPassword("12345678A");
        accountDto.setTelCustomer(null);
        accountDto.setNameCustomer("Đỗ Thành Nhân");
        accountDto.setDateCustomer("02/02/2000");
        accountDto.setAddressCustomer("Đà Nẵng");
        accountDto.setGenderCustomer(false);
        accountDto.setNationalityCustomer("Viêt Nam");
        accountDto.setIdCardCustomer("012345678912");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/account/signup")
                        .content(this.objectMapper.writeValueAsString(accountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: NhanDT
     * Date created: 11/08/2023
     *
     * Check case null name
     * @throws Exception
     */
    @Test
    public void signUp_name_13() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setEmailCustomer("nhan123@gmail.com");
        accountDto.setPassword("12345678A");
        accountDto.setTelCustomer("0123456789");
        accountDto.setNameCustomer(null);
        accountDto.setDateCustomer("02/02/2000");
        accountDto.setAddressCustomer("Đà Nẵng");
        accountDto.setGenderCustomer(false);
        accountDto.setNationalityCustomer("Viêt Nam");
        accountDto.setIdCardCustomer("012345678912");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/account/signup")
                        .content(this.objectMapper.writeValueAsString(accountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: NhanDT
     * Date created: 11/08/2023
     *
     * Check case null dayOfBirth
     * @throws Exception
     */
    @Test
    public void signUp_dayOfBirth_13() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setEmailCustomer("nhan123@gmail.com");
        accountDto.setPassword("12345678A");
        accountDto.setTelCustomer("0123456789");
        accountDto.setNameCustomer("Đỗ Thành Nhân");
        accountDto.setDateCustomer(null);
        accountDto.setAddressCustomer("Đà Nẵng");
        accountDto.setGenderCustomer(false);
        accountDto.setNationalityCustomer("Viêt Nam");
        accountDto.setIdCardCustomer("012345678912");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/account/signup")
                        .content(this.objectMapper.writeValueAsString(accountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: NhanDT
     * Date created: 11/08/2023
     *
     * Check case null idCard
     * @throws Exception
     */
    @Test
    public void signUp_idCard_13() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setEmailCustomer("nhan123@gmail.com");
        accountDto.setPassword("12345678A");
        accountDto.setTelCustomer("0123456789");
        accountDto.setNameCustomer("Đỗ Thành Nhân");
        accountDto.setDateCustomer("02/02/2000");
        accountDto.setAddressCustomer("Đà Nẵng");
        accountDto.setGenderCustomer(false);
        accountDto.setNationalityCustomer("Viêt Nam");
        accountDto.setIdCardCustomer(null);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/account/signup")
                        .content(this.objectMapper.writeValueAsString(accountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Created by: NhanDT
     * Date created: 11/08/2023
     *
     * Check case null nationality
     * @throws Exception
     */
    @Test
    public void signUp_nationality_13() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setEmailCustomer("nhan123@gmail.com");
        accountDto.setPassword("12345678A");
        accountDto.setTelCustomer("0123456789");
        accountDto.setNameCustomer("Đỗ Thành Nhân");
        accountDto.setDateCustomer("02/02/2000");
        accountDto.setAddressCustomer("Đà Nẵng");
        accountDto.setGenderCustomer(false);
        accountDto.setNationalityCustomer(null);
        accountDto.setIdCardCustomer("123456789");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/account/signup")
                        .content(this.objectMapper.writeValueAsString(accountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: NhanDT
     * Date created: 11/08/2023
     *
     * Check case empty email
     * @throws Exception
     */
    @Test
    public void signUp_email_14() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setEmailCustomer("");
        accountDto.setPassword("12345678A");
        accountDto.setTelCustomer("0123456789");
        accountDto.setNameCustomer("Đỗ Thành Nhân");
        accountDto.setDateCustomer("02/02/2000");
        accountDto.setAddressCustomer("Đà Nẵng");
        accountDto.setGenderCustomer(false);
        accountDto.setNationalityCustomer("Viêt Nam");
        accountDto.setIdCardCustomer("012345678912");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/account/signup")
                        .content(this.objectMapper.writeValueAsString(accountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: NhanDT
     * Date created: 11/08/2023
     *
     * Check case empty password
     * @throws Exception
     */
    @Test
    public void signUp_password_14() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setEmailCustomer("nhan123@gmail.com");
        accountDto.setPassword("");
        accountDto.setTelCustomer("0123456789");
        accountDto.setNameCustomer("Đỗ Thành Nhân");
        accountDto.setDateCustomer("02/02/2000");
        accountDto.setAddressCustomer("Đà Nẵng");
        accountDto.setGenderCustomer(false);
        accountDto.setNationalityCustomer("Viêt Nam");
        accountDto.setIdCardCustomer("012345678912");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/account/signup")
                        .content(this.objectMapper.writeValueAsString(accountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Created by: NhanDT
     * Date created: 11/08/2023
     *
     * Check case empty phoneNumber
     * @throws Exception
     */
    @Test
    public void signUp_phoneNumber_14() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setEmailCustomer("nhan123@gmail.com");
        accountDto.setPassword("12345678A");
        accountDto.setTelCustomer("");
        accountDto.setNameCustomer("Đỗ Thành Nhân");
        accountDto.setDateCustomer("02/02/2000");
        accountDto.setAddressCustomer("Đà Nẵng");
        accountDto.setGenderCustomer(false);
        accountDto.setNationalityCustomer("Viêt Nam");
        accountDto.setIdCardCustomer("012345678912");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/account/signup")
                        .content(this.objectMapper.writeValueAsString(accountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: NhanDT
     * Date created: 11/08/2023
     *
     * Check case empty name
     * @throws Exception
     */
    @Test
    public void signUp_name_14() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setEmailCustomer("nhan123@gmail.com");
        accountDto.setPassword("12345678A");
        accountDto.setTelCustomer("0123456789");
        accountDto.setNameCustomer("");
        accountDto.setDateCustomer("02/02/2000");
        accountDto.setAddressCustomer("Đà Nẵng");
        accountDto.setGenderCustomer(false);
        accountDto.setNationalityCustomer("Viêt Nam");
        accountDto.setIdCardCustomer("012345678912");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/account/signup")
                        .content(this.objectMapper.writeValueAsString(accountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: NhanDT
     * Date created: 11/08/2023
     *
     * Check case empty dayOfBirth
     * @throws Exception
     */
    @Test
    public void signUp_dayOfBirth_14() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setEmailCustomer("nhan123@gmail.com");
        accountDto.setPassword("12345678A");
        accountDto.setTelCustomer("0123456789");
        accountDto.setNameCustomer("Đỗ Thành Nhân");
        accountDto.setDateCustomer("");
        accountDto.setAddressCustomer("Đà Nẵng");
        accountDto.setGenderCustomer(false);
        accountDto.setNationalityCustomer("Viêt Nam");
        accountDto.setIdCardCustomer("012345678912");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/account/signup")
                        .content(this.objectMapper.writeValueAsString(accountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: NhanDT
     * Date created: 11/08/2023
     *
     * Check case empty idCard
     * @throws Exception
     */
    @Test
    public void signUp_idCard_14() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setEmailCustomer("nhan123@gmail.com");
        accountDto.setPassword("12345678A");
        accountDto.setTelCustomer("0123456789");
        accountDto.setNameCustomer("Đỗ Thành Nhân");
        accountDto.setDateCustomer("02/02/2000");
        accountDto.setAddressCustomer("Đà Nẵng");
        accountDto.setGenderCustomer(false);
        accountDto.setNationalityCustomer("Viêt Nam");
        accountDto.setIdCardCustomer("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/account/signup")
                        .content(this.objectMapper.writeValueAsString(accountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Created by: NhanDT
     * Date created: 11/08/2023
     *
     * Check case empty nationality
     * @throws Exception
     */
    @Test
    public void signUp_nationality_14() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setEmailCustomer("nhan123@gmail.com");
        accountDto.setPassword("12345678A");
        accountDto.setTelCustomer("0123456789");
        accountDto.setNameCustomer("Đỗ Thành Nhân");
        accountDto.setDateCustomer("02/02/2000");
        accountDto.setAddressCustomer("Đà Nẵng");
        accountDto.setGenderCustomer(false);
        accountDto.setNationalityCustomer("");
        accountDto.setIdCardCustomer("123456789");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/account/signup")
                        .content(this.objectMapper.writeValueAsString(accountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: NhanDT
     * Date created: 11/08/2023
     *
     * Check case all item success
     * @throws Exception
     */
    @Test
    public void signUp_all_item_18() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setEmailCustomer("nhan36@gmail.com");
        accountDto.setPassword("123456A78");
        accountDto.setTelCustomer("0123456789");
        accountDto.setNameCustomer("Đỗ Thành Nhân");
        accountDto.setDateCustomer("02/02/2000");
        accountDto.setAddressCustomer("Đà Nẵng");
        accountDto.setGenderCustomer(false);
        accountDto.setNationalityCustomer("Việt Nam");
        accountDto.setIdCardCustomer("120123456789");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/account/signup")
                        .content(this.objectMapper.writeValueAsString(accountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


    /**
     * Created by: NhanDT
     * Date created: 11/08/2023
     *
     * Check case format name (not capitalize the first letter)
     * @throws Exception
     */
    @Test
    public void signUp_name_not_capitalize_15() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setEmailCustomer("nhan7@gmail.com");
        accountDto.setPassword("1234567A8");
        accountDto.setTelCustomer("0123456789");
        accountDto.setNameCustomer("do thanh nhan");
        accountDto.setDateCustomer("02/02/2000");
        accountDto.setAddressCustomer("Đà Nẵng");
        accountDto.setGenderCustomer(false);
        accountDto.setNationalityCustomer("Việt Nam");
        accountDto.setIdCardCustomer("120123456789");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/account/signup")
                        .content(this.objectMapper.writeValueAsString(accountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: NhanDT
     * Date created: 11/08/2023
     *
     * Check case format name (no spaces between words)
     * @throws Exception
     */
    @Test
    public void signUp_name_no_space_15() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setEmailCustomer("nhan7@gmail.com");
        accountDto.setPassword("12345678A");
        accountDto.setTelCustomer("0123456789");
        accountDto.setNameCustomer("DoThanhNhan");
        accountDto.setDateCustomer("02/02/2000");
        accountDto.setAddressCustomer("Đà Nẵng");
        accountDto.setGenderCustomer(false);
        accountDto.setNationalityCustomer("Việt Nam");
        accountDto.setIdCardCustomer("120123456789");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/account/signup")
                        .content(this.objectMapper.writeValueAsString(accountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Created by: NhanDT
     * Date created: 11/08/2023
     *
     * Check case format name (have special characters)
     * @throws Exception
     */
    @Test
    public void signUp_name_have_special_15() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setEmailCustomer("nhan7@gmail.com");
        accountDto.setPassword("12345678A");
        accountDto.setTelCustomer("0123456789");
        accountDto.setNameCustomer("Do Thanh Nhan $");
        accountDto.setDateCustomer("02/02/2000");
        accountDto.setAddressCustomer("Đà Nẵng");
        accountDto.setGenderCustomer(false);
        accountDto.setNationalityCustomer("Việt Nam");
        accountDto.setIdCardCustomer("120123456789");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/account/signup")
                        .content(this.objectMapper.writeValueAsString(accountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }





    /**
     * Created by: NhanDT
     * Date created: 11/08/2023
     *
     * Check case format email
     * @throws Exception
     */
    @Test
    public void signUp_email_15() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setEmailCustomer("nhan7mail.com");
        accountDto.setPassword("12345678A");
        accountDto.setTelCustomer("0123456789");
        accountDto.setNameCustomer("Đỗ Thành Nhân");
        accountDto.setDateCustomer("02/02/2000");
        accountDto.setAddressCustomer("Đà Nẵng");
        accountDto.setGenderCustomer(false);
        accountDto.setNationalityCustomer("Việt Nam");
        accountDto.setIdCardCustomer("120123456789");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/account/signup")
                        .content(this.objectMapper.writeValueAsString(accountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: NhanDT
     * Date created: 11/08/2023
     *
     * Check case format phoneNumber (only number character)
     * @throws Exception
     */
    @Test
    public void signUp_phoneNumber_only_number_15() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setEmailCustomer("nhan7@gmail.com");
        accountDto.setPassword("12345678A");
        accountDto.setTelCustomer("023456789a");
        accountDto.setNameCustomer("Phan An Khang");
        accountDto.setDateCustomer("02/02/2000");
        accountDto.setAddressCustomer("Đà Nẵng");
        accountDto.setGenderCustomer(false);
        accountDto.setNationalityCustomer("Việt Nam");
        accountDto.setIdCardCustomer("120123456789");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/account/signup")
                        .content(this.objectMapper.writeValueAsString(accountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: NhanDT
     * Date created: 11/08/2023
     *
     * Check case format phoneNumber (not format 0123456789)
     * @throws Exception
     */
    @Test
    public void signUp_phoneNumber_0123456789_15() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setEmailCustomer("nhan7@gmail.com");
        accountDto.setPassword("12345678A");
        accountDto.setTelCustomer("1234567890");
        accountDto.setNameCustomer("Phan An Khang");
        accountDto.setDateCustomer("02/02/2000");
        accountDto.setAddressCustomer("Đà Nẵng");
        accountDto.setGenderCustomer(false);
        accountDto.setNationalityCustomer("Việt Nam");
        accountDto.setIdCardCustomer("120123456789");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/account/signup")
                        .content(this.objectMapper.writeValueAsString(accountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: NhanDT
     * Date created: 11/08/2023
     *
     * Check case format phoneNumber (not format +84123456789)
     * @throws Exception
     */
    @Test
    public void signUp_phoneNumber_84123456789_15() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setEmailCustomer("nhan7@gmail.com");
        accountDto.setPassword("12345678A");
        accountDto.setTelCustomer("1234567890");
        accountDto.setNameCustomer("Phan An Khang");
        accountDto.setDateCustomer("02/02/2000");
        accountDto.setAddressCustomer("Đà Nẵng");
        accountDto.setGenderCustomer(false);
        accountDto.setNationalityCustomer("Việt Nam");
        accountDto.setIdCardCustomer("120123456789");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/account/signup")
                        .content(this.objectMapper.writeValueAsString(accountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: NhanDT
     * Date created: 11/08/2023
     *
     * Check case format idCard
     * @throws Exception
     */
    @Test
    public void signUp_idCard_15() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setEmailCustomer("nhan7@gmail.com");
        accountDto.setPassword("12345678A");
        accountDto.setTelCustomer("0123456789");
        accountDto.setNameCustomer("Phan Khang");
        accountDto.setDateCustomer("02/02/2000");
        accountDto.setAddressCustomer("Đà Nẵng");
        accountDto.setGenderCustomer(false);
        accountDto.setNationalityCustomer("Việt Nam");
        accountDto.setIdCardCustomer("123456789");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/account/signup")
                        .content(this.objectMapper.writeValueAsString(accountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: NhanDT
     * Date created: 11/08/2023
     *
     * Check case name < minlength 10
     * @throws Exception
     */
    @Test
    public void signUp_name_16() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setEmailCustomer("nhan7@gmail.com");
        accountDto.setPassword("12345678A");
        accountDto.setTelCustomer("0123456789");
        accountDto.setNameCustomer("Nhan");
        accountDto.setDateCustomer("02/02/2000");
        accountDto.setAddressCustomer("Đà Nẵng");
        accountDto.setGenderCustomer(false);
        accountDto.setNationalityCustomer("Việt Nam");
        accountDto.setIdCardCustomer("120123456789");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/account/signup")
                        .content(this.objectMapper.writeValueAsString(accountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: NhanDT
     * Date created: 11/08/2023
     *
     * Check case name > maxlength 50
     * @throws Exception
     */
    @Test
    public void signUp_name_17() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setEmailCustomer("nhan7@gmail.com");
        accountDto.setPassword("12345678A");
        accountDto.setTelCustomer("0123456789");
        accountDto.setNameCustomer("Nhan Nhan Nhan Nhan Nhan Nhan Nhan Nhan Nhan Nhan Nhan Nhan");
        accountDto.setDateCustomer("02/02/2000");
        accountDto.setAddressCustomer("Đà Nẵng");
        accountDto.setGenderCustomer(false);
        accountDto.setNationalityCustomer("Việt Nam");
        accountDto.setIdCardCustomer("120123456789");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/account/signup")
                        .content(this.objectMapper.writeValueAsString(accountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: NhanDT
     * Date created: 11/08/2023
     *
     * Check case email < minlength 12
     * @throws Exception
     */
    @Test
    public void signUp_email_16() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setEmailCustomer("n7@l.com");
        accountDto.setPassword("12345678A");
        accountDto.setTelCustomer("0123456789");
        accountDto.setNameCustomer("Nhan");
        accountDto.setDateCustomer("02/02/2000");
        accountDto.setAddressCustomer("Đà Nẵng");
        accountDto.setGenderCustomer(false);
        accountDto.setNationalityCustomer("Việt Nam");
        accountDto.setIdCardCustomer("120123456789");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/account/signup")
                        .content(this.objectMapper.writeValueAsString(accountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: NhanDT
     * Date created: 11/08/2023
     *
     * Check case email > maxlength 50
     * @throws Exception
     */
    @Test
    public void signUp_email_17() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setEmailCustomer("nhannhannhan7@gmail.com");
        accountDto.setPassword("12345678A");
        accountDto.setTelCustomer("0123456789");
        accountDto.setNameCustomer("Nhan Nhan Nhan Nhan Nhan Nhan Nhan Nhan Nhan Nhan Nhan Nhan");
        accountDto.setDateCustomer("02/02/2000");
        accountDto.setAddressCustomer("Đà Nẵng");
        accountDto.setGenderCustomer(false);
        accountDto.setNationalityCustomer("Việt Nam");
        accountDto.setIdCardCustomer("120123456789");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/account/signup")
                        .content(this.objectMapper.writeValueAsString(accountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Created by: NhanDT
     * Date created: 11/08/2023
     *
     * Check case password < minlength 8
     * @throws Exception
     */
    @Test
    public void signUp_password_16() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setEmailCustomer("nhan7@gmail.com");
        accountDto.setPassword("1234567");
        accountDto.setTelCustomer("0123456789");
        accountDto.setNameCustomer("Nhan Do Thanh");
        accountDto.setDateCustomer("02/02/2000");
        accountDto.setAddressCustomer("Đà Nẵng");
        accountDto.setGenderCustomer(false);
        accountDto.setNationalityCustomer("Việt Nam");
        accountDto.setIdCardCustomer("120123456789");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/account/signup")
                        .content(this.objectMapper.writeValueAsString(accountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: NhanDT
     * Date created: 11/08/2023
     *
     * Check case password > maxlength 20
     * @throws Exception
     */
    @Test
    public void signUp_password_17() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setEmailCustomer("nhan7@gmail.com");
        accountDto.setPassword("123456781234567812345678");
        accountDto.setTelCustomer("0123456789");
        accountDto.setNameCustomer("Nhan Nhan Nhan");
        accountDto.setDateCustomer("02/02/2000");
        accountDto.setAddressCustomer("Đà Nẵng");
        accountDto.setGenderCustomer(false);
        accountDto.setNationalityCustomer("Việt Nam");
        accountDto.setIdCardCustomer("120123456789");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/account/signup")
                        .content(this.objectMapper.writeValueAsString(accountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: NhanDT
     * Date created: 11/08/2023
     *
     * Check case format dayOfBirth (age>18)
     * @throws Exception
     */
    @Test
    public void signUp_dayOfBirth_18_15() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setEmailCustomer("nhan101@gmail.com");
        accountDto.setPassword("12345678A");
        accountDto.setTelCustomer("0123456789");
        accountDto.setNameCustomer("Nhan Nhan Nhan");
        accountDto.setDateCustomer("02/02/2010");
        accountDto.setAddressCustomer("Đà Nẵng");
        accountDto.setGenderCustomer(false);
        accountDto.setNationalityCustomer("Việt Nam");
        accountDto.setIdCardCustomer("120123456789");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/account/signup")
                        .content(this.objectMapper.writeValueAsString(accountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


}
