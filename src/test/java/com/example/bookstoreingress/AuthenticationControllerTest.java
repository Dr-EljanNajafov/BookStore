package com.example.bookstoreingress;

import com.example.bookstoreingress.auth.AuthenticationRequest;
import com.example.bookstoreingress.auth.AuthenticationResponse;
import com.example.bookstoreingress.auth.RegisterRequest;
import com.example.bookstoreingress.service.AuthenticationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthenticationControllerTest {

    @MockBean
    private AuthenticationService authenticationService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        // Configure your mock authentication service here
    }

    @Test
    public void testRegister() throws Exception {
        RegisterRequest registerRequest = new RegisterRequest(); // Initialize with the required data
        AuthenticationResponse response = new AuthenticationResponse(); // Initialize with the expected response data

        when(authenticationService.register(Mockito.any(RegisterRequest.class))).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(registerRequest)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testAuthenticate() throws Exception {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest(); // Initialize with the required data
        AuthenticationResponse response = new AuthenticationResponse(); // Initialize with the expected response data

        when(authenticationService.authenticate(Mockito.any(AuthenticationRequest.class))).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/auth/authenticate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(authenticationRequest)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    // Utility method to convert an object to JSON string
    private String asJsonString(final Object obj) {
        try {
            final ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

