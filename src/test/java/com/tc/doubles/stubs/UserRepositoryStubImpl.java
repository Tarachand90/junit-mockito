package com.tc.doubles.stubs;

import doubles.dummy.User;
import doubles.stubs.UserRepository;

public class UserRepositoryStubImpl implements UserRepository {
    @Override
    public User findById(int id) {
        if(id == 1) {
            return new User(id, "Deba");
        }
        return new User(id, "Unknown");
    }
}
