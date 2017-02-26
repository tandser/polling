package ru.tandser.polling.repository.datajpa;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.transaction.annotation.Transactional;
import ru.tandser.polling.domain.Vote;

import java.util.List;

@Transactional(readOnly = true)
public interface JpaVoteRepository extends JpaRepository<Vote, Integer>, QueryDslPredicateExecutor<Vote> {

    @EntityGraph(Vote.WITH_DETAILS)
    @Query("SELECT v FROM Vote AS v WHERE v.id = ?1")
    Vote findOneWithDetails(int id);

    @Transactional
    List<Vote> removeById(int id);

    @Transactional
    @Modifying
    @Query("UPDATE Vote AS v SET v.enabled = ?2 WHERE v.id = ?1")
    int setEnabled(int id, boolean state);
}