package com.tc.doubles.spy;

import com.tc.doubles.dummy.User;

public class UserService {

    private final NotificationService notificationService;

    public UserService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public User createUser(int id, String name) {
        User user = new User(id, name);
        notificationService.sendEmail(user, "Welcome!");
        return user;
    }
}
