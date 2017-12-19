package ru.itis;

import java.util.Scanner;

public class ex4 {
    public static void creatMatrix(int[][] matrix) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    public static boolean compareMatrix(int[][] matrix) {
        boolean f = true;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                f = true;
                for (int k = 0; k < matrix[i].length && f; k++) {
                    if (matrix[i][k] != matrix[k][j]) f = false;
                }
                if (f) break;
            }
            if (f) break;

        }
        return f;
    }

    public static void showMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] matrix = new int[n][n];
        creatMatrix(matrix);
        if (compareMatrix(matrix)) System.out.println("есть одинаковая строка и столбец");
        else System.out.println("нет одинаковой строки и столбца" );
        showMatrix(matrix);
    }
}
