package ru.itis;

public class ex7 {
    public static void main(String[] args) {
        int n = 1;
        double p = 1;
        double e = 0.01;
        double pi = 3.1415926;

        while (Math.abs(p-(pi/2.0)) > e){
            p *= (2*n/(1.0*(2*n-1))*2*n/(1.0*(2*n+1)));
            n++;
        }
        System.out.print(n-1);
    }
}
