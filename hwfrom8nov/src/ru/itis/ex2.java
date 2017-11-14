package ru.itis;

import java.util.Random;
import java.util.Scanner;

public class ex2 {
    // обнулить элементы ниже главной диaгнали
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
        for (int i = 1; i < strok; i++){
            for (int j = 0; j <i; j++){
                matrix[i][j] = 0;
            }
        }
        showMatrix(matrix);
    }
}
