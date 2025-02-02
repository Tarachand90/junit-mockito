package com.tc.repeated;

public class ApiClient {

    private final int[] failurePattern = {0, 1, 2, 4, 5, 6, 7, 8, 9, 3};
    private int index = 0;

    public boolean fetchDataFromApi() {
        if (failurePattern[index % failurePattern.length] < 3) { // 30% failure
            index++;
            throw new RuntimeException("API Timeout Error!");
        }
        index++;
        return true; // API call successful
    }
}
