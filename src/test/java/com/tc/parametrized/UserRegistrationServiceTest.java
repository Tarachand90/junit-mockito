package com.tc.parametrized;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserRegistrationServiceTest {

    private UserRegistrationService userRegistrationService;

    @BeforeEach
    void setUp() {
        userRegistrationService = new UserRegistrationService();
    }

    @ParameterizedTest
    @NullSource
    void testRegisterWithNullEmail(String email) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> userRegistrationService.register("user123", email),
                "Email cannot be null");

        assertEquals("Username and Email cannot be null", exception.getMessage());
    }

    @ParameterizedTest
    @NullSource
    void testRegisterWithNullUserName(String username) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> userRegistrationService.register(username, "test@example.com"),
                "Username cannot be null");

        assertEquals("Username and Email cannot be null", exception.getMessage());
    }

    @ParameterizedTest
    @EmptySource
    void testRegisterWithEmptyEmail(String email) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> userRegistrationService.register("user123", email),
                "Email cannot be empty");

        assertEquals("Username and Email cannot be empty", exception.getMessage());
    }

    @ParameterizedTest
    @EmptySource
    void testRegisterWithEmptyUsername(String username) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> userRegistrationService.register(username, "test@example.com"),
                "Username cannot be empty");

        assertEquals("Username and Email cannot be empty", exception.getMessage());
    }
}
