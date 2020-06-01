package ru.itis.course_work.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.course_work.models.Breeder;

public interface BreederRepository extends JpaRepository<Breeder, Long> {

}
