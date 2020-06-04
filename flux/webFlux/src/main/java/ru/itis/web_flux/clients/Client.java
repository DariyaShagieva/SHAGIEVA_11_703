package ru.itis.web_flux.clients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import ru.itis.web_flux.models.ApiCountries;
import ru.itis.web_flux.models.ApiCountriesJson;

import java.util.Arrays;

@Component
public class Client {
  private WebClient webClient;

  public Client(@Value("${api.link}") String apiUrl) {
    webClient = WebClient.builder()
      .exchangeStrategies(ExchangeStrategies.builder()
        .codecs(clientCodecConfigurer -> clientCodecConfigurer.defaultCodecs().maxInMemorySize(1024 * 1024 * 100))
        .build())
      .baseUrl(apiUrl)
      .build();
  }

  public Flux<ApiCountries> getAll() {
    return webClient.get()
      .accept(MediaType.ALL)
      .exchange()
      .flatMap(clientResponse -> clientResponse.bodyToMono(ApiCountriesJson[].class))
      .flatMapIterable(Arrays::asList)
      .map(data -> ApiCountries.builder()
        .name(data.getName())
        .build()
      );
  }
}
