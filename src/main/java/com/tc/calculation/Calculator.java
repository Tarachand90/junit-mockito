package com.tc.calculation;

public class Calculator {

    public int divide(int a, int b) {
        if(b == 0) {
            throw new ArithmeticException("Cannot divide by zero"); // Custom exception message
        }
        return a / b;
    }
}
