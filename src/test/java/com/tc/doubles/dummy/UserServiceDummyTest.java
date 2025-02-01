package com.tc.doubles.dummy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceDummyTest {

    @Test
    public void shouldCreateUserCorrectly() {
        UserService userService = new UserService(new NotificationServiceImpl());

        // Act
        User user = userService.createUser(1, "Deba");

        // Assert
        assertNotNull(user);
        assertEquals(1, user.getId());
        assertEquals("Deba", user.getName());
    }
}
