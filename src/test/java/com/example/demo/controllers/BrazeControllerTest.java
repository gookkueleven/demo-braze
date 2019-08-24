package com.example.demo.controllers;

import com.example.demo.services.BrazeUserDataService;
import lombok.NoArgsConstructor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@NoArgsConstructor
@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(value = UserDataController.class)
public class BrazeControllerTest {

    private MockMvc mockMvc;

    private UserDataController userDataController;

    @Mock
    private BrazeUserDataService brazeUserDataService;

    @Before
    public void setUp() {
        userDataController = new UserDataController(brazeUserDataService);

        mockMvc = MockMvcBuilders.standaloneSetup(this.userDataController).build();
    }

    @Test
    public void test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/user/data/serialize"))
                .andDo(print())
                .andExpect(jsonPath("$.inner.message", is("฿ 1000")));
    }
}
