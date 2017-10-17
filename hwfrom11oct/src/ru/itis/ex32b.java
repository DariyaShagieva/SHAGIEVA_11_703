package ru.itis;

public class ex32b {
    // задание 32 б
    public static void main(String[] args) {
        double eps = 0.0001, a = 0, x0,xn;
        x0 = 1;
        xn = -Math.log(x0+3);
        while (Math.abs(xn-x0) > eps){
            x0 = xn;
            xn = - Math.log(x0 +3);

        }
        System.out.println(xn);
    }
}
