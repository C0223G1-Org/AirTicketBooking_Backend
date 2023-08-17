package com.example.air_ticket_booking.controller;

import com.example.air_ticket_booking.dto.post.PostDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerController_getListSearchCustomer {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Create by: TàiMP
     * Date create: 11/08/2023
     * Method: getListSearchCustomer_name_nationality_email_100 have 3 param and this param have data valid with database and return list customer
     * param: name,email,nationality
     * @throws Exception
     */
    @Test
    public void getListSearchCustomer_name_nationality_email_100() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/customers/search?name=T&&nationality=V&&email=s&&page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("content[0].addressCustomer").value("Đà Nẵng"))
                .andExpect(jsonPath("content[0].dateCustomer").value("11/11/1995"))
                .andExpect(jsonPath("content[0].emailCustomer").value("sieuem2002@gmail.com"))
                .andExpect(jsonPath("content[0].genderCustomer").value(true))
                .andExpect(jsonPath("content[0].nameCustomer").value("Trí"))
                .andExpect(jsonPath("content[0].imgCustomer").value("https://th.bing.com/th/id/OIP.GU7rALcQVFnrd9dY76jgpAHaEc?pid=ImgDet&rs=1"))
                .andExpect(jsonPath("content[0].nationalityCustomer").value("Việt Nam"))
                .andExpect(jsonPath("content[0].telCustomer").value("038300937"))
                .andExpect(jsonPath("content[0].flagCustomer").value(false));
    }
    /**
     * Create by: TàiMP
     * Date create: 11/08/2023
     * Method: getListSearchCustomer_name_nationality_email_99 have 1 param and this param have data don't valid with database and return status 4xx
     * param: name,email,nationality
     * @throws Exception
     */
    @Test
    public void getListSearchCustomer_name_nationality_email_99() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/customers/search?name=123123&&nationality=&&email=&&page=0"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }
    /**
     * Create by: TàiMP
     * Date create: 11/08/2023
     * Method: getListSearchCustomer_name_nationality_email_98 have 1 param and this param have data don't valid with database and return status 4xx
     * param: name,email,nationality
     * @throws Exception
     */
 @Test
    public void getListSearchCustomer_name_nationality_email_98() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/customers/search?name=&&nationality=123123&&email=&&page=0"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }
    /**
     * Create by: TàiMP
     * Date create: 11/08/2023
     * Method: getListSearchCustomer_name_nationality_email_97 have 1 param and this param have data don't valid with database and return status 4xx
     * param: name,email,nationality
     * @throws Exception
     */
 @Test
    public void getListSearchCustomer_name_nationality_email_97() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/customers/search?name=&&nationality=&&email=123123&&page=0"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }
    /**
     * Create by: TàiMP
     * Date create: 11/08/2023
     * Method: getListSearchCustomer_name_nationality_email_94 have 2 param name,nationality and this param have data don't valid with database and return status 4xx
     * param: name,email,nationality
     * @throws Exception
     */
    @Test
    public void getListSearchCustomer_name_nationality_email_94() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/customers/search?name=123123&&nationality=123123&&email=&&page=0"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }
    /**
     * Create by: TàiMP
     * Date create: 11/08/2023
     * Method: getListSearchCustomer_name_nationality_email_93 have 2 param name,email and this param have data don't valid with database and return status 4xx
     * param: name,email,nationality
     * @throws Exception
     */
    @Test
    public void getListSearchCustomer_name_nationality_email_93() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/customers/search?name=123213&&nationality=&&email=123123&&page=0"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }
    /**
     * Create by: TàiMP
     * Date create: 11/08/2023
     * Method: getListSearchCustomer_name_nationality_email_92 have 2 param nationality,email and this param have data don't valid with database and return status 4xx
     * param: name,email,nationality
     * @throws Exception
     */
    @Test
    public void getListSearchCustomer_name_nationality_email_92() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/customers/search?name=&&nationality=123123&&email=123123&&page=0"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }
    /**
     * Create by: TàiMP
     * Date create: 11/08/2023
     * Method: getListSearchCustomer_name_nationality_email_91 have 3 param name,nationality,email and this param have data don't valid with database and return status 4xx
     * param: name,email,nationality
     * @throws Exception
     */
    @Test
    public void getListSearchCustomer_name_nationality_email_91() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/customers/search?name=123123123&&nationality=123123&&email=123123&&page=0"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }
    /**
     * Create by: TàiMP
     * Date create: 11/08/2023
     * Method: getListSearchCustomer_name_nationality_email_92 have 3 param name,nationality,email empty and return status 2xx
     * param: name,email,nationality
     * @throws Exception
     */
    @Test
    public void getListSearchCustomer_name_nationality_email_96() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/customers/search?name=&&nationality=&&email=&&page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(3))
                .andExpect(jsonPath("totalElements").value(15))
                .andExpect(jsonPath("content[0].addressCustomer").value("Bình An"))
                .andExpect(jsonPath("content[0].dateCustomer").value("11/11/1991"))
                .andExpect(jsonPath("content[0].emailCustomer").value("sieuem2002@gmail.com"))
                .andExpect(jsonPath("content[0].genderCustomer").value(true))
                .andExpect(jsonPath("content[0].nameCustomer").value("Tài"))
                .andExpect(jsonPath("content[0].imgCustomer").value("https://th.bing.com/th/id/OIP.GU7rALcQVFnrd9dY76jgpAHaEc?pid=ImgDet&rs=1"))
                .andExpect(jsonPath("content[0].nationalityCustomer").value("Lào"))
                .andExpect(jsonPath("content[0].telCustomer").value("012345"))
                .andExpect(jsonPath("content[0].flagCustomer").value(false))
                .andExpect(jsonPath("content[4].addressCustomer").value("Đà Nẵng"))
                .andExpect(jsonPath("content[4].dateCustomer").value("11/11/1996"))
                .andExpect(jsonPath("content[4].emailCustomer").value("sieuem2002@gmail.com"))
                .andExpect(jsonPath("content[4].genderCustomer").value(true))
                .andExpect(jsonPath("content[4].nameCustomer").value("Quốc"))
                .andExpect(jsonPath("content[4].imgCustomer").value("https://th.bing.com/th/id/OIP.GU7rALcQVFnrd9dY76jgpAHaEc?pid=ImgDet&rs=1"))
                .andExpect(jsonPath("content[4].nationalityCustomer").value("Việt Nam"))
                .andExpect(jsonPath("content[4].telCustomer").value("038300937"))
                .andExpect(jsonPath("content[4].flagCustomer").value(false));
    }




}

