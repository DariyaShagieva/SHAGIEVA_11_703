package ru.itis;

import java.util.Scanner;

public class ex11d {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double p = scanner.nextDouble();
        double s = scanner.nextDouble();
        double x = scanner.nextDouble();
        double t = 1;
        int n = scanner.nextInt();
        for ( int i = 1; i <= n; i++){
            t *=x;
            p *= Math.cos(t);    // неверная конструкция
            s += Math.cos(t);
        }
        System.out.println(s);
        System.out.print(p);
    }
}
