package ru.tandser.polling.repository;

import ru.tandser.polling.domain.Menu;

import java.util.List;

public interface MenuRepository {

    Menu get(int id);

    List<Menu> getAll();

    List<Menu> getByEnabled(boolean state);

    Menu getWithDetails(int id);

    Menu remove(int id);

    Menu put(Menu menu);

    int toggle(int id, boolean state);
}