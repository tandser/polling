package ru.tandser.polling.repository.datajpa;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.transaction.annotation.Transactional;
import ru.tandser.polling.domain.Menu;

import java.util.List;

@Transactional(readOnly = true)
public interface JpaMenuRepository extends JpaRepository<Menu, Integer>, QueryDslPredicateExecutor<Menu> {

    @EntityGraph(Menu.WITH_DETAILS)
    @Query("SELECT m FROM Menu AS m WHERE m.id = ?1")
    Menu findOneWithDetails(int id);

    @Transactional
    List<Menu> removeById(int id);

    @Transactional
    @Modifying
    @Query("UPDATE Menu AS m SET m.enabled = ?2 WHERE m.id = ?1")
    int setEnabled(int id, boolean state);
}