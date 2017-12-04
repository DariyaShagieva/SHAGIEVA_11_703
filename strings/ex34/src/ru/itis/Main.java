package ru.itis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = new String();
        n = scanner.nextLine();
        char max = 0;
        for (int i = 0; i < n.length() ; i++) {
            if (n.charAt(i) > max ) max = n.charAt(i);
        }
        System.out.println(max);
    }
}
