package com.tc.mockito.behaviors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StubbingWhenThenReturnTest {

    // Create a mock of Service
    @Mock
    private Service mockService;

    @Test
    void testStubbingWithWhenThenReturn() {
        // Stubbing method behavior
        when(mockService.getMessage()).thenReturn("Hello");
        when(mockService.getCount()).thenReturn(1);
        when(mockService.isActive()).thenReturn(true);

        // Verifying stubbed responses
        assertEquals("Hello", mockService.getMessage());
        assertEquals(1, mockService.getCount());
        assertTrue(mockService.isActive());
    }

}
