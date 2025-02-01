package com.tc.doubles.spy;

import com.tc.doubles.dummy.User;

public interface NotificationService {
    void sendEmail(User user, String message);
}
