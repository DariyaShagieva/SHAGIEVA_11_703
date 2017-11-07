package ru.itis;

public class ex22d
        // задание 22 д
{
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 2, 3, 6, 5 ,3 ,7, -1};
        int k = 0;
        for(int i = a.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
            if( a[j] > a[j+1] ){
                int t = a[j];
                a[j] = a[j+1];
                a[j+1] = t;
            }
        }
        }
        if (a[1] != a[2]) k++;
        if (a[a.length - 1] != a[a.length -2]) k++;


        for( int i = 1; i < a.length - 1; i++) {
            if (a[i] != a[i-1] && a[i] != a[i+1]) k++;

        }
        System.out.println(k);


    }
}
