package ru.tandser.polling.repository;

import com.querydsl.core.types.Predicate;
import ru.tandser.polling.domain.User;

import java.util.List;

public interface UserRepository {

    User get(Predicate predicate);

    List<User> getAll(Predicate predicate);

    User getWithDetails(int id);

    User remove(int id);

    User put(User user);

    int toggle(int id, boolean state);
}