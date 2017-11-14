package ru.itis;

import java.util.Scanner;

public class ex1
    //отсортировать каждую строку матрицы методом пузырька
{

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
        int strok = scanner.nextInt();
        int stolb = scanner.nextInt();
        int[][] matrix = new int[strok][stolb];
        readMatrix(matrix);

        for (int i = 0; i < strok; i++) {
            for ( int j = 0; j < stolb; j++){
                for (int n = 0; n < stolb - 1 - i; n++ ){
                    if (matrix[i][n] > matrix[i][n+1]) {
                        int t = matrix[i][n];
                        matrix[i][n] = matrix[i][n + 1];
                        matrix[i][n + 1] = t;
                    }
                }
            }


        }
        showMatrix(matrix);
    }
}