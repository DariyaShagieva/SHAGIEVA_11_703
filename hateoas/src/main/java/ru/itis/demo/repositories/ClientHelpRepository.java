package ru.itis.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.demo.models.ClientsHelp;

public interface ClientHelpRepository extends JpaRepository<ClientsHelp, Long> {
}
