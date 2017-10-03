package hw;

import java.util.Scanner;

public class ex9g {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, i = 0,p =1;
        double s = 1;
        n = in.nextInt();
        while (i < n){
            i++;
            p = p*9;
            s = s + 1.0/((2*i+1)*p);
        }
        System.out.print(s);
    }
}
