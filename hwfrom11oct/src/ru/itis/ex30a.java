package ru.itis;

public class ex30a {
    // задание 30а
    public static void main(String[] args) {
        double a = 1.0, b = 1.1, x0,xn,f1, f2, eps = 0.0001;

        if ((a*a*a*a*a - a - 0.002)*(20*a*a*a) > 0) {
            x0 = a;
        }
        else {
            x0 = b;
        }
        f1 = x0*x0*x0*x0*x0 - x0 - 0.002;
        f2 = 5*x0*x0*x0*x0 - 1;


        xn = x0 - f1/f2;
        System.out.print(xn);


        while (Math.abs(xn- x0) > eps){
            x0 = xn;
            f1 = x0*x0*x0*x0*x0 - x0 - 0.002;
            f2 = 5*x0*x0*x0*x0 - 1;
            xn = x0 - f1/f2;

        }
        System.out.print(xn);

    }
}
