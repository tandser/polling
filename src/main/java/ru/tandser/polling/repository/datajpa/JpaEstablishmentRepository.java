package ru.tandser.polling.repository.datajpa;

import org.springframework.data.jpa.repository.*;
import org.springframework.transaction.annotation.Transactional;
import ru.tandser.polling.domain.Establishment;

import java.util.List;

@Transactional(readOnly = true)
public interface JpaEstablishmentRepository extends JpaRepository<Establishment, Integer> {

    Establishment findOneByName(String name);

    @EntityGraph(Establishment.WITH_MENUS)
    @Query("SELECT e FROM Establishment AS e WHERE e.id = ?1")
    Establishment findOneWithMenus(int id);

    @Transactional
    List<Establishment> removeById(int id);

    @Transactional
    @Modifying
    @Query("UPDATE Establishment AS e SET e.enabled = ?2 WHERE e.id = ?1")
    int setEnabled(int id, boolean state);
}