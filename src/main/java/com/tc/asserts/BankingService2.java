package com.tc.asserts;

import java.util.Random;

public class BankingService2 {
    public double getAccountBalance(String accountNumber) {
        // Simulating an external API call
        if (new Random().nextBoolean()) {
            throw new RuntimeException("Bank API is currently down!");
        }
        return 1000.00;
    }
}
