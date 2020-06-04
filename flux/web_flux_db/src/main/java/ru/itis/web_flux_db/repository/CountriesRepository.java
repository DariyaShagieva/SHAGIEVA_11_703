package ru.itis.web_flux_db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.web_flux_db.models.Country;

public interface CountriesRepository extends JpaRepository<Country, Long> {
}
