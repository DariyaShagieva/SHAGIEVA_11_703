package ru.itis.long_polling.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.itis.long_polling.model.User;
import ru.itis.long_polling.repositories.UserRepository;
import ru.itis.long_polling.security.details.UserDetailsImpl;

import javax.persistence.EntityNotFoundException;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.saveAndFlush(user);

    }

    public User getUserByLogin(String login) {
        if (thisUser(login)) {
            return userRepository.findFirstByLoginIgnoreCase(login).get();
        }
        return null;
    }

    public boolean thisUser(String login) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ((UserDetailsImpl) authentication.getDetails()).getUser().getLogin().equals(login);

    }
}
