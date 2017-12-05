package ru.itis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
	    String s = scanner.nextLine();
	    boolean f = false;
        for (int i = 0; i <s.length() && !f ; i++) {
            if(s.charAt(i)%2 < 1 || s.charAt(i) < 1 ) f = true;

        }
        if (f) System.out.println("такие цифры есть");
        else System.out.println("таких цифр нет");
    }
}
