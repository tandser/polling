package ru.tandser.polling;

import ru.tandser.polling.domain.User;
import ru.tandser.polling.util.Matcher;

import java.util.Objects;

import static java.lang.Boolean.TRUE;
import static java.time.LocalDateTime.now;
import static ru.tandser.polling.domain.User.Role.ADMIN;
import static ru.tandser.polling.domain.User.Role.USER;

public class UserTestData {

    public static User admin           = new User(1,    "Lynn Douglas", "l.douglas@gmail.com", "Mr01LRc", ADMIN, null, null,  TRUE, 0);
    public static User user            = new User(2,    "Scott Welch",  "s.welch@gmail.com",   "Izhyw29", USER,  null, null,  TRUE, 0);
    public static User newUser         = new User(null, "Ralph Bass",   "r.bass@gmail.com",    "9Mn5Z6x", USER,  null, now(), TRUE, 0);
    public static User updatedUser     = new User(2,    "Scott Welch",  "s.welch@gmail.com",   "k58NwVe", USER,  null, now(), TRUE, 0);
    public static User nonExistentUser = new User(3,    "Arnold Shaw",  "a.shaw@gmail.com",    "gVw4WrY", USER,  null, null,  TRUE, 0);
    public static User conflictedUser  = new User(1,    "Lynn Douglas", "l.douglas@gmail.com", "bEW9feW", ADMIN, null, now(), TRUE, 1);
    public static User duplicatedUser  = new User(null, "Steven Welch", "s.welch@gmail.com",   "Y9rpqov", USER,  null, now(), TRUE, 0);

    public static final Matcher<User> USER_MATCHER = new Matcher<>(User.class, (expected, actual) ->
            expected == actual || (Objects.equals(expected.getName(),    actual.getName())  &&
                                   Objects.equals(expected.getEmail(),   actual.getEmail()) &&
                                   Objects.equals(expected.getRole(),    actual.getRole())  &&
                                   Objects.equals(expected.getEnabled(), actual.getEnabled())));

    private UserTestData() {}
}