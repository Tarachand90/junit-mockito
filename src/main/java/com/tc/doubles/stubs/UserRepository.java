package com.tc.doubles.stubs;

import com.tc.doubles.dummy.User;

public interface UserRepository {
    User findById(int id);
}
