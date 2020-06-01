package ru.itis.course_work.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OfferStatus {
  NEW("Новое"),
  IN_PROCESS("На рассматрении"),
  ACCEPTED("Принято"),
  DECLINED("Отклонено");

  private String status;
}
