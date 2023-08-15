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

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeRestController_editEmployee {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * edit employee [name] = null
     *
     * @throws Exception
     */
    @Test
    public void editEmployee_name_19() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setIdEmployee(1L);
        employeeDto.setDateEmployee("2002-10-11");
        employeeDto.setTelEmployee("0912548789");
        employeeDto.setEmailEmployee("abc@gmail.com");
        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1));
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * edit employee [DateEmployee] = null
     *
     * @throws Exception
     */
    @Test
    public void editEmployee_dateEmployee_19() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setIdEmployee(1L);
        employeeDto.setNameEmployee("Nguyễn Văn A");
        employeeDto.setTelEmployee("0912548789");
        employeeDto.setEmailEmployee("abc@gmail.com");
        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1));
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * edit employee [telEmployee] = null
     *
     * @throws Exception
     */
    @Test
    public void editEmployee_telEmployee_19() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setIdEmployee(1L);
        employeeDto.setNameEmployee("Nguyễn Văn A");
        employeeDto.setDateEmployee("2002-10-11");
        employeeDto.setEmailEmployee("abc@gmail.com");
        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1));
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }
    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * edit employee [email] = null
     *
     * @throws Exception
     */
    @Test
    public void editEmployee_email_19() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setIdEmployee(1L);
        employeeDto.setNameEmployee("Nguyễn Văn A");
        employeeDto.setDateEmployee("2002-10-11");
        employeeDto.setTelEmployee("0912548789");
        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1));
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }
    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * edit employee [image] = null
     *
     * @throws Exception
     */
    @Test
    public void editEmployee_image_19() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setIdEmployee(1L);
        employeeDto.setNameEmployee("Nguyễn Văn A");
        employeeDto.setDateEmployee("2002-10-11");
        employeeDto.setTelEmployee("0912548789");
        employeeDto.setEmailEmployee("abc@gmail.com");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1));
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * edit employee [gender] = null
     *
     * @throws Exception
     */
