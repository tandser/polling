package ru.tandser.polling.repository.datajpa;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.tandser.polling.repository.AbstractRepositoryTest;
import ru.tandser.polling.repository.EstablishmentRepository;

import static org.junit.Assert.assertTrue;
import static ru.tandser.polling.EstablishmentTestData.*;
import static ru.tandser.polling.repository.predicate.EstablishmentPredicates.whereId;

public class DataJpaEstablishmentRepositoryTest extends AbstractRepositoryTest {

    private EstablishmentRepository establishmentRepository;

    @Autowired
    public void setEstablishmentRepository(EstablishmentRepository establishmentRepository) {
        this.establishmentRepository = establishmentRepository;
    }

    @Test
    public void testGet() {
        assertTrue(ESTABLISHMENT_MATCHER.equals(establishment1, establishmentRepository.get(whereId(establishment1.getId()))));
        assertTrue(ESTABLISHMENT_MATCHER.equals(establishment2, establishmentRepository.get(whereId(establishment2.getId()))));
        assertTrue(ESTABLISHMENT_MATCHER.equals(establishment3, establishmentRepository.get(whereId(establishment3.getId()))));
        assertTrue(ESTABLISHMENT_MATCHER.equals(establishment4, establishmentRepository.get(whereId(establishment4.getId()))));
    }
}