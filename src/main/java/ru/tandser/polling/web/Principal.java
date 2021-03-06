package ru.tandser.polling.web;

import org.springframework.security.core.context.SecurityContextHolder;
import ru.tandser.polling.domain.User;

import java.util.Collections;

public class Principal extends org.springframework.security.core.userdetails.User {

    private int id;

    public Principal(User user) {
        super(user.getEmail(), user.getPassword(), user.getEnabled(), true, true, true,
                Collections.singletonList(user.getRole()));
        id = user.getId();
    }

    public static Principal get() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal instanceof Principal
                ? (Principal) principal
                : null;
    }

    public int getId() {
        return id;
    }
}