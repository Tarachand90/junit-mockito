package com.tc.dynamics;

import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class UserApiTestWithDynamicContainer {
    String getUserDetails(String userId) {
        if ("101".equals(userId)) return "{ \"id\": 101, \"name\": \"John Doe\" }";
        if ("999".equals(userId)) return "404 NOT FOUND";
        if (userId == null) return "400 BAD REQUEST";
        return "500 INTERNAL SERVER ERROR";
    }

    @TestFactory
    Stream<DynamicNode> dynamicTestsForUserApi() {
        return Stream.of(
                DynamicContainer.dynamicContainer("Valid User Tests",
                        Stream.of(
                                dynamicTest("User ID 101 - Valid Response", () -> {
                                    String response = getUserDetails("101");
                                    assertTrue(response.contains("John Doe"));
                                })
                        )
                ),
                DynamicContainer.dynamicContainer("Invalid User Tests",
                        Stream.of(
                                dynamicTest("User ID 999 - Not Found", () -> {
                                    assertEquals("404 NOT FOUND", getUserDetails("999"));
                                }),
                                dynamicTest("Null User ID - Bad Request", () -> {
                                    assertEquals("400 BAD REQUEST", getUserDetails(null));
                                })
                        )
                )
        );
    }
}