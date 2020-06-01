package ru.itis.course_work.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

  @Id
  @GeneratedValue
  private Long id;
  private String email;
  private String firstName;
  private String lastName;
  private String surname;


  @OneToMany(mappedBy = "customer")
  private List<AggregatorOffer> aggregatorOffers;

}
