package com.tc.dynamics;

import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;

class UserApiTest {

    // Mock API call simulation (Replace with actual API client in a real project)
    String getUserDetails(String userId) {
        if ("101".equals(userId)) return "{ \"id\": 101, \"name\": \"John Doe\" }";  // Valid user
        if ("999".equals(userId)) return "404 NOT FOUND";  // Invalid user
        if (userId == null) return "400 BAD REQUEST";  // Null ID
        return "500 INTERNAL SERVER ERROR";
    }

    @TestFactory
    @DisplayName("Dynamic Tests for User API")
    Stream<DynamicTest> dynamicTestsForUserApi() {
        List<String> testUserIds = Arrays.asList("101", "999", null);

        return testUserIds.stream().map(userId ->
                dynamicTest("Testing User ID: " + userId, () -> {
                    String response = getUserDetails(userId);
                    if ("101".equals(userId)) {
                        assertTrue(response.contains("John Doe"), "Valid user must return correct data");
                    } else if ("999".equals(userId)) {
                        assertEquals("404 NOT FOUND", response, "Invalid user should return 404");
                    } else {
                        assertEquals("400 BAD REQUEST", response, "Null user should return 400");
                    }
                })
        );
    }
}
