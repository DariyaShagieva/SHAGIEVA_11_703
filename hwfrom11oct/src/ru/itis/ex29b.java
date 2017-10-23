package ru.itis;//+

public class ex29b {
    public static void main(String[] args) {
        double x0 = 0, x1, e = 0.0001;
        int n = 1;
        x1 = Math.cos(x0);
        while (Math.abs(x1 - x0) > e) {
            x0 = x1;
            x1 = Math.cos(x0);
            n++;
        }
        System.out.print(n);

    }
}
