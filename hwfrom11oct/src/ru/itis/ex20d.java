package ru.itis;//+

import java.util.Scanner;

public class ex20d {
    //задание 20д
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        int n = scanner.nextInt();
        int i=1;
        double d = 5, e = 4, f = 16, g = 3, h = 7;
        double x0, y0,x1,y1,x2,y2,xk,yk;
        x0 = y0 = a;
        x1 = y1 = b;
        x2 = y2 = c;
        xk = d*x2 + e*y1 + f*x0;
        yk = g*x2 + h*y1;
        while (i <= n){
            x0 = x1;
            y0 = y1;
            x1 = x2;
            y1 = y2;
            x2 = xk;
            y2 = yk;
            xk = d*x2 + e*y1 + f*x0;
            yk = g*x2 + h*y1;
            i++;
    }
    System.out.println(xk);
    System.out.print(yk);
    }
}
