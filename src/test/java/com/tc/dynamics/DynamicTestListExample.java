package com.tc.dynamics;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.List;
import static org.junit.jupiter.api.DynamicTest.*;
import static org.junit.jupiter.api.Assertions.*;

public class DynamicTestListExample {

    @TestFactory
    List<DynamicTest> dynamicTestsUsingList() {
        return List.of(
                dynamicTest("Addition Test", () -> assertEquals(4, 2 + 2)),
                dynamicTest("Multiplication Test", () -> assertEquals(6, 2 * 3))
        );
    }
}
