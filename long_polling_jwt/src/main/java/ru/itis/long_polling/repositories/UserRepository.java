package ru.itis.long_polling.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.long_polling.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    <S extends User> S saveAndFlush(S s);

    Optional<User> findFirstByLoginIgnoreCase(String login);

}
