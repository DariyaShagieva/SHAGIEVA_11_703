package ru.itis;//+

import java.util.Scanner;

public class ex24b {
    // задание 24 б
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        int k = 2;
        double b0,c0, b1, c1,b2,c2,bk,ck,e = 0.00001, sum = 0;
        b0 = 1;
        c0 = 0;
        b1 = Math.cos(x);
        c1 = Math.sin(x);
        b2 = b1*b1 - c1*c1;
        c2 = c1*b1 + c1*b1;
        bk = b2*b1 - c2*c1;
        ck = c2*b1 + c1*b2;
        sum = b0 + b1;
        while (Math.abs(bk/k) >= e){
            sum += bk / k;
            k++;

            b2 = bk*b1 - ck*c1;
            c2 = ck*b1 + c1*bk;
            bk = b2*b1 - c2*c1;
            ck = c2*b1 + c1*b2;
        }
        System.out.println(sum);


    }
}
