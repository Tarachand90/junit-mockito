package com.tc.doubles.spy;

import doubles.dummy.User;
import doubles.spy.UserService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserServiceSpyTest {

    @Test
    public void testCreateUser() {
        // Arrange
        NotificationServiceSpyImpl notificationService = new NotificationServiceSpyImpl();
        UserService userService = new UserService(notificationService);

        // Act
        User user =  userService.createUser(1, "Deba");


        // Assert
        assertEquals(1, notificationService.getTimes());
        assertTrue(notificationService.calledWith(new User(1, "Deba"), "Welcome!"));
    }
}
