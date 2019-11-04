package ru.itis.long_polling.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.long_polling.model.Token;
import ru.itis.long_polling.model.User;
import ru.itis.long_polling.repositories.TokensRepository;
import ru.itis.long_polling.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TokensRepository tokensRepository;

   public void saveUser (User user){
       userRepository.saveAndFlush(user);

   }

   public User getUserByLogin(String login){
       return userRepository.findFirstByLoginIgnoreCase(login).get();
   }

   public Boolean thisUser(String token, String login){
       Token token1= tokensRepository.findFirstByValue(token).get();
       User user = token1.getUser();
       int i = 0;
       return user.getLogin().equals(login);
   }
}
