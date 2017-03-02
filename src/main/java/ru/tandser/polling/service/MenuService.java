package ru.tandser.polling.service;

import ru.tandser.polling.domain.Menu;

import java.util.List;

public interface MenuService {

    Menu get(int id);

    List<Menu> getAll();

    Menu getWithDetails(int id);

    void remove(int id);

    Menu save(Menu menu);

    void update(Menu menu);

    void toggle(int id, boolean state);
}