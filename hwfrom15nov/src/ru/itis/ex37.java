package ru.itis;

import java.util.Scanner;

public class ex37 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [][] matrix = new int[n][n];
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < n  ; i++) {
            for (int j = i + 1; j < n - i - 1 ; j++) {
                matrix[i][j] = 0;
            }
            for (int j = n - i ; j < i ; j++){
                matrix[i][j] = 0;
            }
            
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");

            }
            System.out.println();

        }
            
    }
}

