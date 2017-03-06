package ru.tandser.polling.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.tandser.polling.domain.Menu;
import ru.tandser.polling.service.MenuService;
import ru.tandser.polling.web.Principal;

public abstract class AbstractMenuController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private MenuService menuService;

    @Autowired
    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }

    public Menu get(int id) {
        Principal principal = Principal.get();
        log.info("{}: .get({})", principal.getUsername(), id);
        return menuService.get(id);
    }

    // TODO: доработать
}