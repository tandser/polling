package ru.tandser.polling;

import org.springframework.util.ResourceUtils;
import ru.tandser.polling.domain.User;
import ru.tandser.polling.util.Matcher;
import ru.tandser.polling.web.json.JsonConverter;

import java.util.Iterator;
import java.util.Objects;

public class UserTestData {

    public static User admin;
    public static User user;
    public static User newUser;
    public static User updatedUser;
    public static User nonExistentUser;
    public static User conflictedUser;
    public static User duplicatedUser;

    public static final Matcher<User> USER_MATCHER = new Matcher<>(User.class, (expected, actual) ->
            expected == actual || (Objects.equals(expected.getName(),    actual.getName())  &&
                                   Objects.equals(expected.getEmail(),   actual.getEmail()) &&
                                   Objects.equals(expected.getRole(),    actual.getRole())  &&
                                   Objects.equals(expected.getEnabled(), actual.getEnabled())));

    private UserTestData() {}

    public static void loadMocks() throws Exception {
        Iterator<User> mocks = JsonConverter.fromJsonToList(ResourceUtils.getFile("classpath:mock/users.json"), User.class).iterator();

        admin           = mocks.next();
        user            = mocks.next();
        newUser         = mocks.next();
        updatedUser     = mocks.next();
        nonExistentUser = mocks.next();
        conflictedUser  = mocks.next();
        duplicatedUser  = mocks.next();
    }
}