package ru.itis.web_flux.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ApiCountriesJson {
  @JsonProperty("name")
  private String name;
}
