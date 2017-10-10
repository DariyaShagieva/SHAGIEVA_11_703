package hw;

import java.util.Scanner;
public class ex9a {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = 1, p = 1, n;
        double s = 1;
        n = in.nextInt();
        while (i < n){
            i++;
            p = - p;
            s = s + p*(1.0/ (i*i));  //i*i в знаменателе

        }
        System.out.print(s);
    }
}

