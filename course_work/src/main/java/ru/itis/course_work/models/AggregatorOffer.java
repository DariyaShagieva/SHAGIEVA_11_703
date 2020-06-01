package ru.itis.course_work.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.course_work.models.enums.OfferStatus;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "aggregator_offer")
public class AggregatorOffer{
  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne
  @JoinColumn(name = "customer_id")
  private Customer customer;

  @ManyToOne
  @JoinColumn(name = "animal_id")
  private Animal animal;

  @ManyToOne
  @JoinColumn(name = "breeder_id")
  private Breeder breeder;

  @Column(length = 1000)
  private String message;

  @Enumerated(value = EnumType.STRING)
  private OfferStatus offerStatus = OfferStatus.NEW;

  public String toMessage(){
    return  breeder.getEmail() + "\n" +
      "Отправитель: " + customer.getEmail() + "\n" +
      "Животное: " + animal.getName() + "\n" +
      "Сообщение: " + message;
  }
  public String toAnswer(){
    return customer.getEmail() + "\n" ;
  }

}
