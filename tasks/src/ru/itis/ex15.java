package ru.itis;//-

import java.util.Scanner;

public class ex15 {
    //Построить число, которое будет содержать только нечетные цифры числа N (в сохрн. порядке)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = 1, m = 0;
        while (n > 0) {
            if (n % 10 % 2 == 1 ){
                m += n%10*k;
                k *=10;

            }
            n /=10;

        }
        System.out.print(m);
    }

}
