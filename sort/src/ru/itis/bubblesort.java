package ru.itis;

import java.util.Scanner;

public class bubblesort {
    public static void createArr(int[] arr){
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++){
            arr[i] = scanner.nextInt();
        }
    }
    public static void bubbleSort(int[] arr){
        boolean f = false;
        int t;
        for (int i = arr.length - 1; i >= 0 & !f; i--) {
            f = true;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    t = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = t;
                    f = false;
                }
            }
        }
    }
    public static void showArr(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");

        }
    }
    public static void main(String[] args) {
        int n = 5;
        int[] arr = new int[n];
        createArr(arr);
        bubbleSort(arr);
        showArr(arr);

    }
}