package ru.itis;

public class ex4 {
    // задание 4дд
    public static void main(String[] args) {

        double[] x = {-0.5, -5.4, 4.5};
        int n = 27;
        double f, u0 = 1, un = 0;
        for (int i = 0; i < x.length; i++){
            f = Math.log(1 + x[i] + (x[i]*x[i]))/(2+x[i]*x[i]);
            for (int j = 0; j < n; j++){
                un = 2.0/3*u0 + f/(3*u0*u0);
                u0 = un;

            }
            System.out.println("y" + (i + 1) + " равен " + un );
        }
    }
}
