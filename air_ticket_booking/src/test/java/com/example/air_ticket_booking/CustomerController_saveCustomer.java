package com.example.air_ticket_booking;

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
public class CustomerController_saveCustomer {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Create by: HungLV
     * Date create: 11/08/2023
     * Function: get object from front-end and check case field name is null
     *
     * @Param: not Param
     * @Return: void
     * @throws Exception
     */
    @Test
    public void saveCustomer_name_object_13() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer(null);
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("hungle@123.com");
        customerDto.setTelCustomer("0909000999");
        customerDto.setAddressCustomer("Đà Nẵng");
        customerDto.setImgCustomer("1");
        customerDto.setNationalityCustomer("Mỹ");
        customerDto.setIdCardCustomer("123456789879");
        customerDto.setDateCustomer("02-03-2000");
        customerDto.setFlagCustomer(false);

        Account account = new Account();
        account.setIdAccount(1L);

        customerDto.setAccount(account);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customers")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: HungLV
     * Date create: 11/08/2023
     * Function: get object from front-end and check case field name is empty
     *
     * @Param: not Param
     * @Return: void
     * @throws Exception
     */
    @Test
    public void saveCustomer_name_object_14() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer(" ");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("hungle@123.com");
        customerDto.setTelCustomer("0909000999");
        customerDto.setAddressCustomer("Đà Nẵng");
        customerDto.setImgCustomer("1");
        customerDto.setNationalityCustomer("Mỹ");
        customerDto.setIdCardCustomer("123456789879");
        customerDto.setDateCustomer("02-03-2000");
        customerDto.setFlagCustomer(false);

        Account account = new Account();
        account.setIdAccount(1L);

        customerDto.setAccount(account);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customers")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: HungLV
     * Date create: 11/08/2023
     * Function: get object from front-end and check case field name is not formatted
     *
     * @Param: not Param
     * @Return: void
     * @throws Exception
     */
    @Test
    public void saveCustomer_name_object_15() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Lê 123");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("hungle@123.com");
        customerDto.setTelCustomer("0909000999");
        customerDto.setAddressCustomer("Đà Nẵng");
        customerDto.setImgCustomer("1");
        customerDto.setNationalityCustomer("Mỹ");
        customerDto.setIdCardCustomer("123456789879");
        customerDto.setDateCustomer("02-03-2000");
        customerDto.setFlagCustomer(false);

        Account account = new Account();
        account.setIdAccount(1L);

        customerDto.setAccount(account);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customers")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: HungLV
     * Date create: 11/08/2023
     * Function: get object from front-end and check case field name has character less than min
     *
     * @Param: not Param
     * @Return: void
     * @throws Exception
     */
    @Test
    public void saveCustomer_name_object_16() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Lê");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("hungle@123.com");
        customerDto.setTelCustomer("0909000999");
        customerDto.setAddressCustomer("Đà Nẵng");
        customerDto.setImgCustomer("1");
        customerDto.setNationalityCustomer("Mỹ");
        customerDto.setIdCardCustomer("123456789879");
        customerDto.setDateCustomer("02-03-2000");
        customerDto.setFlagCustomer(false);

        Account account = new Account();
        account.setIdAccount(1L);

        customerDto.setAccount(account);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customers")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HungLV
     * Date create: 11/08/2023
     * Function: get object from front-end and check case field name has character greater than max
     *
     * @Param: not Param
     * @Return: void
     * @throws Exception
     */

