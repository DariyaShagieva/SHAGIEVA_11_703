package ru.itis;//-

import java.util.Scanner;

public class ex11d {
    // задание 11 г
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double p = 1;
        for (int i = 1; i <= n; i++){
            p *= Math.sin(i)/Math.cos(i);//неверная формула
        }
        System.out.print(p);
    }

}
