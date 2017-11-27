package ru.itis;

public class ex22d
        // задание 22 д
{
    public static void main(String[] args) {
        int[] a = {1, 3, 2, 3};
        int k = 0;
        boolean f;


        for( int i = 0; i < a.length ; i++) {
            f = true;
            for (int j = 0; j <a.length && f ; j++) {
                if (i != j) {
                    if (a[i] == a[j]) f = false;
                }
            }
            if (f) k++;
        }
        System.out.println(k);


    }
}
