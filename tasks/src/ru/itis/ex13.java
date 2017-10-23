package ru.itis;

import java.util.Scanner;

public class ex13 {
    // задание 13. подсчитать знакопеременную сумму числа N.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int p = 1, s = 0;
        while (n > 0 ) {
            s += p*(n%10);
            n /= 10;
            p = -p;
        }
        System.out.println(s);
    }
}
