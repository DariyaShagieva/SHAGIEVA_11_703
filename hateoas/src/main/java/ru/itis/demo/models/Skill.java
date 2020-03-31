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
public class Skill {
    @Id
    @GeneratedValue
    private Long id;

    private String skillName;
    private String description;

    @Enumerated(EnumType.STRING)
    private SkillStatus skillStatus;

    public void changeStatus() {
        switch (this.skillStatus) {
            case WISH:
                this.skillStatus = SkillStatus.IN_PROCESS;
                break;
            case IN_PROCESS:
                this.skillStatus = SkillStatus.STUDIED;
                break;
            default:
                throw new IllegalStateException();
        }

    }
}
