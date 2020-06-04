package ru.itis.web_flux_mix.clients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import ru.itis.web_flux_mix.models.Country;

import java.util.Arrays;

@Component
public class DBClient implements Client {
  private WebClient webClient;

  public DBClient(@Value("${local.link}") String apiUrl) {
    webClient = WebClient.builder()
      .exchangeStrategies(ExchangeStrategies.builder()
        .codecs(clientCodecConfigurer -> clientCodecConfigurer.defaultCodecs().maxInMemorySize(1024 * 1024 * 100))
        .build())
      .baseUrl(apiUrl)
      .build();
  }

  @Override
  public Flux<Country> getAll() {
    return webClient.get()
      .accept(MediaType.ALL)
      .exchange()
      .flatMap(clientResponse -> clientResponse.bodyToMono(Country[].class))
      .flatMapIterable(Arrays::asList);
  }
}
