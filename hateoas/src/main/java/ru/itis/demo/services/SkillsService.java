package ru.itis.demo.services;

import ru.itis.demo.models.Skill;

public interface SkillsService {
    Skill changeStatus(long skillId);
}
