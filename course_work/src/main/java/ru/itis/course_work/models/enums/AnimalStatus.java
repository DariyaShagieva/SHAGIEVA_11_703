package ru.itis.course_work.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AnimalStatus {
  FOR_SALE ("Продается"),
  PURCHASED("Продан");

  private String status;
}
