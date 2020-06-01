package ru.itis.course_work.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import ru.itis.course_work.models.Animal;
import ru.itis.course_work.models.Breeder;
import ru.itis.course_work.repositories.BreederRepository;

import java.util.Optional;

@Component
public class BreederService {
  @Autowired
  private AnimalService animalService;

  @Autowired
  private BreederRepository breederRepository;

  public Flux<String> getAllNotSoldAnimalsFromBreeder(Long id) {

    Optional<Breeder> breederOptional = breederRepository.findById(id);
    if (breederOptional.isPresent()) {
      Breeder breeder = breederOptional.get();
      return animalService.getNotSoldAnimals(breeder);
    }
    return null;

  }

}
