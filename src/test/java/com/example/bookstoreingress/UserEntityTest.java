package com.example.bookstoreingress;

import com.example.bookstoreingress.user.User;
import com.example.bookstoreingress.user.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class UserEntityTest {

    @Autowired
    private TestEntityManager entityManager;

    private User user;

    @BeforeEach
    public void setup() {
        user = User.builder()
                .firstname("El")
                .lastname("Na")
                .email("el.na@example.com")
                .password("password")
                .role(Role.USER)
                .build();
    }

    @Test
    public void testSaveAndRetrieveUser() {
        User savedUser = entityManager.persistAndFlush(user);

        // Retrieve the user from the database
        User retrievedUser = entityManager.find(User.class, savedUser.getId());

        assertNotNull(retrievedUser);
        assertEquals(user.getFirstname(), retrievedUser.getFirstname());
        assertEquals(user.getLastname(), retrievedUser.getLastname());
        assertEquals(user.getEmail(), retrievedUser.getEmail());
        assertEquals(user.getPassword(), retrievedUser.getPassword());
        assertEquals(user.getRole(), retrievedUser.getRole());
    }

    @Test
    public void testUserRoles() {
        User savedUser = entityManager.persistAndFlush(user);

        // Retrieve the user from the database
        User retrievedUser = entityManager.find(User.class, savedUser.getId());

        assertNotNull(retrievedUser);

        // Check the user's role
        assertEquals(user.getRole(), Role.USER);
    }
}

