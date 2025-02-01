package com.tc.transactions;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class TransactionUtilsTest {

    @Test
    public void testSortTransactions_Success() {
        double[] input = {500.75, 100.0, 300.5, 200.25};
        double[] expected = {100.0, 200.25, 300.5, 500.75};

        double[] result  = TranscationUtils.sortTransactions(input);
        assertArrayEquals(expected, result ,  "The sorted transaction array is incorrect.");
    }

    @Test
    public void testSortTransactions_EmptyArray() {
        double[] input = {};
        double[] expected = {};

        double[] result  = TranscationUtils.sortTransactions(input);
        assertArrayEquals(expected, result ,  "Sorting an empty array should return an empty array.");
    }

    @Test
    public void testSortTransactions_NullInput() {
        double[] expected = {};

        double[] result  = TranscationUtils.sortTransactions(null);
        assertArrayEquals(expected, result ,  "Null input should return an empty array.");
    }

    @Test
    public void testFilterHighValueTransactions_Success() {
        List<Double> input = List.of(500.75, 100.0, 300.5, 200.25);
        List<Double> expected = List.of(500.75, 300.5); // Filtering above 300

        List<Double> result = TranscationUtils.filterHighValueTransactions(input, 300.0);

        assertIterableEquals(expected, result, "Filtered transactions do not match expected output.");
    }

    @Test
    public void testFilterHighValueTransactions_NoMatches() {
        List<Double> input = List.of(500.75, 100.0, 300.5, 200.25);
        List<Double> expected = List.of(); // Filtering above 700, So no transcation

        List<Double> result = TranscationUtils.filterHighValueTransactions(input, 700.0);

        assertIterableEquals(expected, result, "Expected an empty list but got some transactions.");
    }

    @Test
    void testFilterHighValueTransactions_NullInput() {
        List<Double> expected = List.of(); // Expect an empty list for null input

        List<Double> result = TranscationUtils.filterHighValueTransactions(null, 200.0);

        assertIterableEquals(expected, result, "Null input should return an empty list.");
    }
}
