package com.example.testservicews.controllers;

import com.example.testservicews.config.MobileServiceTestConfig;
import com.example.testservicews.entity.Mobile;
import com.example.testservicews.service.MobileService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = MobileServiceTestConfig.class)
@AutoConfigureMockMvc
@WebMvcTest(MobileController.class)
public class MobileControllerTast {

    @Autowired
    private ObjectMapper objectMapper = new ObjectMapper();


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MobileService mobileService;

    @Test
    public void add() throws Exception {
        mockMvc.perform(
                post("/mobiles")
                .param("model", "iphone")
                .param("operSys", "ios")
                .param("memory", "64")
        ).andExpect(status().isOk())
        ;
    }

    @Test
    public void getAll() throws Exception {
        Mobile mobile = new Mobile("iphone", "ios", 64);
        Mockito.when(mobileService.getAllMobiles()).thenReturn(Collections.singletonList(mobile));
        mockMvc.perform(
                get("/mobiles")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].model").value("iphone"))
                .andExpect(jsonPath("$[0].operSys").value("ios"))
                .andExpect(jsonPath("$[0].memory").value(64))
        ;
    }

    @Test
    public void edit() throws Exception {
        Mobile mobile = new Mobile("iphone", "ios", 128);
        Mockito.when(mobileService.update(Mockito.any(), Mockito.any())).thenReturn(mobile);
        mockMvc.perform(
                put("/mobiles/1")
                        .content(objectMapper.writeValueAsString(mobile))
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk())
        .andExpect(jsonPath("memory").value(128))
        ;
    }

}
