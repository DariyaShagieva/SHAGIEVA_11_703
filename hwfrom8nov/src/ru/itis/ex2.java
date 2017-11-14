package ru.itis;

import java.util.Random;
import java.util.Scanner;

public class ex2 {
<<<<<<< HEAD
    // обнулить элементы ниже главной диaгнали
=======
    // обнулить элементы ниже главной диaгонали
>>>>>>> f815c2a86a6d774036e7842ad0322110631458eb
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
