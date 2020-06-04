package ru.itis.web_flux_mix.clients;

import reactor.core.publisher.Flux;
import ru.itis.web_flux_mix.models.Country;

public interface Client {
  Flux<Country> getAll();
}
