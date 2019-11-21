package ru.itis.long_polling.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.long_polling.dto.MessageDto;
import ru.itis.long_polling.model.Message;
import ru.itis.long_polling.repositories.MessageRepository;

@Service
public class MessagesService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserService userService;

    public List<Message> getMessages (){
        return messageRepository.findAll();
    }

    public void saveMessage (MessageDto message) {

        Message messageModel = Message.builder()
                .author(userService.getUserByLogin(message.getAuthorLogin()))
                .value(message.getText())
                .build();
        messageRepository.saveAndFlush(messageModel);
    }

    public List<MessageDto> getFirstFiveMessages (){

        List<Message> messages = messageRepository.findLast();
        List<MessageDto> messageDtos = new ArrayList<>();

        for (int i = messages.size() - 1; i >= 0; i--  ) {
            MessageDto messageDto = MessageDto.builder()
                    .authorLogin(messages.get(i).getAuthor().getLogin())
                    .text(messages.get(i).getValue())
                    .build();
            messageDtos.add(messageDto);
        }
        return messageDtos;
    }
}
