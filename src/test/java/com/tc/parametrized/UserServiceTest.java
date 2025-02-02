package com.tc.parametrized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class UserServiceTest {

    private UserService userService = new UserService();

    @ParameterizedTest
    @ValueSource(strings =  {
            "invalid-email", "user.com", "userdomain", "@domain.com", "userdomain.com"
    })
    void testInvalidEmails(String email) {
        assertFalse(userService.isValidEmail(email), "Email should be invalid: " + email);
    }
}
