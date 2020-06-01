package ru.itis.course_work.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Category {
  CATS("Кошки"),
  DOGS("Собаки"),
  BIRDS("Птицы"),
  RODENTS("Грызуны");

  private String category;


  /**
   * Поулчить категорию по названию
   * @param category
   * @return
   */
  public static Category withCategory(String category) {
    // обходим все возможные значения
    for (Category categories : values()) {

      if (categories.category.equalsIgnoreCase(category)) {
        return categories;
      }
    }
    throw  new IllegalArgumentException("Такой категории нет");
  }


}
