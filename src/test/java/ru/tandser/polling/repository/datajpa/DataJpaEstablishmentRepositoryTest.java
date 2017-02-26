package ru.tandser.polling.repository.datajpa;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import ru.tandser.polling.repository.AbstractRepositoryTest;
import ru.tandser.polling.repository.EstablishmentRepository;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;
import static ru.tandser.polling.EstablishmentTestData.*;
import static ru.tandser.polling.MenuTestData.*;
import static ru.tandser.polling.repository.predicate.EstablishmentPredicates.whereId;

public class DataJpaEstablishmentRepositoryTest extends AbstractRepositoryTest {

    private EstablishmentRepository establishmentRepository;

    @Autowired
    public void setEstablishmentRepository(EstablishmentRepository establishmentRepository) {
        this.establishmentRepository = establishmentRepository;
    }

    @Test
    public void testGet() {
        assertNull(establishmentRepository.get(whereId(nonExistentEstablishment.getId())));

        assertTrue(ESTABLISHMENT_MATCHER.equals(establishment1, establishmentRepository.get(whereId(establishment1.getId()))));
        assertTrue(ESTABLISHMENT_MATCHER.equals(establishment2, establishmentRepository.get(whereId(establishment2.getId()))));
        assertTrue(ESTABLISHMENT_MATCHER.equals(establishment3, establishmentRepository.get(whereId(establishment3.getId()))));
        assertTrue(ESTABLISHMENT_MATCHER.equals(establishment4, establishmentRepository.get(whereId(establishment4.getId()))));
    }

    @Test
    public void testGetAll() {
        assertTrue(ESTABLISHMENT_MATCHER.equals(Arrays.asList(establishment1, establishment2, establishment3, establishment4), establishmentRepository.getAll(null)));
    }

    @Test
    public void testGetWithDetails() {
        assertTrue(MENU_MATCHER.equals(Collections.singletonList(menu1), establishmentRepository.getWithDetails(establishment1.getId()).getMenus()));
        assertTrue(MENU_MATCHER.equals(Collections.singletonList(menu2), establishmentRepository.getWithDetails(establishment2.getId()).getMenus()));
        assertTrue(MENU_MATCHER.equals(Collections.singletonList(menu3), establishmentRepository.getWithDetails(establishment3.getId()).getMenus()));
        assertTrue(MENU_MATCHER.equals(Collections.singletonList(menu4), establishmentRepository.getWithDetails(establishment4.getId()).getMenus()));
    }

    @Test
    public void testRemove() {
        assertNull(establishmentRepository.remove(nonExistentEstablishment.getId()));
        assertTrue(ESTABLISHMENT_MATCHER.equals(establishment1, establishmentRepository.remove(establishment1.getId())));
        assertTrue(ESTABLISHMENT_MATCHER.equals(Arrays.asList(establishment2, establishment3, establishment4), establishmentRepository.getAll(null)));
    }

    @Test
    public void testPut() {
        assertNull(establishmentRepository.put(nonExistentEstablishment));

        assertTrue(ESTABLISHMENT_MATCHER.equals(newEstablishment, establishmentRepository.put(newEstablishment)));
        assertTrue(ESTABLISHMENT_MATCHER.equals(newEstablishment, establishmentRepository.get(whereId(newEstablishment.getId()))));

        newEstablishment.setId(null);

        assertTrue(ESTABLISHMENT_MATCHER.equals(updatedEstablishment, establishmentRepository.put(updatedEstablishment)));
        assertTrue(ESTABLISHMENT_MATCHER.equals(updatedEstablishment, establishmentRepository.get(whereId(updatedEstablishment.getId()))));
    }

    @Test
    public void testPutConflictedEstablishment() {
        thrown.expect(ObjectOptimisticLockingFailureException.class);
        establishmentRepository.put(conflictedEstablishment);
    }

    @Test
    public void testPutDuplicatedEstablishment() {
        // TODO: назначить индексы
    }

    @Test
    public void testToggle() {
        assertEquals(0, establishmentRepository.toggle(nonExistentEstablishment.getId(), false));

        assertEquals(1, establishmentRepository.toggle(establishment1.getId(), false));
        assertFalse(establishmentRepository.get(whereId(establishment1.getId())).getEnabled());

        assertEquals(1, establishmentRepository.toggle(establishment1.getId(), true));
        assertTrue(establishmentRepository.get(whereId(establishment1.getId())).getEnabled());
    }
}