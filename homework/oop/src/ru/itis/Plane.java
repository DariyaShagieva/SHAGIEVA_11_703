package ru.itis;

public class Plane extends Carrier{
    public Plane(int price, int speed) {
        this.price = price;
        this.speed = speed;
    }

    @Override
    public void costOfTransportation(int distance) {
        if (distance > 300){
            double t = 1.0*distance*price/100.0;
            System.out.println("стоимость перевозки на самолете в рубля - " + t);
        }
        else System.out.println("не обслуживается, так как маленькая дистанция");
    }

    @Override
    public void calculateTime(int distance) {
        if (distance > 300){
            double t = 1.0*distance/speed;
            System.out.println("время перевозки на самолете в часах - " + t);
        }
        else System.out.println("не обслуживается, так как маленькая дистанция");
    }
}
