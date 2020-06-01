package ru.itis.course_work.config;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import ru.itis.course_work.controllers.AnimalController;
import ru.itis.course_work.models.Animal;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class AnimalRepresentationProcessor implements RepresentationModelProcessor<EntityModel<Animal>> {
  @Override
  public EntityModel<Animal> process(EntityModel<Animal> model) {
    Animal animal = model.getContent();
    if (animal != null) {
      model.add(linkTo(methodOn(AnimalController.class).sold(animal.getId())).withRel("sold"));
    }
    return model;
  }
}
