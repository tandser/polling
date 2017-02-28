package ru.tandser.polling.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.tandser.polling.domain.User;
import ru.tandser.polling.service.UserService;
import ru.tandser.polling.web.Principal;

import java.util.List;

import static ru.tandser.polling.util.Inspector.requireConsistency;
import static ru.tandser.polling.util.Inspector.requireNew;

public abstract class AbstractUserController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public User get(int id) {
        Principal principal = Principal.get();
        log.info("{}: .get({})", principal.getUsername(), id);
        return userService.get(id);
    }

    public List<User> getAll() {
        Principal principal = Principal.get();
        log.info("{}: .getAll()", principal.getUsername());
        return userService.getAll();
    }

    public User getWithDetails(int id) {
        Principal principal = Principal.get();
        log.info("{}: .getWithDetails({})", principal.getUsername(), id);
        return userService.getWithDetails(id);
    }

    public void remove(int id) {
        Principal principal = Principal.get();
        log.info("{}: .remove({})", principal.getUsername(), id);
        userService.remove(id);
    }

    public User save(User user) {
        requireNew(user);
        Principal principal = Principal.get();
        log.info("{}: .save({})", principal.getUsername(), user);
        return userService.save(user);
    }

    public void update(User user, int id) {
        requireConsistency(user, id);
        Principal principal = Principal.get();
        log.info("{}: .update({}, {})", principal.getUsername(), user, id);
        userService.update(user);
    }

    public void toggle(int id, boolean state) {
        Principal principal = Principal.get();
        log.info("{}: .toggle({}, {})", principal.getUsername(), id, state);
        userService.toggle(id, state);
    }
}