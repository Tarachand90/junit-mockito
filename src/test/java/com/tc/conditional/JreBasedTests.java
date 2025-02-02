package com.tc.conditional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.JRE;

public class JreBasedTests {

    @Test
    @EnabledOnJre({JRE.JAVA_11, JRE.JAVA_17})
    void testOnlyOnJava8AndJava17() {
        System.out.println("This test will only run on Java 11 amd java 17");
    }

    @Test
    @DisabledOnJre(JRE.JAVA_8)
    void testNotOnJava8() {
        System.out.println("This test will be skipped on Java 7");

    }
}
