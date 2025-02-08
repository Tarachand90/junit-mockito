package com.tc.mockito.behaviors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ChainedCallsTest {

    @Mock
    private Service mockService;

    @Test
    void testChainedMethodCalls() {
        // Stubbing multiple return values
        when(mockService.getCount()).thenReturn(1, 2, 3);

        // Verify sequential returns
        assertEquals(1, mockService.getCount()); // First call
        assertEquals(2, mockService.getCount()); // Second call
        assertEquals(3, mockService.getCount()); // Third call
        assertEquals(3, mockService.getCount()); // Keeps returning last value
    }
}
