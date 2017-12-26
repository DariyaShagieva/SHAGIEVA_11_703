package ru.itis;

public class Main {

    public static void main(String[] args) {
        // 11) Создать суперкласс Грзоперевозчик и подклассы Самолет, Поезд, Автомобиль.
        // Подсчитать время и стоимость перевозки для указанных городов и расстояний.
        // расстояние между городами в км
        Plane plane = new Plane(100, 900);
        Train train = new Train(50, 200);
        Car car = new Car(10, 100 );
        int distanceBetweenCities = 1300;
        System.out.println("На самолете стоимоть доставки будет " + plane.costOfTransportation(distanceBetweenCities) +
                 " рубля(-ей), время доставки " + plane.calculateTime(distanceBetweenCities) + " час(-ов)");
        System.out.println("На поезде стоимоть доставки будет " + train.costOfTransportation(distanceBetweenCities) +
                " рубля(-ей), время доставки " + train.calculateTime(distanceBetweenCities) + " час(-ов)");
        System.out.println("На машине стоимоть доставки будет " + car.costOfTransportation(distanceBetweenCities) +
                " рубля(-ей), время доставки " + car.calculateTime(distanceBetweenCities) + " час(-ов)");
    }
}
