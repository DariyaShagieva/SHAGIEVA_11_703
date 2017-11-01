package ru.itis;

import java.util.Random;
import java.util.Scanner;

public class localmax {
    // сортировка нахождением локального максимума
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int max, k = 0,t;
        for (int i = 0; i < n; i++){
            a[i] = random.nextInt(50);
            System.out.print(a[i] + " ");
        }
        System.out.println();
        for ( int i = 1; i < n; i++){

        }
    }
}
