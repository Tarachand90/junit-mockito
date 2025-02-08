package com.tc.mockito.behaviors;

public class ServiceImpl implements Service{

    @Override
    public String getMessage() {
        return "Hello";
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public boolean isActive() {
        return true;
    }
}
