package ru.itis;

public class ex22v {
    // задание 22 в
    public static void main(String[] args) {
        int[] a = {7, 6, 5, 3, 2,1};
        boolean f = true;
        for(int i = 0; i < a.length-1 &f; i++){
            if (a[i] > a[i + 1]) f = false;
        }
        if (f) System.out.println(" упорядочен по возрастанию");
        else {
            f = true;
            for (int i = 0; i < a.length - 1 &f; i++){
                if ( a[i] < a[i + 1 ]) f = false;
            }
            if (f) System.out.println(" упорядочен по убыванию");
            else System.out.println(" не упорядочен");
        }
    }
}
