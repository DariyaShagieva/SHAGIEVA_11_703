package ru.itis;

public class ex3 {
    //3.	Найти произведения не равных 0 элементов, стоящих за максимальным элементов.
    public static void main(String[] args) {
        int[] a = {1, 4, 6, 7, 3, 4, 2, 9, 4, 5, 5, 3};
        int max = a[0], k = 0, p = 1;
        for (int i = 1; i < a.length; i++){
            if ( a[i] > max){
                max = a[i];
                k = i;
            }
        }
        for (int i = k + 1; i < a.length; i++){
            p *= a[i];
        }
        System.out.print(p);
    }

}
