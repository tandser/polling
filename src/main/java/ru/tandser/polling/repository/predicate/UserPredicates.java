package ru.tandser.polling.repository.predicate;

import com.querydsl.core.types.Predicate;
import ru.tandser.polling.domain.QUser;

public class UserPredicates {

    private UserPredicates() {}

    public static Predicate whereId(int id) {
        return QUser.user.id.eq(id);
    }

    public static Predicate whereEmail(String email) {
        return email != null
                ? QUser.user.email.equalsIgnoreCase(email)
                : null;
    }
}