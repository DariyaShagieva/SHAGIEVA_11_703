package ru.itis.course_work.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Gender {
  MALE("Мужской"),
  FEMALE("Женский");

  private String gender;
}
