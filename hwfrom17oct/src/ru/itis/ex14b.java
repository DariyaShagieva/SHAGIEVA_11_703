package ru.itis;

import java.util.Scanner;

public class ex14b {
    //Задание 14 б
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double x = scanner.nextDouble();
        double t, eps = 0.0001, sum = 0;
        t = 1/a;
        while (Math.abs(t) >= eps){
            sum = t*Math.log(t*x);
            t *= 1/a;
        }
        System.out.println(sum);

    }
}
