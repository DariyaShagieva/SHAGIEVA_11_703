package ru.itis;

public abstract class Carrier {
    // скорость в км/ч, цена за каждые пройденные 100 км
    protected int price;
    protected int speed;

    public abstract void calculateTime(int distance);
    public abstract void costOfTransportation(int distance);
}
