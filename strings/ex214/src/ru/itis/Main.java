package ru.itis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
	    String s = new String();
	    s = scanner.nextLine();
	    String[] str = s.split(" ",);
        for (int i = 0; i <str.length ; i++) {
            if (str[i].charAt(0) == str[i].charAt(str[i].length()-1)) System.out.println(str[i]);
        }

    }
}

