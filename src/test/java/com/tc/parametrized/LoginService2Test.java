package com.tc.parametrized;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // Needed for non-static method sources
public class LoginService2Test {

    private  LoginService loginService;

    @BeforeEach
    void setUp() {
        loginService = new LoginService();
    }

    static Stream<Arguments> providedLoginTestData() {
        return Stream.of(
                Arguments.of("user1", "password123", true),
                Arguments.of("admin", "admin@123", true),
                Arguments.of("guest", "guestPass", true),
                Arguments.of("user1", "wrongPass", false),
                Arguments.of("unknownUser", "password123", false)
        );
    }

    @ParameterizedTest(name = "{index} => username={0}, password={1}, expected={2}")
    @MethodSource("providedLoginTestData")
    @DisplayName("Testing authentication with dynamic test data")
    void testAuthentication(String username, String password, boolean expected) {
        boolean result = loginService.authenticate(username, password);
        assertEquals(expected, result, "Failed for: " + username);
    }
}
