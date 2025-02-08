package com.tc.userregistration.service;

public class UserService {
    private NotificationService notificationService;

    public UserService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void registerUser(String email) {
        if(email == null) {
            throw new IllegalArgumentException("Email cannot be null");
        }

        if(email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
        // Perform user registration logic...
        notificationService.sendWelcomeEmail(email);  // Trigger notification
    }
}
