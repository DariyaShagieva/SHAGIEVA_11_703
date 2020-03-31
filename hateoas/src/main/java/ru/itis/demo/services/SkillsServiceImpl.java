package ru.itis.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.demo.models.Skill;
import ru.itis.demo.repositories.SkillsRepository;

@Service
public class SkillsServiceImpl implements SkillsService {

    @Autowired
    SkillsRepository skillsRepository;

    @Override
    public Skill changeStatus(long skillId) {
        Skill skill = skillsRepository.findById(skillId).orElseThrow(IllegalArgumentException::new);
        skill.changeStatus();
        skillsRepository.save(skill);
        return skill;
    }
}
