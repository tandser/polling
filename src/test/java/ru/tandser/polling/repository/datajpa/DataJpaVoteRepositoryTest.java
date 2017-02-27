package ru.tandser.polling.repository.datajpa;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.tandser.polling.domain.Vote;
import ru.tandser.polling.repository.AbstractRepositoryTest;
import ru.tandser.polling.repository.VoteRepository;

import java.util.Arrays;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static ru.tandser.polling.MenuTestData.MENU_MATCHER;
import static ru.tandser.polling.MenuTestData.menu1;
import static ru.tandser.polling.UserTestData.USER_MATCHER;
import static ru.tandser.polling.UserTestData.user;
import static ru.tandser.polling.VoteTestData.*;
import static ru.tandser.polling.repository.predicate.VotePredicates.whereId;

public class DataJpaVoteRepositoryTest extends AbstractRepositoryTest {

    private VoteRepository voteRepository;

    @Autowired
    public void setVoteRepository(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    @Test
    public void testGet() {
        assertNull(voteRepository.get(whereId(nonExistentVote.getId())));

        assertTrue(VOTE_MATCHER.equals(vote1, voteRepository.get(whereId(vote1.getId()))));
        assertTrue(VOTE_MATCHER.equals(vote2, voteRepository.get(whereId(vote2.getId()))));
        assertTrue(VOTE_MATCHER.equals(vote3, voteRepository.get(whereId(vote3.getId()))));
    }

    @Test
    public void testGetAll() {
        assertTrue(VOTE_MATCHER.equals(Arrays.asList(vote1, vote2, vote3), voteRepository.getAll(null)));
    }

    @Test
    public void testGetWithDetails() {
        Vote voteWithDetails = voteRepository.getWithDetails(vote1.getId());
        assertTrue(MENU_MATCHER.equals(menu1, voteWithDetails.getMenu()));
        assertTrue(USER_MATCHER.equals(user,  voteWithDetails.getUser()));
    }

    @Test
    public void testRemove() {
        assertNull(voteRepository.remove(nonExistentVote.getId()));
        assertTrue(VOTE_MATCHER.equals(vote1, voteRepository.remove(vote1.getId())));
        assertTrue(VOTE_MATCHER.equals(Arrays.asList(vote2, vote3), voteRepository.getAll(null)));
    }

    @Test
    public void testPut() {
        assertNull(voteRepository.put(nonExistentVote));

        assertTrue(VOTE_MATCHER.equals(newVote, voteRepository.put(newVote)));
        assertTrue(VOTE_MATCHER.equals(newVote, voteRepository.get(whereId(newVote.getId()))));

        newVote.setId(null);

        assertTrue(VOTE_MATCHER.equals(updatedVote, voteRepository.put(updatedVote)));
        assertTrue(VOTE_MATCHER.equals(updatedVote, voteRepository.get(whereId(updatedVote.getId()))));
    }


}