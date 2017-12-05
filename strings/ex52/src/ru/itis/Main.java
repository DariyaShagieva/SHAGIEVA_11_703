package ru.itis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = new String();
        String s2 = new String();
        s1 = scanner.nextLine();
        s2 = scanner.nextLine();
        boolean f = false;
        int j = 0;
        for (int i = 0; i < s1.length() && f; i++) {
            if (s1.charAt(i) == s2.charAt(j) && j < s2.length() ){
                j++;
            }
            else j = 0;
            if (j == (s2.length() - 1)) f = true;
        }

        System.out.println(f);
    }
}
