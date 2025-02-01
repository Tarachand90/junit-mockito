package com.tc.calculation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }
    @Test
    void testValidDivision() {
        assertEquals(5, calculator.divide(10, 2),
                "10 divided by 2 should return 5");
    }
    @Test
    void testDivideByZero() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0),
                "Division by zero should throw ArithmeticException");

        assertEquals("Cannot divide by zero", exception.getMessage(),
                "Exception message should match the expected message");
    }
}
