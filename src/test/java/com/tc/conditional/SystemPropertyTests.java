package com.tc.conditional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;

class SystemPropertyTests {

    @Test
    @EnabledIfSystemProperty(named = "env", matches = "prod")
    void testOnProduction() {
        System.out.println("This test will run only if the system property \"env\" is \"prod\"");

    }

    @Test
    @DisabledIfSystemProperty(named = "env", matches = "dev")
    void testNotOnDev() {
        System.out.println("This test will be skipped if the system property \"env\" is \"dev\"");
    }
}