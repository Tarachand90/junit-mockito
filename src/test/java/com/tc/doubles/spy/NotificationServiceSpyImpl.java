package com.tc.doubles.spy;

import com.tc.doubles.dummy.User;

public class NotificationServiceSpyImpl implements NotificationService {

    private int times = 0;
    private User user = null;
    private String message = null;

    @Override
    public void sendEmail(User user, String message) {
       times++;
       this.user = user;
       this.message = message;
    }

    public int getTimes() {
        return times;
    }

    public boolean calledWith(User user, String message) {
        return this.user.equals(user) && this.message.equals(message);
    }

}
