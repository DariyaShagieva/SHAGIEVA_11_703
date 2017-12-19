package ru.itis;

public class Bayan extends MusicalInstrument implements MusicInstInterface {
    private int placeStolb;
    private int placeStroka;

    Bayan(String name, int price) {
        super(name, price);
    }

    @Override
    public void playMelody() {
        System.out.println("я баян, ла ла ла ");
    }

    @Override
    public String toString() {
        System.out.println(name);
        return String.valueOf(price) + " - Стоимость инструмента";
    }
}
