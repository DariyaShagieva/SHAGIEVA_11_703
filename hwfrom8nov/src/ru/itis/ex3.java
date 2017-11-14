package ru.itis;

import java.util.Random;
import java.util.Scanner;

public class ex3 {
    // заполнить единицами выше побочной диагонали
    public static void randomMatrix(int matrix[][]) {
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(10);
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
        int [][] matrix = new int[strok][stolb];
        randomMatrix(matrix);
        for (int i = 0; i < strok; i++){
            for ( int j = 0; j < matrix.length - 1 - i; j++){
                matrix[i][j] = 1;
            }
        }
        showMatrix(matrix);
    }

}
