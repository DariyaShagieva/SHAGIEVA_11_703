package ru.itis;

import java.util.Scanner;

public class EX226 {
    static public String[] sort(String[] arr){
        for (int i = arr.length - 1; i >=0; i--) {
            for (int j = 1 ; j <= i ; j++) {
                if(compareStr(arr[j], arr[j - 1])){
                    String t = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = t;
                }

            }

        }
        return arr;
    }
    static public boolean compareStr(String first, String second) {
        for (int i = 0; (i < first.length()) & (i < second.length()); i++) {
            if (first.charAt(i) != second.charAt(i)) return (first.charAt(i) < second.charAt(i));
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 5;
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLine();
        }
        sort(arr);
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }

    }
}
