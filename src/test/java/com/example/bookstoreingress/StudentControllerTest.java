package com.example.bookstoreingress;

import com.example.bookstoreingress.controller.StudentController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class StudentControllerTest {

    private MockMvc mockMvc;

    @MockBean
    private StudentController studentController;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
    }

    @Test
    public void testGetEndpoint() throws Exception {
        when(studentController.get()).thenReturn("GET:: student controller");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/student")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        verify(studentController).get();
    }

    @Test
    public void testPostEndpoint() throws Exception {
        when(studentController.post()).thenReturn("POST:: student controller");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/student")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        verify(studentController).post();
    }

    @Test
    public void testPutEndpoint() throws Exception {
        when(studentController.put()).thenReturn("PUT:: student controller");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/student")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        verify(studentController).put();
    }

    @Test
    public void testDeleteEndpoint() throws Exception {
        when(studentController.delete()).thenReturn("DELETE:: student controller");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/student")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        verify(studentController).delete();
    }
}

