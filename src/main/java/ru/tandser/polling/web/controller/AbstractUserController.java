package ru.tandser.polling.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.tandser.polling.domain.User;
import ru.tandser.polling.service.UserService;
import ru.tandser.polling.web.Principal;

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
}