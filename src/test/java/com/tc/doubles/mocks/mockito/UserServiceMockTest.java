package com.tc.doubles.mocks.mockito;

import com.tc.doubles.dummy.User;
import com.tc.doubles.spy.NotificationService;
import com.tc.doubles.spy.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class UserServiceMockTest {

    @Test
    public void testCreateUser() {
        // Arrange: Create a mock of NotificationService
        NotificationService notificationService = mock(NotificationService.class);
        UserService userService = new UserService(notificationService);

        // Stub sendEmail to do nothing (avoiding side effects)
        Mockito.doNothing()
                .when(notificationService).sendEmail(any(User.class), anyString());

        // Act: Call createUser
        User user = userService.createUser(1, "Deba");

        // Assert: Verify sendEmail was called with correct arguments
        verify(notificationService, times(1)).sendEmail(user, "Welcome!");

        // Optional: You can also assert the created user's details
        assertEquals(1, user.getId());
        assertEquals("Deba", user.getName());

    }
}
