package ru.itis.course_work.services;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import ru.itis.course_work.models.AggregatorOffer;
import ru.itis.course_work.models.enums.OfferStatus;
import ru.itis.course_work.repositories.AggregatorOfferRepository;

import java.util.Optional;

@Component
@Transactional
public class OfferService {
  @Autowired
  private AmqpTemplate amqpTemplate;

  @Autowired
  private AggregatorOfferRepository aggregatorOfferRepository;

  public AggregatorOffer sendOffer (Long offerId) {
    Optional<AggregatorOffer> offerOptional = aggregatorOfferRepository.findById(offerId);
    if (offerOptional.isPresent()) {
      AggregatorOffer aggregatorOffer = offerOptional.get();
      aggregatorOffer.setOfferStatus(OfferStatus.IN_PROCESS);
      aggregatorOfferRepository.save(aggregatorOffer);
      amqpTemplate.convertAndSend("offers", aggregatorOffer.toMessage());
      return aggregatorOffer;
    }
    return null;
  }

  public AggregatorOffer allow(Long offerId, OfferStatus offerStatus) {
    Optional<AggregatorOffer> offerOptional = aggregatorOfferRepository.findById(offerId);
    if (offerOptional.isPresent()) {
      AggregatorOffer aggregatorOffer = offerOptional.get();
      aggregatorOffer.setOfferStatus(offerStatus);
      aggregatorOfferRepository.save(aggregatorOffer);
      if(offerStatus == OfferStatus.ACCEPTED) {
        amqpTemplate.convertAndSend("offers", aggregatorOffer.toAnswer() + "Ваше предложение принято");
      } else {
        amqpTemplate.convertAndSend("offers", aggregatorOffer.toAnswer() + "Ваше предложение отклонено");
      }
      return aggregatorOffer;
    }
    return null;
  }
}
