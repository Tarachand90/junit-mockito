package com.tc.asserts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

public class UserServiceTest {

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService();
    }

    @Test
    void fetchUserDetails_shouldCompleteWithin2Seconds() {
        assertTimeout(Duration.ofSeconds(2), () -> {
            String result = userService.fetchUserDetails();
            assertEquals("User Data", result);
        });
    }
}
