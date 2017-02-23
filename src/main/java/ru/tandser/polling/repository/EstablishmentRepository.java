package ru.tandser.polling.repository;

import ru.tandser.polling.domain.Establishment;

import java.util.List;

public interface EstablishmentRepository {

    Establishment get(int id);

    List<Establishment> getAll();

    Establishment getByName(String name);

    Establishment getWithDetails(int id);

    Establishment remove(int id);

    Establishment put(Establishment establishment);

    int toggle(int id, boolean state);
}