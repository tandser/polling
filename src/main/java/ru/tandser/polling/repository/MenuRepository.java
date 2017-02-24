package ru.tandser.polling.repository;

import ru.tandser.polling.domain.Menu;

import java.util.List;

public interface MenuRepository {

    Menu get(int id);

    List<Menu> getAll();

    List<Menu> getByEnabled(boolean enabled);
}