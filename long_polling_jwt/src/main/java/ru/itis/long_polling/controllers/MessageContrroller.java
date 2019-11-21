package ru.itis.long_polling.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.itis.long_polling.dto.MessageDto;
import ru.itis.long_polling.services.MessagesService;

@RestController
public class MessageContrroller {
    private final Map<String, List<MessageDto>> messages = new HashMap<>();

    @Autowired
    MessagesService messagesService;

    @PostMapping("/messages")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Object> receiveMessage(@RequestBody MessageDto message,@RequestHeader("AUTH") String auth) {
        if (!messages.containsKey(auth)) {
            messages.put(auth, new ArrayList<>());
        }
        if(!message.getHiMessage()){
            messagesService.saveMessage(message);
        }else System.err.println(message.getText());
        for (List<MessageDto> pageMessages : messages.values()) {
            synchronized (pageMessages) {
                pageMessages.add(message);
                pageMessages.notifyAll();
            }
        }
        return ResponseEntity.ok().build();
    }

    @SneakyThrows
    @GetMapping("/messages")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<MessageDto>> getMessagesForPage(@RequestHeader("AUTH") String auth) {
        synchronized (messages.get(auth)) {
            if (messages.get(auth).isEmpty()) {
                messages.get(auth).wait();
            }
            System.out.println("get");
            List<MessageDto> response = new ArrayList<>(messages.get(auth));
            messages.get(auth).clear();
            return ResponseEntity.ok(response);
        }
    }
}
