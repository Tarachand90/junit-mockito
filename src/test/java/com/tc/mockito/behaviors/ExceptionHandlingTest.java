package com.tc.mockito.behaviors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExceptionHandlingTest {

    @Mock
    private Service mockService;

    @Test
    void testExceptionThrowingWithThenThrow() {
        // Stubbing to throw an exception
        when(mockService.getMessage()).thenThrow(new RuntimeException("Service failure"));

        RuntimeException expection =
                assertThrows(RuntimeException.class, mockService::getMessage);

        assertEquals("Service failure", expection.getMessage());
    }
}
