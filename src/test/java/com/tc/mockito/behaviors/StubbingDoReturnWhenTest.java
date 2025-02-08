package com.tc.mockito.behaviors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StubbingDoReturnWhenTest {
    @Mock
    private Service mockService;

    @Test
    void testStubbingWithDoReturnWhen() {
        // Stubbing method behavior
        doReturn("Hello").when(mockService).getMessage();
        doReturn(1).when(mockService).getCount();
        doReturn(true).when(mockService).isActive();

        // Verifying stubbed responses
        assertEquals("Hello", mockService.getMessage());
        assertEquals(1, mockService.getCount());
        assertTrue(mockService.isActive());
    }
}
