package hw;//-

import java.util.Scanner;

public class ex9c {
    // задание 9в
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = 1, p = 1;
        int n = scanner.nextInt();
        double t = 1, sum = 1;
        while (i <= n){
            p = -p;
            t *=1.0*(2*i-1)/((2*i+1)*3);
            sum += p*t;
            i++;

        }
        System.out.print(sum);

    }
}
