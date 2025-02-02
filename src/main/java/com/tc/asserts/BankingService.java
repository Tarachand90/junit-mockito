package com.tc.asserts;

public class BankingService {

    public boolean transferMoney(String fromAccount, String toAccount, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
        return true; // Simulating successful transfer
    }
}
