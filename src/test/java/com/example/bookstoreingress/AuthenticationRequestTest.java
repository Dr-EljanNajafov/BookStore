package com.example.bookstoreingress;

import com.example.bookstoreingress.auth.AuthenticationRequest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AuthenticationRequestTest {

    @Test
    public void testCreateAuthenticationRequest() {
        AuthenticationRequest request = new AuthenticationRequest("el@example.com", "password");

        assertNotNull(request);
        assertEquals("el@example.com", request.getEmail());
        assertEquals("password", request.getPassword());
    }

    @Test
    public void testSetterMethods() {
        AuthenticationRequest request = new AuthenticationRequest();
        request.setEmail("el@example.com");
        request.setPassword("password");

        assertNotNull(request);
        assertEquals("el@example.com", request.getEmail());
        assertEquals("password", request.getPassword());
    }
}
