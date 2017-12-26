package ru.itis;

public abstract class Carrier {
    // скорость в км/ч, цена за каждые пройденные 100 км
       int price;
       int speed;

    public Carrier(int price, int speed) {
        this.price = price;
        this.speed = speed;
    }
    public double calculateTime (int distance){
        return 1.0*distance/speed;
    }
    public double costOfTransportation(int distance){
        return 1.0*distance*price/100;
    }
}
