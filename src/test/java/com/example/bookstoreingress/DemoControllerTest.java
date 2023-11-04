package com.example.bookstoreingress;

import com.example.bookstoreingress.demo.DemoController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class DemoControllerTest {

    private MockMvc mockMvc;

    @MockBean
    private DemoController demoController;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(demoController).build();
    }

    @Test
    public void testSayHelloEndpoint() throws Exception {
        when(demoController.sayHello()).thenReturn(ResponseEntity.ok("Hello from secured endpoint"));

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/demo-controller"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        verify(demoController).sayHello();
    }

    // You can write similar tests for other endpoints if needed.
}

