package com.tc.bank;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class BankAccount {
    private String accountNumber;
    private double balance;

}
