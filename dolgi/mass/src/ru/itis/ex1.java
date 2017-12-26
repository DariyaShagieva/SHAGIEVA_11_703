package ru.itis;

import java.util.Scanner;

public class ex1 {
    //добавить в массив строку так, чтоб не нарушилась упорядочность по первому столбцу
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 3, m = 3;
        int[][] arr = new int[n + 1][m];
        int[] a = new int[m];
        int t;
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < m ; i++) {
            a[i] = scanner.nextInt();
        }
        for (int k = 0; k < n ; k++) {
            if(a[k] > arr[k][0]) {
                for (int i = k + 1; i < n + 1; i++) {
                    for (int j = 0; j < m ; j++) {
                        t = arr[i][j];                     //why is it so difficult?
                        arr[i][j] = a[j];
                        a[j] = t;
                    }

                }
            }

        }
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");

            }
            System.out.println();

        }

    }
}
