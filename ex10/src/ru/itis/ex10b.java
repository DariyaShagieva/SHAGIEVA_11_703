package ru.itis;

import java.util.Scanner;

public class ex10b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double n = scanner.nextInt();
        double x = scanner.nextDouble();
        int p = 1;

        double s = x, t = x;

        for (int i = 1; i <= n; i++) {
            p = -p;
            t *= x * x * x * x/ (2*i*(2*i-1));
            s += p * t / (4 * i + 1);

        }
        System.out.print(s);
    }
}
