package ru.tandser.polling.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import ru.tandser.polling.repository.AbstractRepositoryTest;
import ru.tandser.polling.repository.UserRepository;

public class DataJpaUserRepositoryTest extends AbstractRepositoryTest {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}