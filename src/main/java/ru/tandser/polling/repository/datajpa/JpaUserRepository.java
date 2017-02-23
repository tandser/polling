package ru.tandser.polling.repository.datajpa;

import org.springframework.data.jpa.repository.*;
import org.springframework.transaction.annotation.Transactional;
import ru.tandser.polling.domain.User;

import java.util.List;

@Transactional(readOnly = true)
public interface JpaUserRepository extends JpaRepository<User, Integer> {

    User findOneByEmail(String email);

    @EntityGraph(User.WITH_VOTES)
    @Query("SELECT u FROM User AS u WHERE u.id = ?1")
    User findOneWithVotes(int id);

    @Transactional
    List<User> removeById(int id);

    @Transactional
    @Modifying
    @Query("UPDATE User AS u SET u.enabled = ?2 WHERE u.id = ?1")
    int setEnabled(int id, boolean state);
}