package ru.itis.demo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientsHelp {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Client assistant;
    @OneToOne
    private Client toClient;

    @OneToOne
    private Skill skill;

    public void help(Skill skill) {
        if (skill.getSkillStatus().equals(SkillStatus.WISH)) {
            if (assistant.getSkills().contains(skill)) {
                Skill skill1 = assistant.getSkills().get(assistant.getSkills().indexOf(skill));
                if (skill1.getSkillStatus().equals(SkillStatus.STUDIED)) {
                    this.skill = skill;
                    skill.setSkillStatus(SkillStatus.IN_PROCESS);
                } else {
                    throw new IllegalArgumentException("Нельзя научить тому, чего не знаешь");
                }
            } else {
                throw new IllegalArgumentException("Нельзя научить тому, чего не знаешь");
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

}
