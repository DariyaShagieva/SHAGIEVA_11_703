package ru.itis;

import java.util.Scanner;

public class ex11c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double p = 1;
        for (int i = 1; i <= n; i++){
            p *=(Math.tan(i)); // нет там тангенсов
        }
        System.out.print(p);
    }
}
