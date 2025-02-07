package com.tc.dynamics;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.*;
import org.junit.jupiter.api.*;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DynamicTestExample {
    // Dynamic Test Example
    @TestFactory
    Stream<DynamicTest> dynamicTestsExample() {
        return IntStream.range(1, 6).mapToObj(n ->
                dynamicTest("Test if " + n + " squared is " + (n * n),
                        () -> assertEquals(n * n, Math.pow(n, 2))
                )
        );
    }
}
