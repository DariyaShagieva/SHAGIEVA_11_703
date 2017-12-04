package ru.itis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = new String();
        String s2 = new String();
        s1 = scanner.nextLine();
        s2 = scanner.nextLine();
        boolean f = true;
        if (s1.length() != s2.length()) f = !f;
        else {
            for (int i = 0; i < s1.length() && f ; i++) {
                if (s1.charAt(i) != s1.charAt(i)) f = !f;
            }
        }
        System.out.println(f);
    }
}
