package ru.itis;//+

import java.util.Scanner;

public class ex32b {
    // задание 32 б
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double eps = 0.0001,x0,xn;
        x0 = a;
        xn = 1 + 9*Math.sin(x0)/2;
        while (Math.abs(xn-x0) > eps){
            x0 = xn;
            xn = 1 + 9*Math.sin(x0)/2;

        }
        System.out.println(xn);
    }
}
