package com.tc.conditional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class OSBasedTests {

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testOnlyOnWindows() {
        System.out.println("This test will only run on Windows OS");
    }

    @Test
    @DisabledOnOs(OS.LINUX)
    void testNotOnLinux() {
        System.out.println("This test will be skipped on Linux OS");
    }


}
