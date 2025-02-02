package com.tc.asserts;

import java.util.concurrent.TimeUnit;

public class UserService {

    public String fetchUserDetails() {
        try {
            // Simulate a database call with a delay
            TimeUnit.MICROSECONDS.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return "User Data";
    }

}
