package com.tc.parametrized;

import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import java.util.stream.Stream;

public class LoginTestDataProvider implements ArgumentsProvider {
    @Override
    public Stream<Arguments> provideArguments(org.junit.jupiter.api.extension.ExtensionContext context) {
        return Stream.of(
                Arguments.of("user1", "password123", true),
                Arguments.of("admin", "admin@123", true),
                Arguments.of("guest", "guestPass", true),
                Arguments.of("user1", "wrongPass", false),
                Arguments.of("unknownUser", "password123", false)
        );
    }
}