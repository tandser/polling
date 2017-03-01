package ru.tandser.polling.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tandser.polling.domain.Establishment;
import ru.tandser.polling.repository.EstablishmentRepository;

import java.util.List;

import static ru.tandser.polling.repository.predicate.EstablishmentPredicates.whereId;
import static ru.tandser.polling.util.Inspector.requireExist;
import static ru.tandser.polling.util.Inspector.requireUpdate;

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
        return establishmentRepository.getAll(null);
    }

    @Override
    public Establishment getWithDetails(int id) {
        return requireExist(establishmentRepository.getWithDetails(id));
    }

    @Override
    public void remove(int id) {
        requireExist(establishmentRepository.remove(id));
    }

    @Override
    public Establishment save(Establishment establishment) {
        return establishmentRepository.put(establishment);
    }

    @Override
    public void update(Establishment establishment) {
        requireExist(establishmentRepository.put(establishment));
    }

    @Override
    public void toggle(int id, boolean state) {
        requireUpdate(establishmentRepository.toggle(id, state));
    }
}