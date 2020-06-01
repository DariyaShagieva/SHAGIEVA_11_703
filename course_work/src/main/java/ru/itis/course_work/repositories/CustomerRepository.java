package ru.itis.course_work.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.course_work.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
