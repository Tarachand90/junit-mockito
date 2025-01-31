package doubles.spy;

import doubles.dummy.User;

public interface NotificationService {
    void sendEmail(User user, String message);
}
