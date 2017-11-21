package ru.itis;

public class ex22d
        // задание 22 д
{
    public static void main(String[] args) {
        int[] a = {1, 3, 3, 4, 5, 6, 2, 4, 3, 1, 3, 6};
        int k = 0,z = 0;


        for( int i = 0; i < a.length ; i++) {
            for (int j = 0; j <a.length ; j++) {
                if (i != j) {
                    if (a[i] != a[j]) k++;
                }
            }
            if (k == a.length-1) z++;
            k = 0;
        }
        System.out.println(z);


    }
}
