package com.tc.conditional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.EnabledIf;

public class ConditionalTests {

    @Test
    @EnabledIf("customCondition")
    void testEnabledIf() {
        System.out.println("This test will only run if the custom condition is true");
    }

    @Test
    @DisabledIf("customCondition")
    void testDisabledIf() {
        System.out.println("This test will be skipped if the custom condition is true");
    }

    boolean customCondition() {
        // Return true or false based on your condition logic
        return true;
    }
}
