package ru.itis;

import java.util.Scanner;

public class ex12c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 1, p =1;
        double x = scanner.nextDouble();
        double e = 0.0000001, t = x, s = 0, l = x;

        while (Math.abs(t) > e){
            s += t*p;
            p = -p;
            n++;
            l *=x;
            t = l/n;
        }
        System.out.print(s);
    }
}
