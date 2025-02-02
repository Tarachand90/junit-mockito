package com.tc.repeated;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ApiClientTest {

    private ApiClient apiClient;

    @BeforeAll
    void setUp() {
        apiClient = new ApiClient();
    }

    @RepeatedTest(5)
    void testApiRetry(RepetitionInfo repetitionInfo) {
        // Get the current attempt number
        int attempt = repetitionInfo.getCurrentRepetition();
        System.out.println("Attempt #" + attempt + ": Calling API...");

        try {
            // Try fetching data from the API
            boolean success = apiClient.fetchDataFromApi();
            assertTrue(success, "API call should succeed");
            System.out.println("API call successful on attempt " + attempt);
            return; // Exit test if successful
        } catch (RuntimeException e) {
            // Log the failure
            System.out.println("API timeout on attempt " + attempt);

            // If it's the last attempt, fail the test
            if(attempt == repetitionInfo.getTotalRepetitions()) {
                fail("API call failed even after " + attempt + " attempts");
            }
        }
    }
}
