package ru.tandser.polling.repository.predicate;

import com.querydsl.core.types.Predicate;
import ru.tandser.polling.domain.QVote;

public class VotePredicates {

    private VotePredicates() {}

    public static Predicate whereId(int id) {
        return QVote.vote.id.eq(id);
    }
}