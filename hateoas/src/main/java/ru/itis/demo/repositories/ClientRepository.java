package ru.itis.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import ru.itis.demo.models.Client;

public interface ClientRepository extends JpaRepository <Client, Long>{

    @RestResource(path = "registration", rel = "registration")
    @Override
    <S extends Client> S save(S s);
}
