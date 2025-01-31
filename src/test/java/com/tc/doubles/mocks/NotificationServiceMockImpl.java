package com.tc.doubles.mocks;

import doubles.dummy.User;
import doubles.spy.NotificationService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NotificationServiceMockImpl implements NotificationService {

    int times = 0;
    User user = null;
    String message = null;

    public void sendEmail(User user, String message) {
        times++;
        this.user = user;
        this.message = message;
    }

    public void verify(User user, String message, int times) {
        assertEquals(this.times, times);
        assertTrue(this.user.equals(user));
        assertTrue(this.message.equals(message));
    }
}
