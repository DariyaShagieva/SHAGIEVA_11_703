package ru.itis;

public class ex2 {
    //2.	Дан массив, состоящих из различных чисел.
    // Найти сумму элементов, расположенных между его максимальным и минимальным элементов.
    // Сами элементы не учитываются.
    public static void main(String[] args) {
        int[] a = {16, 45,335,56,7,35,55,4,57,11,9};
        int max = a[0], min = a[0], kmin = 0, kmax = 0,b, c, sum = 0;
        for (int i = 1; i < a.length; i++){
            if (a[i] < min) {
                min = a[i];
                kmin = i;
            }
            if (a[i] > max){
                max = a[i];
                kmax = i;
            }

        }
        if (kmin > kmax){
            c = kmin;
            b = kmax;
        }
        else {
            c = kmax;
            b = kmin;
        }
        for ( int i = b+1; i < c; i++){
            sum += a[i];
        }

        
        System.out.print(sum);
    }
}
