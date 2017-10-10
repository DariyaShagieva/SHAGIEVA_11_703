package ru.itis;

import java.util.Scanner;

public class ex12c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 1, p =1;
        double x = scanner.nextDouble();
        double e = 0.000000001, t = 1, s = 0;

        while (Math.abs(t) > e){
            s += t*p;
            p = -p;
            n++;
            x *=x; //только четные степени
            t = x/n;
        }
        System.out.print(s);
    }
}
