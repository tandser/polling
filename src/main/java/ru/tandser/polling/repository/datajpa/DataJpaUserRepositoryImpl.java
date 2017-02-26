package ru.tandser.polling.repository.datajpa;

import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.tandser.polling.domain.User;
import ru.tandser.polling.repository.UserRepository;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static ru.tandser.polling.repository.predicate.UserPredicates.whereId;

@Repository
public class DataJpaUserRepositoryImpl implements UserRepository {

    private JpaUserRepository userRepository;

    @Autowired
    public void setUserRepository(JpaUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User get(Predicate predicate) {
        return predicate != null
                ? userRepository.findOne(predicate)
                : null;
    }

    @Override
    public List<User> getAll(Predicate predicate) {
        return newArrayList(userRepository.findAll(predicate));
    }

    @Override
    public User getWithDetails(int id) {
        return userRepository.findOneWithDetails(id);
    }

    @Override
    public User remove(int id) {
        List<User> result = userRepository.removeById(id);
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    @Transactional
    public User put(User user) {
        if (!user.isNew() && get(whereId(user.getId())) == null) {
            return null;
        }

        return userRepository.save(user);
    }

    @Override
    public int toggle(int id, boolean state) {
        return userRepository.setEnabled(id, state);
    }
}