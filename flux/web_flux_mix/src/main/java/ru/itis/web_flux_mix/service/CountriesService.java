package ru.itis.web_flux_mix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import ru.itis.web_flux_mix.clients.Client;
import ru.itis.web_flux_mix.models.Country;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CountriesService {

  @Autowired
  private List<Client> clients;

  public Flux<Country> getAll() {
    List<Flux<Country>> fluxes =  clients.stream().map(this::getAll).collect(Collectors.toList());
    return Flux.merge(fluxes);
  }

  private Flux<Country> getAll(Client client) {
    return client.getAll().subscribeOn(Schedulers.elastic());
  }
}
