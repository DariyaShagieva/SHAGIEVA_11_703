package ru.itis.web_flux_db.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ru.itis.web_flux_db.models.Country;
import ru.itis.web_flux_db.services.CountryService;

@RestController
public class CountryController {

  @Autowired
  CountryService countryService;

  @GetMapping("/getAllCountries")
  public Flux<Country> getAllCountry(){
    return countryService.getAllCountries();
  }
}
