package ru.itis.course_work.config;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import ru.itis.course_work.controllers.BreederController;
import ru.itis.course_work.models.Breeder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class BreederRepresentationProcessor implements RepresentationModelProcessor<EntityModel<Breeder>> {
  @Override
  public EntityModel<Breeder> process(EntityModel<Breeder> model) {
    Breeder breeder = model.getContent();
    if (breeder != null) {
      model.add(linkTo(methodOn(BreederController.class).getNotSold(breeder.getId())).withRel("getNotSold"));
    }
    return model;
  }
}
