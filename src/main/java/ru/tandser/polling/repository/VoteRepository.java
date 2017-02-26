package ru.tandser.polling.repository;

import com.querydsl.core.types.Predicate;
import ru.tandser.polling.domain.Vote;

import java.util.List;

public interface VoteRepository {

    Vote get(Predicate predicate);

    List<Vote> getAll(Predicate predicate);

    Vote getWithDetails(int id);

    Vote remove(int id);

    Vote put(Vote vote);

    int toggle(int id, boolean state);
}