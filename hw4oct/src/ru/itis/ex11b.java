package ru.itis;

import java.util.Scanner;

public class ex11b {
    // задание 11 б
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double p = 1;
        for (int i = 1; i <= n; i++){
            p *= Math.cos(i)/Math.sin(i);
        }
        System.out.print(p);
    }
}
