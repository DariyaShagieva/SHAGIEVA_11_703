package ru.itis.course_work.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.itis.course_work.models.AggregatorOffer;
import ru.itis.course_work.services.OfferService;

@RepositoryRestController
public class OfferController {
  @Autowired
  private OfferService offerService;

  @RequestMapping(value = "/aggregatorOffers/{offer-id}/sendOffer",method = RequestMethod.PUT)
  public @ResponseBody
  ResponseEntity<?> sendOffer(@PathVariable("offer-id") Long offerId) {
    return ResponseEntity.ok(new EntityModel<>(offerService.sendOffer(offerId)));
  }

  @RequestMapping(value = "/aggregatorOffers/{offer-id}/allow",method = RequestMethod.PUT)
  public @ResponseBody
  ResponseEntity<?> allow(@PathVariable("offer-id") Long offerId, @RequestBody AggregatorOffer aggregatorOffer) {
    System.out.println(aggregatorOffer.getOfferStatus());
    return ResponseEntity.ok(new EntityModel<>(offerService.allow(offerId, aggregatorOffer.getOfferStatus())));
  }

}
