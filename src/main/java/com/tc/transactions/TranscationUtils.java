package com.tc.transactions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TranscationUtils {

    public static double[] sortTransactions(double[] transactions) {
        if(transactions == null) {
            return new double[]{}; // Return empty array for null input
        }
        // Clone to avoid modifying original array
        double[] sorted = transactions.clone();
        Arrays.sort(sorted);
        return sorted;
    }

    public static List<Double> filterHighValueTransactions(List<Double> transactions, double threshold) {
        if(transactions == null) {
            return List.of(); // Return an empty list for null input
        }

        return transactions.stream()
                .filter(amount -> amount > threshold)
                .collect(Collectors.toUnmodifiableList());
    }
}
