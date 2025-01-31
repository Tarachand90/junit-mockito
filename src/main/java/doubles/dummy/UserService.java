package doubles.dummy;

public class UserService {

    private NotificationService notificationService;

    public UserService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public User createUser(int id, String name) {
        User user = new User(id, name);
        notificationService.sendNotification(user, "User created");
        return user;
    }
}
