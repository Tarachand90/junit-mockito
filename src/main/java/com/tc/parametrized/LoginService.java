package com.tc.parametrized;

import java.util.HashMap;
import java.util.Map;

public class LoginService {

    private final Map<String, String> userDatabase = new HashMap<>();

    public LoginService() {
        userDatabase.put("user1", "password123");
        userDatabase.put("admin", "admin@123");
        userDatabase.put("guest", "guestPass");
    }

    public boolean authenticate(String username, String password) {
        return userDatabase.containsKey(username) && userDatabase.get(username).equals(password);
    }

    public boolean hasAccess(UserRole role) {
        return role == UserRole.ADMIN || role == UserRole.USER || role == UserRole.GUEST;
    }
}
