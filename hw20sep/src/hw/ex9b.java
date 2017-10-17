package hw;

import java.util.Scanner;

public class ex9b {
    //упражнение 9 б
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i = 2;
        double m = 0.5, sum;
        sum = m;


        while (i <= n){
            m *= 1.0*((i-1)*(i-1))/(2*i*(2*i - 1));
            sum += m;
            i++;
        }
        System.out.print(sum);


    }
}
