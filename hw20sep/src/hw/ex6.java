package hw;

import java.util.Scanner;

public class ex6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, p = 1, i = 1;
        double g = 1;
        n = in.nextInt();
        while (i < n){
            i++;
            p = -p;
            g = g + p*(1.0/Math.pow((2*i-1), 2));
        }
        System.out.print(g);
    }
}
