package doubles.stubs;

import doubles.dummy.User;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUserName(int userId) {
        User user = userRepository.findById(userId);
        return user == null ? "Unknow" : user.getName();
    }
}
