package ru.itis;//+

import java.util.Scanner;

public class ex14 {
    //задание 14. Подсчитать количество цифр в числе N.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = 0;
        while (n != 0) {
            k++;
            n /= 10;
        }
        System.out.println(k);
    }
}
