package com.tc.doubles.stubs.mockito.annotation.support;

import com.tc.doubles.dummy.User;
import com.tc.doubles.stubs.UserRepository;
import com.tc.doubles.stubs.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceStubMockitoAnnotationTest {

    @Mock
    private UserRepository stubRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testGetUserName() {
        // Arrange: Define behavior of mock
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

        // Arrange: Mock the repository to return null when user id is 100
        when(stubRepository.findById(100))
                .thenReturn(null);

        // Act: Try getting the user name for a non-existing user ID
        String userName = userService.getUserName(100);

        // Assert: Verify that the user name is "Unknown"
        assertEquals("Unknown", userName);

        // Verify that findById(100) was called exactly once
        verify(stubRepository, times(1)).findById(100);

    }
}
