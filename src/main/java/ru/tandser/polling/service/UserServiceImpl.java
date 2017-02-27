package ru.tandser.polling.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.tandser.polling.domain.User;
import ru.tandser.polling.repository.UserRepository;
import ru.tandser.polling.web.Principal;

import java.util.List;

import static ru.tandser.polling.repository.predicate.UserPredicates.whereEmail;
import static ru.tandser.polling.repository.predicate.UserPredicates.whereId;
import static ru.tandser.polling.util.Inspector.requireExist;
import static ru.tandser.polling.util.Inspector.requireUpdate;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private UserRepository  userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User get(int id) {
        return requireExist(userRepository.get(whereId(id)));
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll(null);
    }

    @Override
    public User getWithDetails(int id) {
        return requireExist(userRepository.getWithDetails(id));
    }

    @Override
    public void remove(int id) {
        requireExist(userRepository.remove(id));
    }

    @Override
    public User save(User user) {
        user.prepare(passwordEncoder);
        return userRepository.put(user);
    }

    @Override
    public void update(User user) {
        user.prepare(passwordEncoder);
        requireExist(userRepository.put(user));
    }

    @Override
    public void toggle(int id, boolean state) {
        requireUpdate(userRepository.toggle(id, state));
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.get(whereEmail(email));

        if (user == null) {
            throw new UsernameNotFoundException(email);
        }

        return new Principal(user);
    }
}