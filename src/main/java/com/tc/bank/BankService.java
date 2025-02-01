package com.tc.bank;

import com.tc.exceptions.AccountNotFoundException;
import com.tc.exceptions.InsufficientFundsException;

import java.util.HashMap;
import java.util.Map;

public class BankService {
    // Simulating a database with a HashMap
    private Map<String, BankAccount> accountsDatabase = new HashMap<>();

    public BankService() {
        // Adding some accounts to the "database"
        accountsDatabase.put("12345", new BankAccount("12345", 1000.00));
        accountsDatabase.put("67890", new BankAccount("67890", 2000.00));
    }

    // Method to get the account by account number
    public BankAccount getAccountByAccountNumber(String accountNumber) throws AccountNotFoundException {
        BankAccount account = accountsDatabase.get(accountNumber);

        if (account == null) {
            throw new AccountNotFoundException("Account with account number " + accountNumber + " not found");
        }
        return account;
    }

    // Method to withdraw money from the account
    public void withdraw(String accountNumber, double amount) throws AccountNotFoundException, InsufficientFundsException {
        BankAccount account = getAccountByAccountNumber(accountNumber);

        double balance = account.getBalance();

        if(balance < amount) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal. Available balance: "+balance);
        }

        account.setBalance(balance - amount);
    }
}
