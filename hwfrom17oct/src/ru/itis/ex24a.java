package ru.itis;

import java.util.Scanner;

public class ex24a {
    // задание 24а
    public static void main(String[] args) {
        double b0,c0,b1,c1,b2,c2,bk,ck, eps = 0.00001, sum = 0;
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        int k = 2, n = k ;
        b0 = 1;
        c0 = 0;
        b1 = Math.cos(x);
        c1 = Math.sin(x);
        b2 = b1;
        c2 = c1;
        bk = b2*b1 - c2*c1;
        ck = c2*b1 + c1*b2;
        sum = c0 + c1;
        while (Math.abs(ck/n) >= eps){
            sum += ck/n;
            k++;
            n *= k;
            b2 = bk;
            c2 = ck;
            bk = b2*b1 - c2*c1;
            ck = c2*b1 + c1*b2;



        }
        System.out.println(sum);

    }
}
