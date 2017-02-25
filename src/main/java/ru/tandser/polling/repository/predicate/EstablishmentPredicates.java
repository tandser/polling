package ru.tandser.polling.repository.predicate;

import com.querydsl.core.types.Predicate;
import ru.tandser.polling.domain.QEstablishment;

public class EstablishmentPredicates {

    private EstablishmentPredicates() {}

    public static Predicate whereId(int id) {
        return QEstablishment.establishment.id.eq(id);
    }
}