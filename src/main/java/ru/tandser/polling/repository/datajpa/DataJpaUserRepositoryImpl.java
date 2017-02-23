package ru.tandser.polling.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getByEmail(String email) {
        return null;
    }

    @Override
    public User getWithVotes(int id) {
        return null;
    }

    @Override
    public User remove(int id) {
        return null;
    }

    @Override
    public User put(User user) {
        return null;
    }

    @Override
    public int toggle(int id, boolean state) {
        return 0;
    }
}