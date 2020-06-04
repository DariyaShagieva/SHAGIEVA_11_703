package ru.itis.web_flux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import ru.itis.web_flux.clients.Client;
import ru.itis.web_flux.models.ApiCountries;

@Component
public class CountriesService {
  @Autowired
  private Client client;

  public Flux<ApiCountries> getAllergens() {
    return client.getAll();
  }
}
