package ru.itis.web_flux_db.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import ru.itis.web_flux_db.models.Country;
import ru.itis.web_flux_db.repository.CountriesRepository;

@Component
public class CountryService {
  @Autowired
  CountriesRepository countriesRepository;

  public Flux<Country> getAllCountries() {
    return Flux.fromIterable(countriesRepository.findAll());
  }
}
