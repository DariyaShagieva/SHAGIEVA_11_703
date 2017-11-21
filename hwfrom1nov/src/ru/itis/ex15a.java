package ru.itis;

public class ex15a {
    // задание 15 а
    public static void main(String[] args) {
        int[] x = {1, 3, 3, 4, 5, 6, 2, 4, 5, 1, 3, 6, 7, 8, 9, 10, 1};
        int t = 0 , s = x.length, k = 1;
        for ( int i = 0; i < x.length - 1; i++) {
            if (x[i] <= x[i + 1]) k++;
            else {
                if (k < s) s = k;
                if (k > t) t = k;
                k = 1;
            }

        }
        if ( k < s) s = k;
        if ( k > t) t = s;
        System.out.println("самая короткая цепочка = " + s);
        System.out.println("самая длинная цепочка = " + t);

    }
}

