package ru.itis.course_work.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.course_work.services.AnimalService;


@RepositoryRestController
@RequestMapping(value = "/animals")
public class AnimalController {
  @Autowired
  private AnimalService animalService;

  @RequestMapping(value = "/{animal-id}/sold", method = RequestMethod.PUT)
  public @ResponseBody
  ResponseEntity<?> sold(@PathVariable("animal-id") Long animalId){

    return ResponseEntity.ok(new EntityModel<>(animalService.changeStatus(animalId)));
  }



}
