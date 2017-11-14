package ru.itis;

import java.util.Arrays;
import java.util.Scanner;

public class matrix {
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
    public static int[] findMinsInColumns (int matrix [][]){
        int min[] = new int[matrix[0].length];
        for (int i = 0; i < matrix.length ; i++){
            min[i] = matrix[0][i];
            for (int j = 1; j < matrix[i].length; j++){
                if (matrix[j][i] < min[i]) min[i] = matrix[j][i];
            }
        }
        return min;

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int matrix[][] = new int[n][m];
        readMatrix(matrix);
        int mins[] = findMinsInColumns(matrix);
        System.out.println(Arrays.toString(mins));


    }
}
