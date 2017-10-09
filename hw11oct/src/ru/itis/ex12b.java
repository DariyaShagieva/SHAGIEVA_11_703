package ru.itis;

import java.util.Scanner;

public class ex12b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int p =1, n = 0;
        double x = scanner.nextDouble();
        double e = 0.000001, t = x, s = 0;

        while (Math.abs(t) > e){
            s += t*p;
            p = -p;
            n++;
            t *= x*x/(2*n*(2*n+1));
        }
        System.out.print(s);

    }
}
