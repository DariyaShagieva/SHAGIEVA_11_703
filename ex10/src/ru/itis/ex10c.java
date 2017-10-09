package ru.itis;

import java.util.Scanner;

public class ex10c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double n = scanner.nextDouble();
        double x = scanner.nextDouble();
        double s = 0, t = 1;
        for (int i = 1; i <= n; i++){
            t *= x*x*(2*i - 1)/(2*i);
            s += t;
        }
        System.out.print(s);
    }
}
