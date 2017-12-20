package ru.itis.stroki;//-

import java.util.Scanner;

public class ex232 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int k = 0;
        boolean f;
        for (int i = 0; i < str.length(); i++) {
            f = true;
            for (int j = 0; j < str.length() && f  ; j++) {
                if (i != j) if(str.charAt(i) == str.charAt(j)) f = false;
            }
            if(f) k++;
        }
        System.out.println(k);   //where the symbols

    }
}
