package ru.itis;

public class Car extends Carrier {
    public Car(int price, int speed) {
        super(price, speed);
    }

    @Override
    public double calculateTime(int distance) {
        return super.calculateTime(distance);
    }

    @Override
    public double costOfTransportation(int distance) {
        return super.costOfTransportation(distance);
    }
}
