package ru.itis;

public class ex15b {
    // задание 15 б
    public static void main(String[] args) {
        int[] x = {1, 3, 3, 4, 5, 6, 2, 4, 3, 1, 3, 6};
        int[] u = new int[x.length];
        int k = 1;
        for (int i = 0; i < x.length - 1; i++){
            if (x[i] <= x[i+1]) k++;
            else {
                u[k - 1]++;
                k = 1;
            }
        }
        u[k - 1]++;
        for (int i = 0; i < x.length; i++){
            System.out.print(u[i] + " ");
        }

    }
}
