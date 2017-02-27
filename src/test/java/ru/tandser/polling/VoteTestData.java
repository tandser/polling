package ru.tandser.polling;

import ru.tandser.polling.domain.Vote;
import ru.tandser.polling.util.Matcher;

import java.util.Objects;

import static java.lang.Boolean.TRUE;
import static java.time.LocalDateTime.now;
import static ru.tandser.polling.MenuTestData.*;
import static ru.tandser.polling.UserTestData.user;

public class VoteTestData {

    public static Vote vote1           = new Vote(1,    menu1, user, 1, null,  TRUE, 0);
    public static Vote vote2           = new Vote(2,    menu2, user, 2, null,  TRUE, 0);
    public static Vote vote3           = new Vote(3,    menu3, user, 3, null,  TRUE, 0);
    public static Vote newVote         = new Vote(null, menu4, user, 4, now(), TRUE, 0);
    public static Vote updatedVote     = new Vote(1,    menu1, user, 2, now(), TRUE, 0);
    public static Vote nonExistentVote = new Vote(0,    menu1, user, 5, null,  TRUE, 0);
    public static Vote conflictedVote  = new Vote(2,    menu2, user, 3, now(), TRUE, 1);
    public static Vote duplicatedVote  = new Vote(null, menu1, user, 1, now(), TRUE, 0);

    public static final Matcher<Vote> VOTE_MATCHER = new Matcher<>(Vote.class, (expected, actual) ->
            expected == actual || (Objects.equals(expected.getRating(),  actual.getRating())  &&
                                   Objects.equals(expected.getEnabled(), actual.getEnabled())));
}