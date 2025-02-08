package com.tc.mockito.behaviors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class DefaultMockTest {

    // Create a mock of Service
    @Mock
    private Service service;

    @Test
    void testDefaultMockBehavior() {
        // Default return values (no stubbing done)
        assertNull(service.getMessage());
        assertEquals(0, service.getCount());
        assertFalse(service.isActive());
    }
}
