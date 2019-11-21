package ru.itis.long_polling.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.long_polling.dto.LoginDto;
import ru.itis.long_polling.dto.TokenDto;
import ru.itis.long_polling.forms.SignUpForm;
import ru.itis.long_polling.model.Role;
import ru.itis.long_polling.model.User;
import ru.itis.long_polling.repositories.UserRepository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class LoginService {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    @Value("${jwt.secret}")
    private String jwtSecret;



    public TokenDto login(LoginDto loginData) {
        Optional<User> userCandidate = userRepository.findFirstByLoginIgnoreCase(loginData.getLogin());

        if (userCandidate.isPresent()) {
            User user = userCandidate.get();
            if (encoder.matches(loginData.getPassword(), user.getPasswordHash())) {
                return TokenDto.builder()
                        .value(getJwtToken(user))
                        .build();
            }
        } throw new BadCredentialsException("Incorrect login or password");
    }

    private String getJwtToken(User user){
        return Jwts.builder()
                .claim("login", user.getLogin())
                .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
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
