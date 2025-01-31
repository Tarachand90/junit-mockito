package com.tc.doubles.mocks;

import doubles.dummy.User;
import doubles.spy.UserService;
import org.junit.jupiter.api.Test;

public class UserServiceMockImplTest {

    @Test
    public void testCreateUser() {
        // Arrange: Create the mock notification service
        NotificationServiceMockImpl notificationService = new NotificationServiceMockImpl();
        UserService userService = new UserService(notificationService);

        // Act: Create a new user
        User user = userService.createUser(1, "Deba");

        // Assert: Verify that the notification service was called with the correct parameters
        notificationService.verify(user, "Welcome!", 1);

    }
}