    @Test
    public void saveCustomer_name_object_17() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Lê Văn Hưng Lê Văn Hưng Lê Văn Hưng Lê Văn Hưng Lê Văn Hưng Lê Văn Hưng Lê Văn Hưng\" +\n" +
                "                \" Lê Văn Hưng Lê Văn Hưng Lê Văn Hưng");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("hungle@123.com");
        customerDto.setTelCustomer("0909000999");
        customerDto.setAddressCustomer("Đà Nẵng");
        customerDto.setImgCustomer("1");
        customerDto.setNationalityCustomer("Mỹ");
        customerDto.setIdCardCustomer("123456789879");
        customerDto.setDateCustomer("02-03-2000");
        customerDto.setFlagCustomer(false);

        Account account = new Account();
        account.setIdAccount(1L);

        customerDto.setAccount(account);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customers")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: HungLV
     * Date create: 11/08/2023
     * Function: get object from front-end and check case field name is right format
     *
     * @Param: not Param
     * @Return: void
     * @throws Exception
     */
    @Test
    public void saveCustomer_name_object_18() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Lê Văn Hưng");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("hungle@123.com");
        customerDto.setTelCustomer("0909000999");
        customerDto.setAddressCustomer("Đà Nẵng");
        customerDto.setImgCustomer("1");
        customerDto.setNationalityCustomer("Mỹ");
        customerDto.setIdCardCustomer("123456789879");
        customerDto.setDateCustomer("02-03-2000");
        customerDto.setFlagCustomer(false);

        Account account = new Account();
        account.setIdAccount(1L);

        customerDto.setAccount(account);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customers")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void saveCustomer_email_object_13() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Lê Văn Hưng");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer(null);
        customerDto.setTelCustomer("0909000999");
        customerDto.setAddressCustomer("Đà Nẵng");
        customerDto.setImgCustomer("1");
        customerDto.setNationalityCustomer("Mỹ");
        customerDto.setIdCardCustomer("123456789879");
        customerDto.setDateCustomer("02-03-2000");
        customerDto.setFlagCustomer(false);

        Account account = new Account();
        account.setIdAccount(1L);

        customerDto.setAccount(account);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customers")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void saveCustomer_email_object_14() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Lê Văn Hưng");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer(" ");
        customerDto.setTelCustomer("0909000999");
        customerDto.setAddressCustomer("Đà Nẵng");
        customerDto.setImgCustomer("1");
        customerDto.setNationalityCustomer("Mỹ");
        customerDto.setIdCardCustomer("123456789879");
        customerDto.setDateCustomer("02-03-2000");
        customerDto.setFlagCustomer(false);

        Account account = new Account();
        account.setIdAccount(1L);

        customerDto.setAccount(account);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customers")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void saveCustomer_email_object_15() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Lê Văn Hưng");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("hung123+-*/");
        customerDto.setTelCustomer("0909000999");
        customerDto.setAddressCustomer("Đà Nẵng");
        customerDto.setImgCustomer("1");
        customerDto.setNationalityCustomer("Mỹ");
        customerDto.setIdCardCustomer("123456789879");
        customerDto.setDateCustomer("02-03-2000");
        customerDto.setFlagCustomer(false);

        Account account = new Account();
        account.setIdAccount(1L);

        customerDto.setAccount(account);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customers")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void saveCustomer_email_object_16() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Lê Văn Hưng");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("hu");
        customerDto.setTelCustomer("0909000999");
        customerDto.setAddressCustomer("Đà Nẵng");
        customerDto.setImgCustomer("1");
        customerDto.setNationalityCustomer("Mỹ");
        customerDto.setIdCardCustomer("123456789879");
        customerDto.setDateCustomer("02-03-2000");
        customerDto.setFlagCustomer(false);

        Account account = new Account();
        account.setIdAccount(1L);

        customerDto.setAccount(account);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customers")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void saveCustomer_email_object_17() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Lê Văn Hưng");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("hunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghungh" +
                "unghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghung" +
                "hunghunghunghunghunghunghunghunghunghunghunghunghunghungunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghung" +
                "unghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghung" +
                "unghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghung" +
                "unghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghung" +
                "unghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghung" +
                "unghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghung@123");
        customerDto.setTelCustomer("0909000999");
        customerDto.setAddressCustomer("Đà Nẵng");
        customerDto.setImgCustomer("1");
        customerDto.setNationalityCustomer("Mỹ");
        customerDto.setIdCardCustomer("123456789879");
        customerDto.setDateCustomer("02-03-2000");
        customerDto.setFlagCustomer(false);

        Account account = new Account();
        account.setIdAccount(1L);

        customerDto.setAccount(account);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customers")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void saveCustomer_email_object_18() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Lê Văn Hưng");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("hungle@123.com");
        customerDto.setTelCustomer("0909000999");
        customerDto.setAddressCustomer("Đà Nẵng");
        customerDto.setImgCustomer("1");
        customerDto.setNationalityCustomer("Mỹ");
        customerDto.setIdCardCustomer("123456789879");
        customerDto.setDateCustomer("02-03-2000");
        customerDto.setFlagCustomer(false);

        Account account = new Account();
        account.setIdAccount(1L);

        customerDto.setAccount(account);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customers")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void saveCustomer_tel_object_13() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Lê Văn Hưng");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("hungle@123.com");
        customerDto.setTelCustomer(null);
        customerDto.setAddressCustomer("Đà Nẵng");
        customerDto.setImgCustomer("1");
        customerDto.setNationalityCustomer("Mỹ");
        customerDto.setIdCardCustomer("123456789879");
        customerDto.setDateCustomer("02-03-2000");
        customerDto.setFlagCustomer(false);

        Account account = new Account();
        account.setIdAccount(1L);

        customerDto.setAccount(account);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customers")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void saveCustomer_tel_object_14() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Lê Văn Hưng");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("hungle@123.com");
        customerDto.setTelCustomer(" ");
        customerDto.setAddressCustomer("Đà Nẵng");
        customerDto.setImgCustomer("1");
        customerDto.setNationalityCustomer("Mỹ");
        customerDto.setIdCardCustomer("123456789879");
        customerDto.setDateCustomer("02-03-2000");
        customerDto.setFlagCustomer(false);

        Account account = new Account();
        account.setIdAccount(1L);

        customerDto.setAccount(account);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customers")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void saveCustomer_tel_object_15() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Lê Văn Hưng");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("hungle@123.com");
        customerDto.setTelCustomer("abcabcabc");
        customerDto.setAddressCustomer("Đà Nẵng");
        customerDto.setImgCustomer("1");
        customerDto.setNationalityCustomer("Mỹ");
        customerDto.setIdCardCustomer("123456789879");
        customerDto.setDateCustomer("02-03-2000");
        customerDto.setFlagCustomer(false);

        Account account = new Account();
        account.setIdAccount(1L);

        customerDto.setAccount(account);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customers")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void saveCustomer_tel_object_16() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Lê Văn Hưng");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("hungle@123.com");
        customerDto.setTelCustomer("09");
        customerDto.setAddressCustomer("Đà Nẵng");
        customerDto.setImgCustomer("1");
        customerDto.setNationalityCustomer("Mỹ");
        customerDto.setIdCardCustomer("123456789879");
        customerDto.setDateCustomer("02-03-2000");
        customerDto.setFlagCustomer(false);

        Account account = new Account();
        account.setIdAccount(1L);

        customerDto.setAccount(account);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customers")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void saveCustomer_tel_object_17() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Lê Văn Hưng");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("hungle@123.com");
        customerDto.setTelCustomer("09909099090990909909099090990909909");
        customerDto.setAddressCustomer("Đà Nẵng");
        customerDto.setImgCustomer("1");
        customerDto.setNationalityCustomer("Mỹ");
        customerDto.setIdCardCustomer("123456789879");
        customerDto.setDateCustomer("02-03-2000");
        customerDto.setFlagCustomer(false);

        Account account = new Account();
        account.setIdAccount(1L);

        customerDto.setAccount(account);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customers")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void saveCustomer_tel_object_18() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Lê Văn Hưng");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("hungle@123.com");
        customerDto.setTelCustomer("0909000999");
        customerDto.setAddressCustomer("Đà Nẵng");
        customerDto.setImgCustomer("1");
        customerDto.setNationalityCustomer("Mỹ");
        customerDto.setIdCardCustomer("123456789879");
        customerDto.setDateCustomer("02-03-2000");
        customerDto.setFlagCustomer(false);

        Account account = new Account();
        account.setIdAccount(1L);

        customerDto.setAccount(account);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customers")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void saveCustomer_address_object_13() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Lê Văn Hưng");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("hungle@123.com");
        customerDto.setTelCustomer("0909000999");
        customerDto.setAddressCustomer(null);
        customerDto.setImgCustomer("1");
        customerDto.setNationalityCustomer("Mỹ");
        customerDto.setIdCardCustomer("123456789879");
        customerDto.setDateCustomer("02-03-2000");
        customerDto.setFlagCustomer(false);

        Account account = new Account();
        account.setIdAccount(1L);

        customerDto.setAccount(account);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customers")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void saveCustomer_address_object_14() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Lê Văn Hưng");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("hungle@123.com");
        customerDto.setTelCustomer("0909000999");
        customerDto.setAddressCustomer(" ");
        customerDto.setImgCustomer("1");
        customerDto.setNationalityCustomer("Mỹ");
        customerDto.setIdCardCustomer("123456789879");
        customerDto.setDateCustomer("02-03-2000");
        customerDto.setFlagCustomer(false);

        Account account = new Account();
        account.setIdAccount(1L);

        customerDto.setAccount(account);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customers")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void saveCustomer_address_object_16() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Lê Văn Hưng");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("hungle@123.com");
        customerDto.setTelCustomer("0909000999");
        customerDto.setAddressCustomer("ab");
        customerDto.setImgCustomer("1");
        customerDto.setNationalityCustomer("Mỹ");
        customerDto.setIdCardCustomer("123456789879");
        customerDto.setDateCustomer("02-03-2000");
        customerDto.setFlagCustomer(false);

        Account account = new Account();
        account.setIdAccount(1L);

        customerDto.setAccount(account);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customers")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void saveCustomer_address_object_17() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Lê Văn Hưng");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("hungle@123.com");
        customerDto.setTelCustomer("0909000999");
        customerDto.setAddressCustomer("hunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghungh\" +\n" +
                "                \"unghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghung\" +\n" +
                "                \"hunghunghunghunghunghunghunghunghunghunghunghunghunghungunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghung\" +\n" +
                "                \"unghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghung\" +\n" +
                "                \"unghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghung\" +\n" +
                "                \"unghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghung\" +\n" +
                "                \"unghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghung\" +\n" +
                "                \"unghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghunghu");
        customerDto.setImgCustomer("1");
        customerDto.setNationalityCustomer("Mỹ");
        customerDto.setIdCardCustomer("123456789879");
        customerDto.setDateCustomer("02-03-2000");
        customerDto.setFlagCustomer(false);

        Account account = new Account();
        account.setIdAccount(1L);

        customerDto.setAccount(account);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customers")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void saveCustomer_address_object_18() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Lê Văn Hưng");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("hungle@123.com");
        customerDto.setTelCustomer("0909000999");
        customerDto.setAddressCustomer("Đà Nẵng");
        customerDto.setImgCustomer("1");
        customerDto.setNationalityCustomer("Mỹ");
        customerDto.setIdCardCustomer("123456789879");
        customerDto.setDateCustomer("02-03-2000");
        customerDto.setFlagCustomer(false);

        Account account = new Account();
        account.setIdAccount(1L);

        customerDto.setAccount(account);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customers")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void saveCustomer_img_object_13() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Lê Văn Hưng");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("hungle@123.com");
        customerDto.setTelCustomer("0909000999");
        customerDto.setAddressCustomer("Đà Nẵng");
        customerDto.setImgCustomer(null);
        customerDto.setNationalityCustomer("Mỹ");
        customerDto.setIdCardCustomer("123456789879");
        customerDto.setDateCustomer("02-03-2000");
        customerDto.setFlagCustomer(false);

        Account account = new Account();
        account.setIdAccount(1L);

        customerDto.setAccount(account);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customers")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void saveCustomer_img_object_14() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Lê Văn Hưng");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("hungle@123.com");
        customerDto.setTelCustomer("0909000999");
        customerDto.setAddressCustomer("Đà Nẵng");
        customerDto.setImgCustomer(" ");
        customerDto.setNationalityCustomer("Mỹ");
        customerDto.setIdCardCustomer("123456789879");
        customerDto.setDateCustomer("02-03-2000");
        customerDto.setFlagCustomer(false);

        Account account = new Account();
        account.setIdAccount(1L);

        customerDto.setAccount(account);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customers")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void saveCustomer_img_object_18() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Lê Văn Hưng");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("hungle@123.com");
        customerDto.setTelCustomer("0909000999");
        customerDto.setAddressCustomer("Đà Nẵng");
        customerDto.setImgCustomer("1");
        customerDto.setNationalityCustomer("Mỹ");
        customerDto.setIdCardCustomer("123456789879");
        customerDto.setDateCustomer("02-03-2000");
        customerDto.setFlagCustomer(false);

        Account account = new Account();
        account.setIdAccount(1L);

        customerDto.setAccount(account);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customers")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void saveCustomer_nationality_object_13() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Lê Văn Hưng");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("hungle@123.com");
        customerDto.setTelCustomer("0909000999");
        customerDto.setAddressCustomer("Đà Nẵng");
        customerDto.setImgCustomer("abc");
        customerDto.setNationalityCustomer(null);
        customerDto.setIdCardCustomer("123456789879");
        customerDto.setDateCustomer("02-03-2000");
        customerDto.setFlagCustomer(false);

        Account account = new Account();
        account.setIdAccount(1L);

        customerDto.setAccount(account);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customers")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void saveCustomer_nationality_object_14() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Lê Văn Hưng");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("hungle@123.com");
        customerDto.setTelCustomer("0909000999");
        customerDto.setAddressCustomer("Đà Nẵng");
        customerDto.setImgCustomer("abc");
        customerDto.setNationalityCustomer(" ");
        customerDto.setIdCardCustomer("123456789879");
        customerDto.setDateCustomer("02-03-2000");
        customerDto.setFlagCustomer(false);

        Account account = new Account();
        account.setIdAccount(1L);

        customerDto.setAccount(account);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customers")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void saveCustomer_nationality_object_18() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Lê Văn Hưng");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("hungle@123.com");
        customerDto.setTelCustomer("0909000999");
        customerDto.setAddressCustomer("Đà Nẵng");
        customerDto.setImgCustomer("1");
        customerDto.setNationalityCustomer("Mỹ");
        customerDto.setIdCardCustomer("123456789879");
        customerDto.setDateCustomer("02-03-2000");
        customerDto.setFlagCustomer(false);

        Account account = new Account();
        account.setIdAccount(1L);

        customerDto.setAccount(account);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customers")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void saveCustomer_id_card_object_13() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Lê Văn Hưng");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("hungle@123.com");
        customerDto.setTelCustomer("0909000999");
        customerDto.setAddressCustomer("Đà Nẵng");
        customerDto.setImgCustomer("abc");
        customerDto.setNationalityCustomer("Mỹ");
        customerDto.setIdCardCustomer(null);
        customerDto.setDateCustomer("02-03-2000");
        customerDto.setFlagCustomer(false);

        Account account = new Account();
        account.setIdAccount(1L);

        customerDto.setAccount(account);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customers")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void saveCustomer_id_card_object_14() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Lê Văn Hưng");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("hungle@123.com");
        customerDto.setTelCustomer("0909000999");
        customerDto.setAddressCustomer("Đà Nẵng");
        customerDto.setImgCustomer("abc");
        customerDto.setNationalityCustomer("Mỹ");
        customerDto.setIdCardCustomer(" ");
        customerDto.setDateCustomer("02-03-2000");
        customerDto.setFlagCustomer(false);

        Account account = new Account();
        account.setIdAccount(1L);

        customerDto.setAccount(account);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customers")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void saveCustomer_id_card_object_15() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Lê Văn Hưng");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("hungle@123.com");
        customerDto.setTelCustomer("0909000999");
        customerDto.setAddressCustomer("Đà Nẵng");
        customerDto.setImgCustomer("abc");
        customerDto.setNationalityCustomer("Mỹ");
        customerDto.setIdCardCustomer("abcabc");
        customerDto.setDateCustomer("02-03-2000");
        customerDto.setFlagCustomer(false);

        Account account = new Account();
        account.setIdAccount(1L);

        customerDto.setAccount(account);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customers")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void saveCustomer_id_card_object_16() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Lê Văn Hưng");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("hungle@123.com");
        customerDto.setTelCustomer("0909000999");
        customerDto.setAddressCustomer("Đà Nẵng");
        customerDto.setImgCustomer("abc");
        customerDto.setNationalityCustomer("Mỹ");
        customerDto.setIdCardCustomer("AB");
        customerDto.setDateCustomer("02-03-2000");
        customerDto.setFlagCustomer(false);

        Account account = new Account();
        account.setIdAccount(1L);

        customerDto.setAccount(account);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customers")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void saveCustomer_id_card_object_17() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Lê Văn Hưng");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("hungle@123.com");
        customerDto.setTelCustomer("0909000999");
        customerDto.setAddressCustomer("Đà Nẵng");
        customerDto.setImgCustomer("abc");
        customerDto.setNationalityCustomer("Mỹ");
        customerDto.setIdCardCustomer("AB0000000000000");
        customerDto.setDateCustomer("02-03-2000");
        customerDto.setFlagCustomer(false);

        Account account = new Account();
        account.setIdAccount(1L);

        customerDto.setAccount(account);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customers")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void saveCustomer_id_card_object_18() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Lê Văn Hưng");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("hungle@123.com");
        customerDto.setTelCustomer("0909000999");
        customerDto.setAddressCustomer("Đà Nẵng");
        customerDto.setImgCustomer("123");
        customerDto.setNationalityCustomer("Mỹ");
        customerDto.setIdCardCustomer("123456789879");
        customerDto.setDateCustomer("02-03-2000");
        customerDto.setFlagCustomer(false);

        Account account = new Account();
        account.setIdAccount(1L);

        customerDto.setAccount(account);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customers")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void saveCustomer_date_object_13() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Lê Văn Hưng");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("hungle@123.com");
        customerDto.setTelCustomer("0909000999");
        customerDto.setAddressCustomer("Đà Nẵng");
        customerDto.setImgCustomer("abc");
        customerDto.setNationalityCustomer("Mỹ");
        customerDto.setIdCardCustomer("123456789879");
        customerDto.setDateCustomer(null);
        customerDto.setFlagCustomer(false);

        Account account = new Account();
        account.setIdAccount(1L);

        customerDto.setAccount(account);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customers")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void saveCustomer_date_object_14() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Lê Văn Hưng");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("hungle@123.com");
        customerDto.setTelCustomer("0909000999");
        customerDto.setAddressCustomer("Đà Nẵng");
        customerDto.setImgCustomer("abc");
        customerDto.setNationalityCustomer("Mỹ");
        customerDto.setIdCardCustomer("123456789879");
        customerDto.setDateCustomer(" ");
        customerDto.setFlagCustomer(false);

        Account account = new Account();
        account.setIdAccount(1L);

        customerDto.setAccount(account);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customers")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void saveCustomer_date_object_18() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Lê Văn Hưng");
        customerDto.setGenderCustomer(true);
        customerDto.setEmailCustomer("hungle@123.com");
        customerDto.setTelCustomer("0909000999");
        customerDto.setAddressCustomer("Đà Nẵng");
        customerDto.setImgCustomer("123");
        customerDto.setNationalityCustomer("Mỹ");
        customerDto.setIdCardCustomer("123456789879");
        customerDto.setDateCustomer("02-03-2000");
        customerDto.setFlagCustomer(false);

        Account account = new Account();
        account.setIdAccount(1L);

        customerDto.setAccount(account);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/customers")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
