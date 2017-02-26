package ru.tandser.polling.repository.predicate;

import com.querydsl.core.types.Predicate;
import ru.tandser.polling.domain.QMenu;

public class MenuPredicates {

    private MenuPredicates() {}

    public static Predicate whereId(int id) {
        return QMenu.menu.id.eq(id);
    }
}