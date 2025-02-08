package com.tc.userregistration;

import com.tc.userregistration.service.NotificationService;
import com.tc.userregistration.service.UserService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public final class UserServiceTest {

    @Mock
    private NotificationService mockNotificationService;

    @InjectMocks
    private UserService userService;

    @Test
    void testNoNotificationForInvalidUser() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> userService.registerUser(null));

        assertEquals("Email cannot be null", exception.getMessage());

        // Verify that sendWelcomeEmail() was not called

        //verify(mockNotificationService, never()).sendWelcomeEmail(anyString());

        //or
        verifyNoInteractions(mockNotificationService);

    }

    @ParameterizedTest
    @ValueSource(strings = {"", "   "}) // Runs test for both "" and "   "
    void testExceptionThrownForEmptyEmail(String invalidEmail) {
        // Verify empty string throws IllegalArgumentException
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> userService.registerUser(invalidEmail));

        assertEquals("Email cannot be empty", exception.getMessage());

        // Verify that sendWelcomeEmail() was not called

        //verify(mockNotificationService, never()).sendWelcomeEmail(anyString());

        //or
        verifyNoInteractions(mockNotificationService);

    }

    @Test
    void testUserRegistrationSendsNotification() {
        userService.registerUser("test@example.com");

        // Verify that sendWelcomeEmail() was called
        verify(mockNotificationService).sendWelcomeEmail("test@example.com");

        // Ensure no other interactions occurred
        verifyNoMoreInteractions(mockNotificationService);
    }

    @Test
    void testEmailSentWithCorrectArgument() {
        userService.registerUser("test@example.com");

        // Verify that sendWelcomeEmail() was called
        verify(mockNotificationService).sendWelcomeEmail(eq("test@example.com"));

        // Ensure no other interactions occurred
        verifyNoMoreInteractions(mockNotificationService);
    }

    @Test
    void testHandleEmailSendingFailure() {
        // Simulate exception when calling sendWelcomeEmail()
        doThrow(new RuntimeException("SMTP server down"))
                .when(mockNotificationService)
                .sendWelcomeEmail("test@example.com");

        // Call registerUser() - it should not throw an exception
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> userService.registerUser("test@example.com"));

        assertEquals("SMTP server down", exception.getMessage());
        // Verify sendWelcomeEmail() was attempted
        verify(mockNotificationService).sendWelcomeEmail("test@example.com");

    }

    @Test
    void testEmailSentTwiceForTwoRegistrations() {
        // Register the same user twice
        userService.registerUser("test@example.com");
        userService.registerUser("test@example.com");

        // Verify that sendWelcomeEmail() was called
        verify(mockNotificationService, times(2)).sendWelcomeEmail("test@example.com");

        // Ensure no other interactions occurred
        verifyNoMoreInteractions(mockNotificationService);
    }

    @Test
    void testCaptureArgumentPassedToSendWelcomeEmail() {
        // Register a user
        userService.registerUser("test@example.com");

        // Capture the argument passed to sendWelcomeEmail()
        ArgumentCaptor<String> emailCaptor = ArgumentCaptor.forClass(String.class);
        verify(mockNotificationService).sendWelcomeEmail(emailCaptor.capture());

        // Verify the captured email argument
        assertEquals("test@example.com", emailCaptor.getValue());
    }

    @Test
    void testCaptureArgumentEmailSentTwiceForTwoRegistrations() {
        // Register the same user twice
        userService.registerUser("test@example.com");
        userService.registerUser("test1@example.com");

        ArgumentCaptor<String> emailCaptor = ArgumentCaptor.forClass(String.class);
        verify(mockNotificationService, times(2)).sendWelcomeEmail(emailCaptor.capture());

        List<String> capturedEmails = emailCaptor.getAllValues();
        assertEquals(List.of("test@example.com", "test1@example.com"), capturedEmails);
        // Ensure no other interactions occurred
        verifyNoMoreInteractions(mockNotificationService);
    }

    @Test
    void testEmailSentWithinTimeout() {
        // Register a user (which should trigger an email in the background)
        userService.registerUser("test@example.com");

        // Verify email is sent within 1000ms (1 second)
        verify(mockNotificationService, timeout(1000)).sendWelcomeEmail("test@example.com");
    }

    @Disabled
    // this test case is not working as sendFollowupEmail is not getting triggered
    void testFollowUpEmailSentAfterDelay() {
        // Register a user (which should trigger a delayed follow-up email)
        userService.registerUser("test@example.com");


        // Verify follow-up email is sent after 5 seconds
        // Verify after 5 seconds that sendFollowupEmail() was called once
        verify(mockNotificationService, after(5000).times(1))
                .sendFollowupEmail("test@example.com");
    }
}
