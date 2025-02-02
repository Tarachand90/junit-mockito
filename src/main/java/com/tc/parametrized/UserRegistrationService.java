package com.tc.parametrized;

public class UserRegistrationService {

    public boolean register(String username, String email) {
        if(username == null || email == null) {
            throw new IllegalArgumentException("Username and Email cannot be null");
        }

        if (username.isEmpty() || email.isEmpty()) {
            throw new IllegalArgumentException("Username and Email cannot be empty");
        }

        // Registration logic here
        return true;
    }
}
