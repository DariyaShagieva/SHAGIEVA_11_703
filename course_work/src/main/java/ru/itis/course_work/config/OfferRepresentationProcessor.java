package ru.itis.course_work.config;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import ru.itis.course_work.controllers.OfferController;
import ru.itis.course_work.models.AggregatorOffer;
import ru.itis.course_work.models.enums.AnimalStatus;
import ru.itis.course_work.models.enums.OfferStatus;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class OfferRepresentationProcessor implements RepresentationModelProcessor<EntityModel<AggregatorOffer>> {

  @Override
  public EntityModel<AggregatorOffer> process(EntityModel<AggregatorOffer> model) {
    AggregatorOffer aggregatorOffer = model.getContent();
    if (aggregatorOffer != null && (aggregatorOffer.getOfferStatus() == OfferStatus.NEW ||
      aggregatorOffer.getOfferStatus() == OfferStatus.IN_PROCESS)
      && aggregatorOffer.getAnimal().getStatus() != AnimalStatus.PURCHASED) {
      model.add(linkTo(methodOn(OfferController.class).sendOffer(aggregatorOffer.getId())).withRel("sendOffer"));
      if (aggregatorOffer.getOfferStatus() == OfferStatus.IN_PROCESS) {
        model.add(linkTo(methodOn(OfferController.class).allow(aggregatorOffer.getId(), aggregatorOffer)).withRel("allow"));
      }
    }
    return model;
  }
}
