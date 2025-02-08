package com.tc.mockito.behaviors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DynamicAnswerTest {

    @Mock
    private DoublingService mockService;

    @Test
    void testDynamicAnswerWithThenAnswer() {
        when(mockService.doubleValue(anyInt())).thenAnswer(invocationOnMock -> {
            int val = invocationOnMock.getArgument(0);
            return val * 2;
        });

        // Verify dynamic responses
        assertEquals(10, mockService.doubleValue(5));  // 5 * 2 = 10
        assertEquals(20, mockService.doubleValue(10)); // 10 * 2 = 20
        assertEquals(0, mockService.doubleValue(0));   // 0 * 2 = 0
    }
}
