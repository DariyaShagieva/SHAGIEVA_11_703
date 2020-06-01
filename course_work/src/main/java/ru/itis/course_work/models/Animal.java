package ru.itis.course_work.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.course_work.models.enums.AnimalStatus;
import ru.itis.course_work.models.enums.Category;
import ru.itis.course_work.models.enums.Gender;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Animal {
  @Id
  @GeneratedValue
  private Long id;

  @Column(length = 300)
  private String name;

  @Column(length = 1000)
  private String description;

  @Enumerated(value = EnumType.STRING)
  private Gender gender;

  private Date birthday;

  private double cost;

  @Enumerated(value = EnumType.STRING)
  private AnimalStatus status = AnimalStatus.FOR_SALE;

  @ManyToOne
  @JoinColumn(name = "breeder_id")
  private Breeder breeder;

  @OneToMany(mappedBy = "animal")
  private List<AggregatorOffer> aggregatorOffers;

  @Enumerated(value = EnumType.STRING)
  private Category category;

  public void changeStatus(){
    if (status == AnimalStatus.FOR_SALE) {
      status = AnimalStatus.PURCHASED;
    }
  }


}
