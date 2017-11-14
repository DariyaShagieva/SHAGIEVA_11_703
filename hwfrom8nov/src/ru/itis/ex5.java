package ru.itis;

import java.util.Scanner;

public class ex5 {
    //Проверить, является ли матрица магическим квадратом
    public static void readMatrix(int matrix[][]) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    public static void showMatrix(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        readMatrix(matrix);
        boolean f = true;
        int sum0 = 0, sumstrok, sumstolb, sumdiag = 0;
        for (int i = 0; i < n; i++){
            sum0 += matrix[i][i];
        }
        for ( int i = 0; i < n && f; i++){
            sumstrok = 0;
            sumstolb = 0;
            for (int j = 0; j < n; j++){
                sumstrok += matrix[i][j];
                sumstolb += matrix[j][i];

            }
            if (sum0 != sumstrok || sum0 != sumstolb) f = false;
            sumdiag += matrix[i][n - 1 - i];
        }
        if (sum0 != sumdiag) f = false;
        if (f) System.out.println(" матрица является магическим квадратом");
        else System.out.println("матрица не является магическим квадратом");

    }
}
