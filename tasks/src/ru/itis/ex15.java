package ru.itis;//-

import java.util.Scanner;

public class ex15 {
    //Построить число, которое будет содержать только нечетные цифры числа N (в сохрн. порядке)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = 0, p = n;
        int k = 0;
        while (n != 0) {
            k++;
            n /= 10;
        }
        int[] a = new int[k];
        for (int i = 0; i < k; i++){
            a[i] = p%10;
            p /= 10;
        }
        for ( int i = k-1; i >= 0; i--){
            if (a[i] % 2 == 1) {
                System.out.print(a[i]);//а где построенное число?
            }
        }
    }
}
