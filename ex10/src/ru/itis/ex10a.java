package ru.itis;

import java.util.Scanner;

public class ex10a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double n = scanner.nextInt();
        double x = scanner.nextDouble();
        int p = 1;

        double s = x,t = x;

        for (int i = 1; i <= n; i++){
            p = -p;
            t *=x*x/i;
            s += p*t/(2*i+1);  //в принципе, тоже выход

        }
        System.out.print(s);

    }
}
