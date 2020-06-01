package ru.itis.course_work.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;
import ru.itis.course_work.services.BreederService;

@RepositoryRestController
public class BreederController {
  @Autowired
  private BreederService breederService;

  @RequestMapping(value = "/breeders/{breeder-id}/getNotSold",method = RequestMethod.GET)
  public @ResponseBody
  Flux<?> getNotSold(@PathVariable("breeder-id") Long breederId) {
    return breederService.getAllNotSoldAnimalsFromBreeder(breederId);
  }

}