//    @Test
//    public void editEmployee_gender_13() throws Exception {
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
//                        .patch("/api/employee")
//                        .content(this.objectMapper.writeValueAsString(employeeDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
//    }

    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * edit employee [account] = null
     *
     * @throws Exception
     */
    @Test
    public void editEmployee_account_19() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setIdEmployee(1L);
        employeeDto.setNameEmployee("Nguyễn Văn A");
        employeeDto.setDateEmployee("2002-10-11");
        employeeDto.setTelEmployee("0912548789");
        employeeDto.setEmailEmployee("abc@gmail.com");
        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1));
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * edit employee [name] = ""
     *
     * @throws Exception
     */
    @Test
    public void editEmployee_name_20() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setIdEmployee(1L);
        employeeDto.setNameEmployee("");
        employeeDto.setDateEmployee("2002-10-11");
        employeeDto.setTelEmployee("0912548789");
        employeeDto.setEmailEmployee("abc@gmail.com");
        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1));
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * edit employee [dateEmployee] = ""
     *
     * @throws Exception
     */
    @Test
    public void editEmployee_dateEmployee_20() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setIdEmployee(1L);
        employeeDto.setNameEmployee("Nguyễn Văn A");
        employeeDto.setDateEmployee("");
        employeeDto.setTelEmployee("0912548789");
        employeeDto.setEmailEmployee("abc@gmail.com");
        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1));
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * edit employee [telEmployee] = ""
     *
     * @throws Exception
     */
    @Test
    public void editEmployee_telEmployee_20() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setIdEmployee(1L);
        employeeDto.setNameEmployee("Nguyễn Văn A");
        employeeDto.setDateEmployee("2002-10-11");
        employeeDto.setTelEmployee("");
        employeeDto.setEmailEmployee("abc@gmail.com");
        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1));
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * edit employee [email] = ""
     *
     * @throws Exception
     */
    @Test
    public void editEmployee_email_20() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setIdEmployee(1L);
        employeeDto.setNameEmployee("Nguyễn Văn A");
        employeeDto.setDateEmployee("2002-10-11");
        employeeDto.setTelEmployee("0912548789");
        employeeDto.setEmailEmployee("");
        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1));
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * edit employee [image]=""
     *
     * @throws Exception
     */
    @Test
    public void editEmployee_image_20() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setIdEmployee(1L);
        employeeDto.setNameEmployee("anhquoc12");
        employeeDto.setDateEmployee("2002-10-11");
        employeeDto.setTelEmployee("0912548789");
        employeeDto.setEmailEmployee("abcd1@gmail.com");
        employeeDto.setImage("");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1L));
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * edit employee [account]= 0
     *
     * @throws Exception
     */
    @Test
    public void editEmployee_account_20() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setIdEmployee(1L);
        employeeDto.setNameEmployee("anhquoc12");
        employeeDto.setDateEmployee("2002-10-11");
        employeeDto.setTelEmployee("0912548789");
        employeeDto.setEmailEmployee("abcd1@gmail.com");
        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
        employeeDto.setGender(true);
        account.setIdAccount(null);
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * edit employee [name]= false format
     *
     * @throws Exception
     */
    @Test
    public void editEmployee_name_21() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setIdEmployee(1L);
        employeeDto.setNameEmployee("anh@cd");
        employeeDto.setDateEmployee("2002-10-11");
        employeeDto.setTelEmployee("0912548789");
        employeeDto.setEmailEmployee("abcd1@gmail.com");
        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1L));
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * edit employee [date]= false format
     *
     * @throws Exception
     */
    @Test
    public void editEmployee_date_21() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setIdEmployee(1L);
        employeeDto.setNameEmployee("anhquoc");
        employeeDto.setDateEmployee("2002-10");
        employeeDto.setTelEmployee("0912548789");
        employeeDto.setEmailEmployee("abcd1@gmail.com");
        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1L));
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }
    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * edit employee [tel]= false format
     *
     * @throws Exception
     */
    @Test
    public void editEmployee_tel_21() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setIdEmployee(1L);
        employeeDto.setNameEmployee("anhquoc");
        employeeDto.setDateEmployee("2002-10-11");
        employeeDto.setTelEmployee("091254aa89");
        employeeDto.setEmailEmployee("abcd1@gmail.com");
        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1L));
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }
    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * edit employee [email]= false format
     *
     * @throws Exception
     */
    @Test
    public void editEmployee_email_21() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setIdEmployee(1L);
        employeeDto.setNameEmployee("anhquoc");
        employeeDto.setDateEmployee("2002-10-11");
        employeeDto.setTelEmployee("0912325489");
        employeeDto.setEmailEmployee("abcd1");
        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1L));
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * edit employee [name]= minLength
     *
     * @throws Exception
     */
    @Test
    public void editEmployee_name__21() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setIdEmployee(1L);
        employeeDto.setNameEmployee("auoc");
        employeeDto.setDateEmployee("2002-10-11");
        employeeDto.setTelEmployee("0912325489");
        employeeDto.setEmailEmployee("abcd1@gmail.com");
        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1L));
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * edit employee [date]= minLength
     *
     * @throws Exception
     */
    @Test
    public void editEmployee_date__21() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setIdEmployee(1L);
        employeeDto.setNameEmployee("anhquoc");
        employeeDto.setDateEmployee("2002-10");
        employeeDto.setTelEmployee("0912325489");
        employeeDto.setEmailEmployee("abcd1@gmail.com");
        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1L));
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * edit employee [tel]= minLength
     *
     * @throws Exception
     */
    @Test
    public void editEmployee_tel__21() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setIdEmployee(1L);
        employeeDto.setNameEmployee("nhaquoc");
        employeeDto.setDateEmployee("2002-10-12");
        employeeDto.setTelEmployee("09125489");
        employeeDto.setEmailEmployee("abcd1@gmail.com");
        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1L));
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * edit employee [email]= minLength
     *
     * @throws Exception
     */
    @Test
    public void editEmployee_email__21() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setIdEmployee(1L);
        employeeDto.setNameEmployee("auoca");
        employeeDto.setDateEmployee("2002-10-11");
        employeeDto.setTelEmployee("0912254829");
        employeeDto.setEmailEmployee("a@gmail.com");
        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1L));
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * edit employee [name]= maxLength
     *
     * @throws Exception
     */
    @Test
    public void editEmployee_name_22() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setIdEmployee(1L);
        employeeDto.setNameEmployee("auocaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        employeeDto.setDateEmployee("2002-10-11");
        employeeDto.setTelEmployee("0912325489");
        employeeDto.setEmailEmployee("abcd1@gmail.com");
        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1L));
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * edit employee [date]= maxLength
     *
     * @throws Exception
     */
    @Test
    public void editEmployee_date_22() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setIdEmployee(1L);
        employeeDto.setNameEmployee("anhquoc");
        employeeDto.setDateEmployee("2002-10-111");
        employeeDto.setTelEmployee("0912325489");
        employeeDto.setEmailEmployee("abcd1@gmail.com");
        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1L));
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * edit employee [tel]= maxLength
     *
     * @throws Exception
     */
    @Test
    public void editEmployee_tel_22() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setIdEmployee(1L);
        employeeDto.setNameEmployee("anhquoc");
        employeeDto.setDateEmployee("2002-10-11");
        employeeDto.setTelEmployee("0912325489123");
        employeeDto.setEmailEmployee("abcd1@gmail.com");
        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1L));
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * edit employee [email]= maxLength
     *
     * @throws Exception
     */
    @Test
    public void editEmployee_email_22() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setIdEmployee(1L);
        employeeDto.setNameEmployee("anhquoc");
        employeeDto.setDateEmployee("2002-10-11");
        employeeDto.setTelEmployee("0912325411");
        employeeDto.setEmailEmployee("abcdaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa1@gmail.com");
        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
        employeeDto.setGender(true);
        account.setIdAccount(Long.valueOf(1L));
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }


    /**
     * Create By : QuocNHA
     * Date Create : 11/08/2023
     * edit employee
     *
     * @throws Exception
     */
    @Test
    public void editEmployee_23() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Account account = new Account();
        employeeDto.setIdEmployee(1L);
        employeeDto.setNameEmployee("anhquoc");
        employeeDto.setDateEmployee("2002-10-11");
        employeeDto.setTelEmployee("0912548789");
        employeeDto.setEmailEmployee("abcdz1@gmail.com");
        employeeDto.setImage("https://cacanh24.com/wp-content/uploads/2023/05/Mau-anh-the-nam.jpg");
        employeeDto.setGender(false);
        account.setIdAccount(Long.valueOf(1L));
        employeeDto.setAccount(account);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }


}
