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
        int max, k = 0, t;
        for (int i = 0; i < n; i++) {
            a[i] = random.nextInt(50);
            System.out.print(a[i] + " ");
        }
        System.out.println();
        for (int i = a.length - 1; i > 0; i--) {
            max = a[i];
            for (int j = 0; j < i; j++) {
                if (a[j] > max) {
                    max = a[j];
                    k = j;
                }
            }
                if(i != k) {
                        t = a[i];
                        a[i] = max;
                        a[k] = t;
                }

            }


        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }
}