package ru.itis;

import java.util.Scanner;

public class ex12a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        int n =2;
        double e = 0.0001, t = x, s = 1;

        while (Math.abs(t)> e){
            s += t;
            t *= x/(1.0*n);
            n++;
        }
        System.out.print(s);

    }
}
