package com.example.bookstoreingress;

import com.example.bookstoreingress.service.AuthenticationService;
import com.example.bookstoreingress.auth.AuthenticationResponse;
import com.example.bookstoreingress.auth.RegisterRequest;
import com.example.bookstoreingress.service.JwtService;
import com.example.bookstoreingress.token.Token;
import com.example.bookstoreingress.dao.TokenRepository;
import com.example.bookstoreingress.user.Role;
import com.example.bookstoreingress.user.User;
import com.example.bookstoreingress.dao.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AuthenticationServiceTest {

    private AuthenticationService authenticationService;
    private UserRepository userRepository;
    private TokenRepository tokenRepository;
    private PasswordEncoder passwordEncoder;
    private JwtService jwtService;
    private AuthenticationManager authenticationManager;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        tokenRepository = mock(TokenRepository.class);
        passwordEncoder = mock(PasswordEncoder.class);
        jwtService = mock(JwtService.class);
        authenticationManager = mock(AuthenticationManager.class);

        authenticationService = new AuthenticationService(
                userRepository,
                tokenRepository,
                passwordEncoder,
                jwtService,
                authenticationManager
        );
    }

    @Test
    public void testRegister() {
        RegisterRequest registerRequest = new RegisterRequest("El", "Na", "el@example.com", "password", Role.USER);

        User user = User.builder()
                .firstname(registerRequest.getFirstname())
                .lastname(registerRequest.getLastname())
                .email(registerRequest.getEmail())
                .password("encodedPassword")
                .role(registerRequest.getRole())
                .build();

        when(passwordEncoder.encode(registerRequest.getPassword())).thenReturn("encodedPassword");
        when(userRepository.save(any(User.class))).thenReturn(user);

        String mockJwtToken = "mockJwtToken";
        String mockRefreshToken = "mockRefreshToken";
        when(jwtService.generateToken(user)).thenReturn(mockJwtToken);
        when(jwtService.generateRefreshToken(user)).thenReturn(mockRefreshToken);

        AuthenticationResponse response = authenticationService.register(registerRequest);

        verify(userRepository, times(1)).save(user);
        verify(tokenRepository, times(1)).save(any(Token.class));
        assertEquals(mockJwtToken, response.getAccessToken());
        assertEquals(mockRefreshToken, response.getRefreshToken());
    }
}
