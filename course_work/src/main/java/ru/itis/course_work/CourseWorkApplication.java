package ru.itis.course_work;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import ru.itis.course_work.models.AggregatorOffer;
import ru.itis.course_work.models.Animal;
import ru.itis.course_work.models.Breeder;
import ru.itis.course_work.models.Customer;
import ru.itis.course_work.models.enums.OfferStatus;
import ru.itis.course_work.repositories.AggregatorOfferRepository;
import ru.itis.course_work.repositories.AnimalRepositories;
import ru.itis.course_work.repositories.BreederRepository;
import ru.itis.course_work.repositories.CustomerRepository;

@SpringBootApplication()
public class CourseWorkApplication {
  private static ConfigurableApplicationContext context;

  public static void main(String[] args) {
    ApplicationContext context =SpringApplication.run(CourseWorkApplication.class, args);

  }

  public static ConfigurableApplicationContext getContext() {
    return context;
  }
}
