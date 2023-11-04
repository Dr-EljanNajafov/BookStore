package com.example.bookstoreingress;

import com.example.bookstoreingress.demo.AuthorController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AuthorControllerTest {

    private MockMvc mockMvc;

    @MockBean
    private AuthorController authorController;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(authorController).build();
    }

    @Test
    @WithMockUser(roles = "AUTHOR")
    public void testGetEndpoint() throws Exception {
        when(authorController.get()).thenReturn("GET:: author controller");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/author"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        verify(authorController).get();
    }

    @Test
    @WithMockUser(username = "testuser", authorities = "author:read")
    public void testGetEndpointWithPreAuthorize() throws Exception {
        when(authorController.get()).thenReturn("GET:: author controller");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/author"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        verify(authorController).get();
    }

    // You can write similar tests for other endpoints with different PreAuthorize annotations.
}
