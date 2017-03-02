package ru.tandser.polling.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tandser.polling.domain.Menu;
import ru.tandser.polling.repository.MenuRepository;

import java.util.List;

import static ru.tandser.polling.repository.predicate.MenuPredicates.whereId;
import static ru.tandser.polling.util.Inspector.requireExist;
import static ru.tandser.polling.util.Inspector.requireUpdate;

@Service
public class MenuServiceImpl implements MenuService {

    private MenuRepository menuRepository;

    @Autowired
    public void setMenuRepository(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public Menu get(int id) {
        return requireExist(menuRepository.get(whereId(id)));
    }

    @Override
    public List<Menu> getAll() {
        return menuRepository.getAll(null);
    }

    @Override
    public Menu getWithDetails(int id) {
        return requireExist(menuRepository.getWithDetails(id));
    }

    @Override
    public void remove(int id) {
        requireExist(menuRepository.remove(id));
    }

    @Override
    public Menu save(Menu menu) {
        return menuRepository.put(menu);
    }

    @Override
    public void update(Menu menu) {
        requireExist(menuRepository.put(menu));
    }

    @Override
    public void toggle(int id, boolean state) {
        requireUpdate(menuRepository.toggle(id, state));
    }
}