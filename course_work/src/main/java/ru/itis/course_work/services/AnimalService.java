package ru.itis.course_work.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import ru.itis.course_work.models.Animal;
import ru.itis.course_work.models.Breeder;
import ru.itis.course_work.models.enums.AnimalStatus;
import ru.itis.course_work.repositories.AnimalRepositories;

import java.util.Optional;

@Component
@Transactional
public class AnimalService {

  @Autowired
  private AnimalRepositories animalRepositories;

  public Animal changeStatus(Long animalId) {
    Optional<Animal> animalOptional = animalRepositories.findById(animalId);
    if (animalOptional.isPresent()) {
      Animal animal = animalOptional.get();
      animal.changeStatus();
      animalRepositories.save(animal);
      return animal;
    }
    return null;
  }

  public Flux<String> getNotSoldAnimals(Breeder breeder){
    return Flux.fromStream(animalRepositories.findAllByStatusEqualsAndBreederEquals(AnimalStatus.FOR_SALE, breeder)
      .stream().map(Animal::getName));
  }

}
;
