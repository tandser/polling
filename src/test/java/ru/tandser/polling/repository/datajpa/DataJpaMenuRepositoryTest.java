package ru.tandser.polling.repository.datajpa;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import ru.tandser.polling.repository.AbstractRepositoryTest;
import ru.tandser.polling.repository.MenuRepository;

import java.util.Arrays;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static ru.tandser.polling.MenuTestData.*;
import static ru.tandser.polling.repository.predicate.MenuPredicates.whereId;

public class DataJpaMenuRepositoryTest extends AbstractRepositoryTest {

    private MenuRepository menuRepository;

    @Autowired
    public void setMenuRepository(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Test
    public void testGet() {
        assertNull(menuRepository.get(whereId(nonExistentMenu.getId())));

        assertTrue(MENU_MATCHER.equals(menu1, menuRepository.get(whereId(menu1.getId()))));
        assertTrue(MENU_MATCHER.equals(menu2, menuRepository.get(whereId(menu2.getId()))));
        assertTrue(MENU_MATCHER.equals(menu3, menuRepository.get(whereId(menu3.getId()))));
        assertTrue(MENU_MATCHER.equals(menu4, menuRepository.get(whereId(menu4.getId()))));
    }

    @Test
    public void testGetAll() {
        assertTrue(MENU_MATCHER.equals(Arrays.asList(menu1, menu2, menu3, menu4), menuRepository.getAll(null)));
    }

    @Test
    public void testGetWithDetails() {
        // TODO: дополнить после того, как появится matcher для Vote
    }

    @Test
    public void testRemove() {
        assertNull(menuRepository.remove(nonExistentMenu.getId()));
        assertTrue(MENU_MATCHER.equals(menu1, menuRepository.remove(menu1.getId())));
        assertTrue(MENU_MATCHER.equals(Arrays.asList(menu2, menu3, menu4), menuRepository.getAll(null)));
    }

    @Test
    public void testPut() {
        assertNull(menuRepository.put(nonExistentMenu));

        assertTrue(MENU_MATCHER.equals(newMenu, menuRepository.put(newMenu)));
        assertTrue(MENU_MATCHER.equals(newMenu, menuRepository.get(whereId(newMenu.getId()))));

        newMenu.setId(null);

        assertTrue(MENU_MATCHER.equals(updatedMenu, menuRepository.put(updatedMenu)));
        assertTrue(MENU_MATCHER.equals(updatedMenu, menuRepository.get(whereId(updatedMenu.getId()))));
    }

    @Test
    public void testPutConflictedMenu() {
        thrown.expect(ObjectOptimisticLockingFailureException.class);
        menuRepository.put(conflictedMenu);
    }
}