package ru.itis.long_polling;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ru.itis.long_polling.model.User;
import ru.itis.long_polling.repositories.UserRepository;
import ru.itis.long_polling.services.MessagesService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LongPollingApplicationTests {
    @Autowired
    MessagesService messagesService;

    @Autowired
    UserRepository userRepository;


}
