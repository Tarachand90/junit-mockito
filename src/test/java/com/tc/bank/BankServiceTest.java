package com.tc.bank;

import com.tc.exceptions.AccountNotFoundException;
import com.tc.exceptions.InsufficientFundsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankServiceTest {

    private BankService service;

    @BeforeEach
    void setUp() {
        service = new BankService();
    }

    @Test
    void testGetAccountByAccountNumber_ThrowsAccountNotFoundException() {
        // Test for a non-existent account number
        Exception exception = assertThrows(AccountNotFoundException.class,
                () -> service.getAccountByAccountNumber("1"));

        // Verify that the exception message matches
        assertEquals("Account with account number 1 not found",
                exception.getMessage());
    }

    @Test
    void testGetAccountByAccountNumber_ReturnsAccount() throws AccountNotFoundException {
        // Test for an existing account number
        BankAccount account = service.getAccountByAccountNumber("12345");

        assertNotNull(account);
        assertEquals("12345", account.getAccountNumber());
        assertEquals(1000.00, account.getBalance());
    }

    @Test
    void testWithdraw_ThrowsInsufficientFundsException() {
        Exception exception = assertThrows(InsufficientFundsException.class,
                () -> service.withdraw("12345", 5000));

        assertEquals("Insufficient funds for withdrawal. Available balance: 1000.0",
                exception.getMessage());
    }

    @Test
    void testWithdraw_SuccessfulWithdrawal() throws AccountNotFoundException,
            InsufficientFundsException {
        // Arrange: Get the account
        BankAccount account = service.getAccountByAccountNumber("12345");

        // Act: Withdraw an amount less than the balance
        service.withdraw("12345", 500.00);

        // Assert: Check if the balance is updated correctly
        assertEquals(500.00, account.getBalance());

    }
}
