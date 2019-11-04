package ru.itis.long_polling.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.long_polling.dto.LoginDto;
import ru.itis.long_polling.dto.TokenDto;
import ru.itis.long_polling.forms.SignUpForm;
import ru.itis.long_polling.model.Role;
import ru.itis.long_polling.model.Token;
import ru.itis.long_polling.model.User;
import ru.itis.long_polling.repositories.TokensRepository;
import ru.itis.long_polling.repositories.UserRepository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class LoginService {
    @Autowired
    private TokensRepository tokensRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    @Value("${token.expired}")
    private Integer expiredSecondsForToken;

    public TokenDto login(LoginDto loginData) {
        Optional<User> userCandidate = userRepository.findFirstByLoginIgnoreCase(loginData.getLogin());

        if (userCandidate.isPresent()) {
            User user = userCandidate.get();
            if (encoder.matches(loginData.getPassword(), user.getPasswordHash())) {
                String value = UUID.randomUUID().toString();
                Token token = Token.builder()
                        .createdAt(LocalDateTime.now())
                        .expiredDateTime(LocalDateTime.now().plusSeconds(expiredSecondsForToken))
                        .value(value)
                        .user(user)
                        .build();
                tokensRepository.saveAndFlush(token);
                return TokenDto.from(value);
            }
        } throw new BadCredentialsException("Incorrect login or password");
    }

    public void signUp(SignUpForm form) {
        User user = User.builder()
                .login(form.getLogin())
                .passwordHash(encoder.encode(form.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.saveAndFlush(user);
    }
}
