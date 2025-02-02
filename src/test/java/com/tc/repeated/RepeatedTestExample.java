package com.tc.repeated;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RepeatedTestExample {

    @RepeatedTest(3)
    void testAddition() {
        assertTrue(5 == (2 + 3));
    }

    @RepeatedTest(3)
    void testWithRepetitionInfo(RepetitionInfo repetitionInfo) {
        int currentRepetition = repetitionInfo.getCurrentRepetition();
        int totalRepetitions = repetitionInfo.getTotalRepetitions();
        System.out.println("Running test " + currentRepetition + " of " + totalRepetitions);

        assertEquals(5, 2 + 3);
    }
}
