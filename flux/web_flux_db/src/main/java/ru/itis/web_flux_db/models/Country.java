package ru.itis.web_flux_db.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Country {

  @Id
  @Generated
  private Long id;

  private String name;

}
