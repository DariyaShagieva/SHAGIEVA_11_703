package ru.itis;

public class Violin extends MusicalInstrument implements MusicInstInterface {

    Violin(String name, int price) {
        super(name, price);
    }

    @Override
    public void playMelody() {
        System.out.println("я скрипка, ла ла ла ");
    }

    @Override
    public String toString() {
        System.out.println(name);
        return String.valueOf(price) + " - Стоимость инструмента";
    }
}
