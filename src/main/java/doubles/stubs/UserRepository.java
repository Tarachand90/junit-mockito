package doubles.stubs;

import doubles.dummy.User;

public interface UserRepository {
    User findById(int id);
}
