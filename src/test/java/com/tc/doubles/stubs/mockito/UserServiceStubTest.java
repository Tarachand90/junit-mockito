package com.tc.doubles.stubs.mockito;


import com.tc.doubles.dummy.User;
import com.tc.doubles.stubs.UserRepository;
import com.tc.doubles.stubs.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserServiceStubTest {
    private UserService userService;
    private UserRepository stubRepository;

    @BeforeEach
    public void setUp() {
        // Arrange: Mock the StubUserRepository
        stubRepository = mock(UserRepository.class);
        userService = new UserService(stubRepository);
    }
    @Test
    public void testGetUserName() {
        User user = new User(1, "Deba");

        when(stubRepository.findById(1))
                .thenReturn(user);

        // Act: Get the user name for user ID 1
        String userName = userService.getUserName(1);

        // Assert: Verify that the user name is "Deba"
        assertEquals("Deba", userName);

        // Verify that findById(100) was called exactly once
        verify(stubRepository, times(1)).findById(1);
    }

    @Test
    public void testGetUserNameUnknown() {

        // Arrange: Mock the repository to return a User with name "Unknown"
        User user = new User(100, "Unknown");
        when(stubRepository.findById(100))
                .thenReturn(user);

        // Act: Try getting the user name for a non-existing user ID
        String userName = userService.getUserName(100);

        // Assert: Verify that the user name is "Unknown"
        assertEquals("Unknown", userName);

        // Verify that findById(100) was called exactly once
        verify(stubRepository, times(1)).findById(100);

    }
}
