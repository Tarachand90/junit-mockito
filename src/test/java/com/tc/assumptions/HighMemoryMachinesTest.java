package com.tc.assumptions;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HighMemoryMachinesTest {

    @Test
    void testOnlyOnHighMemoryMachines() {
        // Get total memory in MB
        long totalMemory = Runtime.getRuntime().maxMemory() / (1024 * 1024);

        // Assume the system has at least 8GB (8192 MB) of RAM
        Assumptions.assumingThat(totalMemory > 8192L, () -> {
            System.out.println("More than 8GB");
            assertEquals(2, 1 + 1);
        });
        assertEquals(3, 1 + 2);
    }

}
