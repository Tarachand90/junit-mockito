package com.tc.doubles.dummy.mockito;

import com.tc.doubles.dummy.NotificationService;
import com.tc.doubles.dummy.User;
import com.tc.doubles.dummy.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class UserServiceDummyTest {
    @Test
    public void shouldCreateUserCorrectly() {
        // Mock the NotificationService
        NotificationService notificationService = Mockito.mock(NotificationService.class);

        // Create the UserService with the mocked NotificationService
        UserService userService = new UserService(notificationService);

        // Use Mockito to specify that sendNotification() will be called with any User and any String
        doNothing()
                .when(notificationService)
                .sendNotification(any(User.class), anyString());

        // Act
        User user = userService.createUser(1, "Deba");

        // Assert
        assertNotNull(user);
        assertEquals(1, user.getId());
        assertEquals("Deba", user.getName());

        // Optionally, verify that the notification was sent
        verify(notificationService, times(1))
                .sendNotification(any(User.class), anyString());
    }
}
