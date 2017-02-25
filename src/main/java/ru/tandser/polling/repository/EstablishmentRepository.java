package ru.tandser.polling.repository;

import com.querydsl.core.types.Predicate;
import ru.tandser.polling.domain.Establishment;

import java.util.List;

public interface EstablishmentRepository {

    Establishment get(Predicate predicate);

    List<Establishment> getAll(Predicate predicate);

    Establishment getWithDetails(int id);

    Establishment remove(int id);

    Establishment put(Establishment establishment);

    int toggle(int id, boolean state);
}