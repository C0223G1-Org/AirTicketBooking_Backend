package com.example.air_ticket_booking.controller;

import com.example.air_ticket_booking.dto.employee.EmployeeDto;
import com.example.air_ticket_booking.model.account.Account;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.web.servlet.function.ServerResponse.status;
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeRestController_createEmployee {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * create employee [name] = null
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_name_13() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setDateEmployee("2002-10-11");
        employeeDto.setTelEmployee("0912548789");
        employeeDto.setEmailEmployee("abc@gmail.com");
        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1));
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * create employee [DateEmployee] = null
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_dateEmployee_13() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setNameEmployee("Nguyễn Văn A");
        employeeDto.setTelEmployee("0912548789");
        employeeDto.setEmailEmployee("abc@gmail.com");
        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1));
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * create employee [telEmployee] = null
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_telEmployee_13() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setNameEmployee("Nguyễn Văn A");
        employeeDto.setDateEmployee("2002-10-11");
        employeeDto.setEmailEmployee("abc@gmail.com");
        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1));
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }
    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * create employee [email] = null
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_email_13() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setNameEmployee("Nguyễn Văn A");
        employeeDto.setDateEmployee("2002-10-11");
        employeeDto.setTelEmployee("0912548789");
        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1));
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }
    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * create employee [image] = null
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_image_13() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setNameEmployee("Nguyễn Văn A");
        employeeDto.setDateEmployee("2002-10-11");
        employeeDto.setTelEmployee("0912548789");
        employeeDto.setEmailEmployee("abc@gmail.com");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1));
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * create employee [gender] = null
     *
     * @throws Exception
     */
