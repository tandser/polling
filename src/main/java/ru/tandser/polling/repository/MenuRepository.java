package ru.tandser.polling.repository;

import com.querydsl.core.types.Predicate;
import ru.tandser.polling.domain.Menu;

import java.util.List;

public interface MenuRepository {

    Menu get(Predicate predicate);

    List<Menu> getAll(Predicate predicate);

    Menu getWithDetails(int id);

    Menu remove(int id);

    Menu put(Menu menu);

    int toggle(int id, boolean state);
}