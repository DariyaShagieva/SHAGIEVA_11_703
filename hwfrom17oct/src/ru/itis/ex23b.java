package ru.itis;

import java.util.Scanner;

public class ex23b {
    //задание 23 б
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double x = scanner.nextDouble();
        double v0,v1,vn, sum;
        int t = 4;
        int p = 1;
        v0 = v1 = a;
        vn = v1 + v0;
        sum = v0*Math.cos(v0*x)*Math.cos(v0*x)-v1/2*Math.cos(v1*x)*Math.cos(v1*x);
        while (vn <= b){
            sum = p*vn/t*Math.cos(vn*x)*Math.cos(vn*x);
            p = -p;
            t *=2;
            v0 = v1;
            v1 = vn;
            vn = v1+v0;
        }
        System.out.println(sum);

    }
}
