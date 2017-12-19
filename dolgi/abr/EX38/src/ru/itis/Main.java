package ru.itis;

import java.util.Scanner;

public class Main {
    static double[][] creatMatrix(double[][] matrix){
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }
    static void gauss(double[][] matrix) {
        for (int j = 0; j < matrix.length - 1; j++) {
            for (int i = j + 1; i < matrix.length; i++) {
                for (int k = 0; k < matrix.length; k++) {
                  matrix[i][k] = (matrix[i][k] * matrix[j][j]) - (matrix[j][k] * matrix[i][j]);
                    if (j != 0) matrix[i][k] /= matrix[j][j];
                }
            }
        }

    }
    static void showMatrix(double[][] matrix){
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
	double[][] matrix = new double[n][n];
	creatMatrix(matrix);
	gauss(matrix);
	showMatrix(matrix);

    }
}
