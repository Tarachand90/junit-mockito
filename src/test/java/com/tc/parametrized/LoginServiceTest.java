package com.tc.parametrized;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

public class LoginServiceTest {

    private LoginService loginService;

    @BeforeEach
    void setUp() {
        loginService = new LoginService();
    }

    @ParameterizedTest
    @CsvSource({
            "user1, password123, true",
            "admin, admin@123, true",
            "guest, guestPass, true",
            "user1, wrongPass, false",
            "unknownUser, password123, false"
    })
    void testAuthentication(String username, String password, boolean expected) {
        assertEquals(loginService.authenticate(username, password), expected,
                "Failed for: " + username);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/login-data.csv", numLinesToSkip = 1)
    void testAuthenticationUsingCsvFile(String username, String password, boolean expected) {
        assertEquals(loginService.authenticate(username, password), expected,
                "Failed for: " + username);
    }

    @ParameterizedTest
    @EnumSource(value = UserRole.class, names = {"ADMIN", "USER", "GUEST"})
    void testAccessForValidRoles(UserRole role) {
        assertTrue(loginService.hasAccess(role), "Failed for role: " + role);
    }

    @ParameterizedTest
    @EnumSource(value = UserRole.class, names = {"UNKNOWN"})
    void testAccessForInValidRoles(UserRole role) {
        assertFalse(loginService.hasAccess(role), "Failed for role: " + role);
    }

    @ParameterizedTest(name = "{index} => username={0}, password={1}, expected={2}")
    @ArgumentsSource(LoginTestDataProvider.class)
    void testAuthenticationUsingArgumentsSource(String username, String password, boolean expected) {
        boolean result = loginService.authenticate(username, password);
        assertEquals(expected, result, "Failed for: " + username);
    }
}
