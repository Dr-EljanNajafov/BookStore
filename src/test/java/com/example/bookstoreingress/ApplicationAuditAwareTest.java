package com.example.bookstoreingress;

import com.example.bookstoreingress.auditing.ApplicationAuditAware;
import com.example.bookstoreingress.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApplicationAuditAwareTest {

    private ApplicationAuditAware auditAware;

    @BeforeEach
    public void setup() {
        auditAware = new ApplicationAuditAware();
    }

    @Test
    public void testGetCurrentAuditorNoAuthentication() {
        // Simulate no authentication
        SecurityContextHolder.clearContext();

        Optional<Integer> auditorId = auditAware.getCurrentAuditor();

        assertEquals(Optional.empty(), auditorId);
    }
}
