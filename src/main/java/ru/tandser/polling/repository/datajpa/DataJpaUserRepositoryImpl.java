package ru.tandser.polling.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.tandser.polling.domain.User;
import ru.tandser.polling.repository.UserRepository;

import java.util.List;

@Repository
public class DataJpaUserRepositoryImpl implements UserRepository {

    private JpaUserRepository userRepository;

    @Autowired
    public void setUserRepository(JpaUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User get(int id) {
        return userRepository.findOne(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findOneByEmailIgnoreCase(email);
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
        if (!user.isNew() && get(user.getId()) == null) {
            return null;
        }

        return userRepository.save(user);
    }

    @Override
    public int toggle(int id, boolean state) {
        return userRepository.setEnabled(id, state);
    }
}