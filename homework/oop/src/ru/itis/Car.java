package ru.itis;

public class Car extends Carrier {
    public Car(int price, int speed) {
        this.price = price;
        this.speed = speed;
    }

    @Override
    public void calculateTime(int distance) {
        double t = 1.0*distance/speed;
        System.out.println("время перевозки на машине в часах - " + t);
    }

    @Override
    public void costOfTransportation(int distance) {
        double t = 1.0*distance*price/100.0;
        System.out.println("стоимость перевозки на машине в рубля - " + t);

    }
}

