package com.tc.asserts;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BankingService2Test {
    private final BankingService2 bankingService = new BankingService2();


    @Test
    @Disabled("Skipping this test because the bank API is under maintenance")
    void testGetAccountBalance() {
        // Arrange: Get the balance from the bank API
        double balance = bankingService.getAccountBalance("123456");

        // Assert: Verify that the balance is positive
        assertTrue(balance > 0, "Balance should be positive");
        assertTrue(balance > 0);
    }


    @Test
    void testSimpleMathOperation() {
        assertEquals(10, 5 + 5);
    }
}
