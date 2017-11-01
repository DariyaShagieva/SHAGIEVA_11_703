package ru.itis;

import java.util.Random;
import java.util.Scanner;

public class locmin {
    // сортировка нахождением локального минимума
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int min, k = 0,t;
        for (int i = 0; i < n; i++){
            a[i] = random.nextInt(50);
            System.out.print(a[i] + " ");
        }
        System.out.println();
        for ( int i = 0; i < n - 1; i++){
            min = a[i];
            for ( int j = i + 1; j < a.length; j++) {
                if (a[j] < min) {
                    min = a[j];
                    k = j;
                }
            }
                if ( i != k) {
                    t = a[i];
                    a[i] = min;
                    a[k] = t;

                }
            }

        for (int i = 0; i < n; i++){
            System.out.print(a[i] + " ");
        }

    }
}
