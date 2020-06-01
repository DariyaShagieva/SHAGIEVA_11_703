package ru.itis.course_work.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import reactor.core.publisher.Flux;
import ru.itis.course_work.models.Animal;
import ru.itis.course_work.models.Breeder;
import ru.itis.course_work.models.enums.AnimalStatus;

import java.util.List;

public interface AnimalRepositories extends JpaRepository<Animal, Long> {

  <S extends Animal> List<S> findAllByStatusEqualsAndBreederEquals(AnimalStatus animalStatus, Breeder breeder);
}
