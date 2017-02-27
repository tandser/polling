package ru.tandser.polling.repository.datajpa;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import ru.tandser.polling.repository.AbstractRepositoryTest;
import ru.tandser.polling.repository.UserRepository;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;
import static ru.tandser.polling.UserTestData.*;
import static ru.tandser.polling.VoteTestData.*;
import static ru.tandser.polling.repository.predicate.UserPredicates.whereEmail;
import static ru.tandser.polling.repository.predicate.UserPredicates.whereId;

public class DataJpaUserRepositoryTest extends AbstractRepositoryTest {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Test
    public void testGet() {
        assertNull(userRepository.get(whereId(nonExistentUser.getId())));

        assertTrue(USER_MATCHER.equals(admin, userRepository.get(whereId(admin.getId()))));
        assertTrue(USER_MATCHER.equals(user,  userRepository.get(whereId(user.getId()))));

        assertTrue(USER_MATCHER.equals(admin, userRepository.get(whereEmail(admin.getEmail()))));
        assertTrue(USER_MATCHER.equals(user,  userRepository.get(whereEmail(user.getEmail()))));
    }

    @Test
    public void testGetAll() {
        assertTrue(USER_MATCHER.equals(Arrays.asList(admin, user), userRepository.getAll(null)));
    }

    @Test
    public void testGetWithDetails() {
        assertTrue(VOTE_MATCHER.equals(Arrays.asList(vote1, vote2, vote3), userRepository.getWithDetails(user.getId()).getVotes()));
    }

    @Test
    public void testRemove() {
        assertNull(userRepository.remove(nonExistentUser.getId()));
        assertTrue(USER_MATCHER.equals(user, userRepository.remove(user.getId())));
        assertTrue(USER_MATCHER.equals(Collections.singletonList(admin), userRepository.getAll(null)));
    }

    @Test
    public void testPut() {
        assertNull(userRepository.put(nonExistentUser));

        assertTrue(USER_MATCHER.equals(newUser, userRepository.put(newUser)));
        assertTrue(USER_MATCHER.equals(newUser, userRepository.get(whereId(newUser.getId()))));

        newUser.setId(null);

        assertTrue(USER_MATCHER.equals(updatedUser, userRepository.put(updatedUser)));
        assertTrue(USER_MATCHER.equals(updatedUser, userRepository.get(whereId(updatedUser.getId()))));
    }

    @Test
    public void testPutConflictedUser() {
        thrown.expect(ObjectOptimisticLockingFailureException.class);
        userRepository.put(conflictedUser);
    }

    @Test
    public void testPutDuplicatedUser() {
        thrown.expect(DataIntegrityViolationException.class);
        userRepository.put(duplicatedUser);
    }

    @Test
    public void testToggle() {
        assertEquals(0, userRepository.toggle(nonExistentUser.getId(), false));

        assertEquals(1, userRepository.toggle(user.getId(), false));
        assertFalse(userRepository.get(whereId(user.getId())).getEnabled());

        assertEquals(1, userRepository.toggle(user.getId(), true));
        assertTrue(userRepository.get(whereId(user.getId())).getEnabled());
    }
}