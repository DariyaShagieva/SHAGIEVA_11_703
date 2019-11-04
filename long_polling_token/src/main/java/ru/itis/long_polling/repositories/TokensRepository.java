package ru.itis.long_polling.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.long_polling.model.Token;

import java.time.LocalDateTime;
import java.util.Optional;

public interface TokensRepository extends JpaRepository<Token, Long> {
    @Override
    <S extends Token> S saveAndFlush(S s);

    Optional<Token> findFirstByValue(String value);
    void deleteTokensByExpiredDateTimeBefore(LocalDateTime now);
}
