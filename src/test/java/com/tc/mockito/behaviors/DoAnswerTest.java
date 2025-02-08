package com.tc.mockito.behaviors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class DoAnswerTest {

    @Mock
    private Logger loggerMock;

    @Test
    void testDoAnswerForVoidMethod() {
        // Stubbing a void method with doAnswer()
        doAnswer(invocationOnMock -> {
            String msg = invocationOnMock.getArgument(0);
            System.out.println("Logging: " + msg);
            return null; // Void methods must return null
        }).when(loggerMock).log(anyString());

        // Call method
        loggerMock.log("Hello Mockito!");

        // Verify the method was called
        verify(loggerMock).log("Hello Mockito!");
    }
}
