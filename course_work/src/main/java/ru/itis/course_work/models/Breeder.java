package ru.itis.course_work.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Breeder {
  @Id
  @GeneratedValue
  private Long id;
  private String email;
  private String firstName;
  private String lastName;
  private String surname;

  private String address;
  private String phoneNumber;

  @OneToMany(mappedBy = "breeder")
  private List<Animal> animals;

  @OneToMany(mappedBy = "breeder")
  private List<AggregatorOffer> aggregatorOffers;


}
