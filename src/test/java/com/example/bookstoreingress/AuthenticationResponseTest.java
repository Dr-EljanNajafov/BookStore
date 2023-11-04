package com.example.bookstoreingress;

import com.example.bookstoreingress.auth.AuthenticationResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AuthenticationResponseTest {

    @Test
    public void testCreateAuthenticationResponse() {
        AuthenticationResponse response = new AuthenticationResponse("accessTokenValue", "refreshTokenValue");

        assertNotNull(response);
        assertEquals("accessTokenValue", response.getAccessToken());
        assertEquals("refreshTokenValue", response.getRefreshToken());
    }

    @Test
    public void testSetterMethods() {
        AuthenticationResponse response = new AuthenticationResponse();
        response.setAccessToken("accessTokenValue");
        response.setRefreshToken("refreshTokenValue");

        assertNotNull(response);
        assertEquals("accessTokenValue", response.getAccessToken());
        assertEquals("refreshTokenValue", response.getRefreshToken());
    }
}

