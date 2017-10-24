package ru.itis;

import java.util.Random;
import java.util.Scanner;

public class ex22g {
    // задание 22 ж
    public static void main(String[] args) {
        Random r = new Random();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k , del,p = 0;
        int[] a = new int[n];
        for (int i = 0; i < n; i++){

            a[i] = r.nextInt(100);
            System.out.print(a[i] + " ");
                if (a[i]>2){
                k = 1;
                for (int j = 2; j <= a[i]; j++) {
                    k++;
                    if (a[i] % j == 0) break;


                }
                if (k == a[i]) p++;

            }




        }
        System.out.println();

        System.out.print(p);

    }
}