//    @Test
//    public void createEmployee_gender_13() throws Exception {
//        EmployeeDto employeeDto = new EmployeeDto();
//        Account account = new Account();
//        employeeDto.setNameEmployee("Nguyễn Văn A");
//        employeeDto.setDateEmployee("2002-10-11");
//        employeeDto.setTelEmployee("0912548789");
//        employeeDto.setEmailEmployee("abc@gmail.com");
//
//        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
//        account.setIdAccount(Long.valueOf(1));
//        employeeDto.setAccount(account);
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .post("/api/employee")
//                        .content(this.objectMapper.writeValueAsString(employeeDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
//    }

    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * create employee [account] = null
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_account_13() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setNameEmployee("Nguyễn Văn A");
        employeeDto.setDateEmployee("2002-10-11");
        employeeDto.setTelEmployee("0912548789");
        employeeDto.setEmailEmployee("abc@gmail.com");
        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1));
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * create employee [name] = ""
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_name_14() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setNameEmployee("");
        employeeDto.setDateEmployee("2002-10-11");
        employeeDto.setTelEmployee("0912548789");
        employeeDto.setEmailEmployee("abc@gmail.com");
        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1));
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * create employee [dateEmployee] = ""
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_dateEmployee_14() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setNameEmployee("Nguyễn Văn A");
        employeeDto.setDateEmployee("");
        employeeDto.setTelEmployee("0912548789");
        employeeDto.setEmailEmployee("abc@gmail.com");
        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1));
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * create employee [telEmployee] = ""
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_telEmployee_14() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setNameEmployee("Nguyễn Văn A");
        employeeDto.setDateEmployee("2002-10-11");
        employeeDto.setTelEmployee("");
        employeeDto.setEmailEmployee("abc@gmail.com");
        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1));
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * create employee [email] = ""
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_email_14() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setNameEmployee("Nguyễn Văn A");
        employeeDto.setDateEmployee("2002-10-11");
        employeeDto.setTelEmployee("0912548789");
        employeeDto.setEmailEmployee("");
        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1));
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * create employee [image]=""
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_image_14() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setNameEmployee("anhquoc12");
        employeeDto.setDateEmployee("2002-10-11");
        employeeDto.setTelEmployee("0912548789");
        employeeDto.setEmailEmployee("abcd1@gmail.com");
        employeeDto.setImage("");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1L));
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * create employee [account]= 0
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_account_14() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setNameEmployee("anhquoc12");
        employeeDto.setDateEmployee("2002-10-11");
        employeeDto.setTelEmployee("0912548789");
        employeeDto.setEmailEmployee("abcd1@gmail.com");
        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
        employeeDto.setGender(true);
        account.setIdAccount(null);
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * create employee [name]= false format
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_name_15() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setNameEmployee("anh@cd");
        employeeDto.setDateEmployee("2002-10-11");
        employeeDto.setTelEmployee("0912548789");
        employeeDto.setEmailEmployee("abcd1@gmail.com");
        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1L));
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * create employee [date]= false format
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_date_15() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setNameEmployee("anhquoc");
        employeeDto.setDateEmployee("2002-10");
        employeeDto.setTelEmployee("0912548789");
        employeeDto.setEmailEmployee("abcd1@gmail.com");
        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1L));
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }
    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * create employee [tel]= false format
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_tel_15() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setNameEmployee("anhquoc");
        employeeDto.setDateEmployee("2002-10-11");
        employeeDto.setTelEmployee("091254aa89");
        employeeDto.setEmailEmployee("abcd1@gmail.com");
        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1L));
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }
    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * create employee [email]= false format
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_email_15() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setNameEmployee("anhquoc");
        employeeDto.setDateEmployee("2002-10-11");
        employeeDto.setTelEmployee("0912325489");
        employeeDto.setEmailEmployee("abcd1");
        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1L));
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * create employee [name]= minLength
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_name_16() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setNameEmployee("auoc");
        employeeDto.setDateEmployee("2002-10-11");
        employeeDto.setTelEmployee("0912325489");
        employeeDto.setEmailEmployee("abcd1@gmail.com");
        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1L));
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * create employee [date]= minLength
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_date_16() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setNameEmployee("anhquoc");
        employeeDto.setDateEmployee("2002-10");
        employeeDto.setTelEmployee("0912325489");
        employeeDto.setEmailEmployee("abcd1@gmail.com");
        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1L));
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * create employee [tel]= minLength
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_tel_16() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setNameEmployee("nhaquoc");
        employeeDto.setDateEmployee("2002-10-12");
        employeeDto.setTelEmployee("09125489");
        employeeDto.setEmailEmployee("abcd1@gmail.com");
        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1L));
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * create employee [email]= minLength
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_email_16() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setNameEmployee("auoca");
        employeeDto.setDateEmployee("2002-10-11");
        employeeDto.setTelEmployee("0912254829");
        employeeDto.setEmailEmployee("a@gmail.com");
        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1L));
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * create employee [name]= maxLength
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_name_17() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setNameEmployee("auocaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        employeeDto.setDateEmployee("2002-10-11");
        employeeDto.setTelEmployee("0912325489");
        employeeDto.setEmailEmployee("abcd1@gmail.com");
        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1L));
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * create employee [date]= maxLength
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_date_17() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setNameEmployee("anhquoc");
        employeeDto.setDateEmployee("2002-10-111");
        employeeDto.setTelEmployee("0912325489");
        employeeDto.setEmailEmployee("abcd1@gmail.com");
        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1L));
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * create employee [tel]= maxLength
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_tel_17() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setNameEmployee("anhquoc");
        employeeDto.setDateEmployee("2002-10-11");
        employeeDto.setTelEmployee("0912325489123");
        employeeDto.setEmailEmployee("abcd1@gmail.com");
        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1L));
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * create employee [email]= maxLength
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_email_17() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setNameEmployee("anhquoc");
        employeeDto.setDateEmployee("2002-10-11");
        employeeDto.setTelEmployee("0912325411");
        employeeDto.setEmailEmployee("abcdaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa1@gmail.com");
        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1L));
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }


    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * create employee
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_18() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setNameEmployee("anhquoc");
        employeeDto.setDateEmployee("2002-10-11");
        employeeDto.setTelEmployee("0912548789");
        employeeDto.setEmailEmployee("abcd1@gmail.com");
        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1L));
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }


}
