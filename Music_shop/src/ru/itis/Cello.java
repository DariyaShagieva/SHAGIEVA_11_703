package ru.itis;

public class Cello extends MusicalInstrument implements MusicInstInterface {
    private int placeStolb;
    private int placeStroka;

    Cello(String name, int price) {
        super(name, price);
    }

    @Override
    public void playMelody() {
        System.out.println("я виолончель, ла ла ла ");
    }

    @Override
    public String toString() {
        System.out.println(name);
        return String.valueOf(price) + " - Стоимость инструмента";
    }
}
