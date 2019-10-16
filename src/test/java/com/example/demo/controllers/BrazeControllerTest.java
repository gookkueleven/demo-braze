package com.example.demo.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demo.controllers.UserDataController;
import com.example.demo.services.BrazeUserDataService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest
public class BrazeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BrazeUserDataService brazeUserDataService;

    @Before
    public void setUp() {
        new UserDataController(brazeUserDataService);
    }

    @Test
    public void test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/user/data/serialize"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.inner.message", is("฿ 1000")));
    }
}
