package ru.tandser.polling.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tandser.polling.domain.Establishment;
import ru.tandser.polling.repository.EstablishmentRepository;
import ru.tandser.polling.repository.predicate.EstablishmentPredicates;
import ru.tandser.polling.util.Inspector;

import java.util.List;

import static ru.tandser.polling.repository.predicate.EstablishmentPredicates.whereId;
import static ru.tandser.polling.util.Inspector.requireExist;

@Service
public class EstablishmentServiceImpl implements EstablishmentService {

    private EstablishmentRepository establishmentRepository;

    @Autowired
    public void setEstablishmentRepository(EstablishmentRepository establishmentRepository) {
        this.establishmentRepository = establishmentRepository;
    }

    @Override
    public Establishment get(int id) {
        return requireExist(establishmentRepository.get(whereId(id)));
    }

    @Override
    public List<Establishment> getAll() {
        return null;
    }

    @Override
    public Establishment getWithDetails(int id) {
        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public Establishment save(Establishment establishment) {
        return null;
    }

    @Override
    public void update(Establishment establishment) {

    }

    @Override
    public void toggle(int id, boolean state) {

    }
}