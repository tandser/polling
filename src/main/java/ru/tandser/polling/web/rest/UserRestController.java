package ru.tandser.polling.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tandser.polling.domain.User;
import ru.tandser.polling.web.controller.AbstractUserController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(UserRestController.REST_PATH)
public class UserRestController extends AbstractUserController {

    public static final String REST_PATH = "/rest/users";

    @Override
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public User get(@PathVariable int id) {
        return super.get(id);
    }
}