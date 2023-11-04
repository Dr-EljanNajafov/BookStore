package com.example.bookstoreingress;

import com.example.bookstoreingress.auth.RegisterRequest;
import com.example.bookstoreingress.user.Role;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterRequestTest {

    @Test
    public void testGettersAndSetters() {
        RegisterRequest request = new RegisterRequest();
        request.setFirstname("El");
        request.setLastname("Na");
        request.setEmail("el@example.com");
        request.setPassword("password");
        request.setRole(Role.USER);

        assertEquals("El", request.getFirstname());
        assertEquals("Na", request.getLastname());
        assertEquals("el@example.com", request.getEmail());
        assertEquals("password", request.getPassword());
        assertEquals(Role.USER, request.getRole());
    }

    @Test
    public void testAllArgsConstructor() {
        RegisterRequest request = new RegisterRequest("El", "Na", "el@example.com", "password", Role.USER);

        assertEquals("El", request.getFirstname());
        assertEquals("Na", request.getLastname());
        assertEquals("el@example.com", request.getEmail());
        assertEquals("password", request.getPassword());
        assertEquals(Role.USER, request.getRole());
    }

    @Test
    public void testBuilder() {
        RegisterRequest request = RegisterRequest.builder()
                .firstname("El")
                .lastname("Na")
                .email("el@example.com")
                .password("password")
                .role(Role.USER)
                .build();

        assertEquals("El", request.getFirstname());
        assertEquals("Na", request.getLastname());
        assertEquals("el@example.com", request.getEmail());
        assertEquals("password", request.getPassword());
        assertEquals(Role.USER, request.getRole());
    }
}
