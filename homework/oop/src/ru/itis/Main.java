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
        plane.costOfTransportation(distanceBetweenCities);
        plane.calculateTime(distanceBetweenCities);
        System.out.println();
        train.costOfTransportation(distanceBetweenCities);
        train.calculateTime(distanceBetweenCities);
        System.out.println();
        car.costOfTransportation(distanceBetweenCities);
        car.calculateTime(distanceBetweenCities);

    }
}
