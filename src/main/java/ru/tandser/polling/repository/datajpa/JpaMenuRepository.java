package ru.tandser.polling.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.tandser.polling.domain.Menu;

import java.util.List;

@Transactional(readOnly = true)
public interface JpaMenuRepository extends JpaRepository<Menu, Integer> {

    List<Menu> findByEnabled(boolean state);

}