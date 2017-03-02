package ru.tandser.polling.web.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tandser.polling.domain.Menu;
import ru.tandser.polling.web.controller.AbstractMenuController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(MenuRestController.REST_PATH)
public class MenuRestController extends AbstractMenuController {

    public static final String REST_PATH = "/rest/menus";

    @Override
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public Menu get(@PathVariable int id) {
        return super.get(id);
    }
}