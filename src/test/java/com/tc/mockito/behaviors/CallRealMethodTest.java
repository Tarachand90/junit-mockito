package com.tc.mockito.behaviors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CallRealMethodTest {
    @Mock
    private ServiceImpl mockService;

    @Test
    void testCallingRealMethodOnMock() {

        // Stubbing to call the real method
        when(mockService.getMessage()).thenCallRealMethod();
        when(mockService.getCount()).thenCallRealMethod();
        when(mockService.isActive()).thenCallRealMethod();

        // Verifying stubbed responses
        assertEquals("Hello", mockService.getMessage());
        assertEquals(1, mockService.getCount());
        assertTrue(mockService.isActive());
    }
}
