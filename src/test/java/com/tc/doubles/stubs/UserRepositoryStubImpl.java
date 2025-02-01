package com.tc.doubles.stubs;

import com.tc.doubles.dummy.User;

public class UserRepositoryStubImpl implements UserRepository {
    @Override
    public User findById(int id) {
        if(id == 1) {
            return new User(id, "Deba");
        }
        return new User(id, "Unknown");
    }
}
