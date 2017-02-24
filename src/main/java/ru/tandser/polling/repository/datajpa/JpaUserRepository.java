package ru.tandser.polling.repository.datajpa;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.tandser.polling.domain.User;

import java.util.List;

@Transactional(readOnly = true)
public interface JpaUserRepository extends JpaRepository<User, Integer> {

    User findOneByEmailIgnoreCase(String email);

    @EntityGraph(User.WITH_DETAILS)
    @Query("SELECT u FROM User AS u WHERE u.id = ?1")
    User findOneWithDetails(int id);

    @Transactional
    List<User> removeById(int id);

    @Transactional
    @Modifying
    @Query("UPDATE User AS u SET u.enabled = ?2 WHERE u.id = ?1")
    int setEnabled(int id, boolean state);
}