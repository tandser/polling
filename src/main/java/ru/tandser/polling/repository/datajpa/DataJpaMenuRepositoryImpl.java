package ru.tandser.polling.repository.datajpa;

import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.tandser.polling.domain.Menu;
import ru.tandser.polling.repository.MenuRepository;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static ru.tandser.polling.repository.predicate.MenuPredicates.whereId;

@Repository
public class DataJpaMenuRepositoryImpl implements MenuRepository {

    private JpaMenuRepository menuRepository;

    @Autowired
    public void setMenuRepository(JpaMenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public Menu get(Predicate predicate) {
        return predicate != null
                ? menuRepository.findOne(predicate)
                : null;
    }

    @Override
    public List<Menu> getAll(Predicate predicate) {
        return newArrayList(menuRepository.findAll(predicate));
    }

    @Override
    public Menu getWithDetails(int id) {
        return menuRepository.findOneWithDetails(id);
    }

    @Override
    public Menu remove(int id) {
        List<Menu> result = menuRepository.removeById(id);
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    @Transactional
    public Menu put(Menu menu) {
        if (!menu.isNew() && get(whereId(menu.getId())) == null) {
            return null;
        }

        return menuRepository.save(menu);
    }

    @Override
    public int toggle(int id, boolean state) {
        return menuRepository.setEnabled(id, state);
    }
}