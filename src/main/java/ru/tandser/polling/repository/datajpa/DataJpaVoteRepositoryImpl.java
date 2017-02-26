package ru.tandser.polling.repository.datajpa;

import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.tandser.polling.domain.Vote;
import ru.tandser.polling.repository.VoteRepository;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static ru.tandser.polling.repository.predicate.VotePredicates.whereId;

@Repository
public class DataJpaVoteRepositoryImpl implements VoteRepository {

    private JpaVoteRepository voteRepository;

    @Autowired
    public void setVoteRepository(JpaVoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    @Override
    public Vote get(Predicate predicate) {
        return predicate != null
                ? voteRepository.findOne(predicate)
                : null;
    }

    @Override
    public List<Vote> getAll(Predicate predicate) {
        return newArrayList(voteRepository.findAll(predicate));
    }

    @Override
    public Vote getWithDetails(int id) {
        return voteRepository.findOneWithDetails(id);
    }

    @Override
    public Vote remove(int id) {
        List<Vote> result = voteRepository.removeById(id);
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    @Transactional
    public Vote put(Vote vote) {
        if (!vote.isNew() && get(whereId(vote.getId())) == null) {
            return null;
        }

        return voteRepository.save(vote);
    }

    @Override
    public int toggle(int id, boolean state) {
        return voteRepository.setEnabled(id, state);
    }
}