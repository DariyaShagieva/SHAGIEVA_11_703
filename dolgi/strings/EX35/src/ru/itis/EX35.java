package ru.itis;

import java.util.Scanner;

public class EX35 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 5;
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLine();
        }
        int min = arr[0].length();
        for (int i = 1; i < n ; i++) {
            if (arr[i].length() < min) min = arr[i].length();
        }
        System.out.println(min);

    }
}
