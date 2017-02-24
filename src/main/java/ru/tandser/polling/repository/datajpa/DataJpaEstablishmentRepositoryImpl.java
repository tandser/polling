package ru.tandser.polling.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.tandser.polling.domain.Establishment;
import ru.tandser.polling.repository.EstablishmentRepository;

import java.util.List;

@Repository
public class DataJpaEstablishmentRepositoryImpl implements EstablishmentRepository {

    private JpaEstablishmentRepository establishmentRepository;

    @Autowired
    public void setEstablishmentRepository(JpaEstablishmentRepository establishmentRepository) {
        this.establishmentRepository = establishmentRepository;
    }

    @Override
    public Establishment get(int id) {
        return establishmentRepository.findOne(id);
    }

    @Override
    public List<Establishment> getAll() {
        return establishmentRepository.findAll();
    }

    @Override
    public Establishment getByName(String name) {
        return establishmentRepository.findOneByNameIgnoreCase(name);
    }

    @Override
    public Establishment getWithDetails(int id) {
        return establishmentRepository.findOneWithDetails(id);
    }

    @Override
    public Establishment remove(int id) {
        List<Establishment> result = establishmentRepository.removeById(id);
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    @Transactional
    public Establishment put(Establishment establishment) {
        if (!establishment.isNew() && get(establishment.getId()) == null) {
            return null;
        }

        return establishmentRepository.save(establishment);
    }

    @Override
    public int toggle(int id, boolean state) {
        return establishmentRepository.setEnabled(id, state);
    }
}