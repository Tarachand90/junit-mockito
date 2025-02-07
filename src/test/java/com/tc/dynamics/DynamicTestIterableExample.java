package com.tc.dynamics;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import static org.junit.jupiter.api.DynamicTest.*;
import static org.junit.jupiter.api.Assertions.*;

public class DynamicTestIterableExample {

    @TestFactory
    Iterable<DynamicTest> dynamicTestsUsingIterable() {
        return Arrays.asList(
                dynamicTest("Subtraction Test", () -> assertEquals(1, 3 - 2)),
                dynamicTest("Division Test", () -> assertEquals(2, 6 / 3))
        );

    }
}
