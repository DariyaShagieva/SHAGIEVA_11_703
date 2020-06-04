package ru.itis.web_flux_mix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ru.itis.web_flux_mix.clients.ApiClient;
import ru.itis.web_flux_mix.models.Country;
import ru.itis.web_flux_mix.service.CountriesService;

@RestController
public class CountryController {

  @Autowired
  private CountriesService countriesService;

  @GetMapping("/getCountries")
  public Flux<Country> getCountries() {
    return countriesService.getAll();

  }
}
