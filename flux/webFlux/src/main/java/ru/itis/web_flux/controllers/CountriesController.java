package ru.itis.web_flux.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ru.itis.web_flux.models.ApiCountries;
import ru.itis.web_flux.service.CountriesService;

@RestController
public class CountriesController {

  @Autowired
  private CountriesService countriesService;

  @GetMapping("/getAllCountries")
  public Flux<ApiCountries> getAllCountries(){
   return countriesService.getAllergens();
  }

}
