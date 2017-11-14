package ru.itis;//-

public class ex15a {
    // задание 15 а
    public static void main(String[] args) {
        int[] x = {1, 3, 3, 4, 5, 6, 2, 4, 3, 1, 3, 6};
        int t = 0 , s = x.length, k = 1;
        for ( int i = 0; i < x.length - 1; i++){
            if(x[i] <= x[i+1]) k++;
            else {
                if (k < s) s = k;
                if (k > t) t = k;
                k = 1;
            }

        }
        System.out.println("самая короткая цепочка = " + s);
        System.out.println("самая длинная цепочка = " + t);

    }
}
//int[] x = {1, 3, 3, 4, 5, 6, 2, 4, 5, 1, 3, 6, 1};
//самая короткая цепочка = 3
//самая длинная цепочка = 6    это неверно
