package ru.itis.long_polling;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.itis.long_polling.model.Message;
import ru.itis.long_polling.model.Token;
import ru.itis.long_polling.model.User;
import ru.itis.long_polling.repositories.TokensRepository;
import ru.itis.long_polling.repositories.UserRepository;
import ru.itis.long_polling.services.MessagesService;
import ru.itis.long_polling.services.UserService;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LongPollingApplicationTests {
    @Autowired
    MessagesService messagesService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TokensRepository tokensRepository;

    @Test
    public void contextLoads() {
        Token token = tokensRepository.findFirstByValue("b3bb0cba-b13d-4ea9-990a-86e0b3edd36c").get();
       User user = userRepository.findOneByTokens(token).get();
       int i = 0;
    }

}
