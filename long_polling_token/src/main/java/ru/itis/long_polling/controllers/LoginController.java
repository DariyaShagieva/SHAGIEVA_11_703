package ru.itis.long_polling.controllers;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import ru.itis.long_polling.dto.LoginDto;
import ru.itis.long_polling.dto.TokenDto;
import ru.itis.long_polling.forms.SignUpForm;
import ru.itis.long_polling.repositories.UserRepository;
import ru.itis.long_polling.services.LoginService;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;


@RestController
public class LoginController {

    @Autowired
    private LoginService service;

    @PostMapping("/login")
    @PreAuthorize("permitAll()")
    public ResponseEntity<TokenDto> login(@RequestBody LoginDto loginData) {
        return ResponseEntity.ok(service.login(loginData));
    }


    @PostMapping("/signUp")
    @PreAuthorize("permitAll()")
    public ResponseEntity signUp(@RequestBody SignUpForm signUpForm){
        System.out.println(signUpForm.getLogin() + " " + signUpForm.getPassword());
        service.signUp(signUpForm);
        return ResponseEntity.ok().build();
    }

}