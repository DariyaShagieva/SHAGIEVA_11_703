package ru.itis.long_polling.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.token.TokenService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.long_polling.dto.MessageDto;
import ru.itis.long_polling.model.Message;
import ru.itis.long_polling.model.User;
import ru.itis.long_polling.security.details.UserDetailsImpl;
import ru.itis.long_polling.services.LoginService;
import ru.itis.long_polling.services.MessagesService;
import ru.itis.long_polling.services.UserService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
public class ChatController {

    @Autowired
    UserService userService;

    @Autowired
    LoginService loginService;

    @Autowired
    MessagesService messagesService;

    @GetMapping("/chat/{user}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<MessageDto>> getChatPage(Model model, @RequestHeader("AUTH") String auth, @PathVariable("user") String login) {
        if (userService.thisUser(login)) {
            List<MessageDto> messages = messagesService.getFirstFiveMessages();
            return ResponseEntity.ok(messages);
        }
        return ResponseEntity.notFound().build();


    }


}
