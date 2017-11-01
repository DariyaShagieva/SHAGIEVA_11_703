package ru.itis;

public class ex8a {
    public static void main(String[] args) {
        int[] t1 = {1, 0, 0, 1, 0, 1, 1, 1, 0};
        int k = 0;
        for (int i = 0; i < t1.length; i++){
            System.out.print(t1[i] + " ");
            k += t1[i];
        }
        System.out.println();
        System.out.println(k);
    }
}
