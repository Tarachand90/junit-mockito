package com.tc.doubles.stubs;

import doubles.stubs.UserRepository;
import doubles.stubs.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserServiceStubTest {

    private UserService userService;

    @BeforeEach
    public void setUp() {
        // Arrange: Use the StubUserRepository
        UserRepository stubRepository = new UserRepositoryStubImpl();
         userService = new UserService(stubRepository);
    }
    @Test
    public void testGetUserName() {
        // Act: Get the user name for user ID 1
        String userName = userService.getUserName(1);

        // Assert: Verify that the user name is "Deba"
        assertEquals("Deba", userName);

    }

    @Test
    public void testGetUserNameUnknown() {
        // Act: Try getting the user name for a non-existing user ID
        String userName = userService.getUserName(100);

        // Assert: Verify that the user name is "Deba"
        assertEquals("Unknown", userName);

    }
}
