package ru.itis;

public class ex13g {
    // задание 13 г
    public static void main(String[] args) {

        int[] x = {1, 3, 3, 4, 5, 5, 5, 5, 5, 6, 7, 8, 8, 8, 9};
        int[] u = new int[x.length];
        int k = 1, m = 0;
        for (int i = 0; i < x.length-1; i++ ) {
            if (x[i] == x[i + 1]) k++;
            else {
                u[m] = k;
                k = 1;
                m++;
            }
        }
        u[m] = k;
        for (int i = 0; i < u.length; i++){
            System.out.print(u[i] + " ");
        }
    }
}
