package ru.tandser.polling;

import ru.tandser.polling.domain.User;
import ru.tandser.polling.util.Matcher;

import java.util.Objects;

public class UserTestData {

    public static final Matcher<User> USER_MATCHER = new Matcher<>(User.class, (expected, actual) ->
            expected == actual || (Objects.equals(expected.getName(),  actual.getName())  &&
                                   Objects.equals(expected.getEmail(), actual.getEmail()) &&
                                   Objects.equals(expected.getRole(),  actual.getRole())));

}