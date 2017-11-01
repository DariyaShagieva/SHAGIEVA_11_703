package ru.itis;

public class ex8b {
    public static void main(String[] args) {
        int [] t1 = {1, 0, 1, 0, 1, 1, 0};
        int [] t2 = {1, 1, 1, 1, 1, 1, 0};
        boolean f = true;
        for ( int i = 0; i < t1.length; i++){
            System.out.print(t1[i] + " ");
        }
        System.out.println();
        for ( int i = 0; i < t2.length; i++){
            System.out.print(t2[i] + " ");
        }
        System.out.println();
        for ( int i = 0; i < t1.length & f; i++){
            if (t1[i] > t2[i]) f = false;
        }
        if (f) System.out.println("Множество t2 включает множество t1");
        else System.out.println("Множество t2 не включает множество t1");


    }
}
