package ru.tandser.polling.repository;

import ru.tandser.polling.domain.User;

import java.util.List;

public interface UserRepository {

    User get(int id);

    List<User> getAll();

    User getByEmail(String email);

    User getWithVotes(int id);

    User remove(int id);

    User put(User user);

    int toggle(int id, boolean state);
}