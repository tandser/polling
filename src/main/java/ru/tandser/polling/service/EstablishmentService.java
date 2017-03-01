package ru.tandser.polling.service;

import ru.tandser.polling.domain.Establishment;

import java.util.List;

public interface EstablishmentService {

    Establishment get(int id);

    List<Establishment> getAll();

    Establishment getWithDetails(int id);

    void remove(int id);

    Establishment save(Establishment establishment);

    void update(Establishment establishment);

    void toggle(int id, boolean state);
}