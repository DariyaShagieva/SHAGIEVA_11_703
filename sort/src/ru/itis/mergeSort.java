package ru.itis;

import java.util.Scanner;

public class mergeSort {
    // применяем, если даны два отсортированных массива
    public static void createArr(int[] arr) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
    }

    public static int[] mergesort(int[] arr1, int[] arr2) {
        int[] arr = new int[arr1.length + arr2.length];
        int i = 0,k = 0, t = 0;
        while ((k < arr1.length) && (t < arr2.length)) {
            if (arr1[k] < arr2[t]) {
                arr[i] = arr1[k];
                k++;
            } else {
                arr[i] = arr2[t];
                t++;
            }
            i++;
        }
        if (k == arr1.length) {
            for (int j = t; j < arr2.length; j++) {
                arr[i] = arr2[j];
                i++;
            }
        }
        if (t == arr2.length) {
            for (int j = k; j < arr1.length; j++) {
                arr[i] = arr1[j];
                i++;
            }
        }
        return arr;

    }

    public static void showArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");

        }
    }

    public static void main(String[] args) {
        int n = 5, m = 7;
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        int[] arr3;
        createArr(arr1);
        createArr(arr2);
        arr3 = mergesort(arr1, arr2);
        showArr(arr3);

    }
}
