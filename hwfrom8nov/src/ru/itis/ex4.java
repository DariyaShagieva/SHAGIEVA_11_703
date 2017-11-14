package ru.itis;

import java.util.Random;
import java.util.Scanner;

public class ex4 {
    //транспонировать матрицу
    public static void randomMatrix(int matrix[][], int stolb, int stroc) {
        Random random = new Random();
        for (int i = 0; i < stroc; i++) {
            for (int j = 0; j < stolb; j++) {
                matrix[i][j] = random.nextInt(10);
            }
        }
    }
    public static void showMatrix(int matrix[][], int strok, int stolb) {
        for (int i = 0; i < strok; i++) {
            for (int j = 0; j < stolb; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int strok = scanner.nextInt();
        int stolb = scanner.nextInt();
        int [][] matrix;
        int a,b;
        if (strok > stolb) {
            matrix = new int[strok][strok];
            a = b = strok;
        }
        else if (stolb > strok){

            matrix = new int[stolb][stolb];
            a = b = stolb;
        }
        else {
            matrix = new int[strok][stolb];
            a = strok;
            b = stolb;

        }
        randomMatrix(matrix,strok,strok );
        showMatrix(matrix, strok, stolb);
        System.out.println();
        for (int i = 0; i < a; i++){
            for (int j = i; j < b; j++) {

                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
        a = strok;
        strok = stolb;
        stolb = a;
        showMatrix(matrix,strok,stolb);



    }
}
