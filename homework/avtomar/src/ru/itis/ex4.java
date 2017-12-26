package ru.itis;//-

import java.util.Scanner;

public class ex4 {
    public static boolean goodWord(String str){
        int state = 0;
        boolean f = true;
        int k = 1;
        for (int i = 0; i < str.length() && f; i++) {
            switch (state){
                case 0:
                    if (str.charAt(i) == '1') state = 1;
                    break;
                case 1:
                    if (str.charAt(i) == '0') state = 2;
                    break;
                case 2:
                    if (str.charAt(i) == '0') k++;    //no calculations! Only automaton
                    else{
                        if (k % 2 != 0) f = false;
                        else {
                            state = 1;
                            k = 1;
                        }
                    }
            }

        }
        return f;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] str = s.split(" ");
        for (int i = 0; i < str.length; i++) {
            if (goodWord(str[i])) System.out.println(str[i] +" принято автоматом ");
            else System.out.println(str[i] + " не принято автоматом" );

        }
    }
}
