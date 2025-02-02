package com.tc.conditional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;

class EnvironmentVariableTests {

    @Test
    @EnabledIfEnvironmentVariable(named = "APP_ENV", matches = "production")
    void testInProduction() {
        System.out.println("This test will run only if the environment variable \"APP_ENV\" is \"production\"");
    }

    @Test
    @DisabledIfEnvironmentVariable(named = "APP_ENV", matches = "development")
    void testNotInDevelopment() {
        System.out.println("This test will be skipped if the environment variable \"APP_ENV\" is \"development\"");
    }
}
