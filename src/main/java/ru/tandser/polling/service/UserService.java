package ru.tandser.polling.service;

import ru.tandser.polling.domain.User;

import java.util.List;

public interface UserService {

    User get(int id);

    List<User> getAll();

    User getWithDetails(int id);

    void remove(int id);

    User save(User user);

    void update(User user);

    void toggle(int id, boolean state);
}