package com.tc.asserts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BankingServiceTest {

    private BankingService bankingService;

    @BeforeEach
    void setUp() {
        bankingService = new BankingService();
    }

    @Test
    @DisplayName("Should successfully transfer money between accounts")
    void testSuccessfulTransfer() {
        boolean result = bankingService.transferMoney("fromAccount", "toAccount", 100.0);
        assertTrue(result);
    }

    @Test
    @DisplayName("Should throw exception when transfer amount is zero")
    void testTransferZeroAmount() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> bankingService.transferMoney("fromAccount", "toAccount", 0.0));

        assertTrue(exception.getMessage().contains("Amount must be greater than zero"));
    }
}
