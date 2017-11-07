package ru.itis;

public class ex1 {
    // задание 1ккк
    public static void main(String[] args) {
        double [] a = {-3, 17.01, 8};
        double h = 0.952, f = 1, y, u = -1, x;
        int n = 6, b = 2;
        for ( int i = 0; i < a.length; i++){
            for ( int j = 0; j < n; j++){
                x = b + j*h;
                y = 0.8 + 2 * Math.sin(x) - 5.5*Math.sin(a[i])*Math.sin(a[i]);
                f *= Math.abs(y);
                if (Math.abs(y) > u) u = Math.abs(y);
            }
            System.out.println(" фи = " + f + " пси = " + u);


        }

    }
}
