package ru.itis.long_polling.repositories;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.long_polling.model.Message;
import ru.itis.long_polling.model.User;

import java.util.List;


public interface MessageRepository extends JpaRepository<Message, Long> {
    @Override
    List<Message> findAll();

    @Override
    <S extends Message> S saveAndFlush(S s);

    @Query(nativeQuery = true, value = "Select * from messages  ORDER BY messageid DESC limit 5")
    List<Message> findLast();

}
