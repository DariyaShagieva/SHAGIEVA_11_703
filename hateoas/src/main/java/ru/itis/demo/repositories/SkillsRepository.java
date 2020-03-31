package ru.itis.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.demo.models.Skill;

public interface SkillsRepository extends JpaRepository<Skill, Long> {
}
