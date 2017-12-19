package ru.itis;

import java.util.Scanner;

public class ex5 {
    public static boolean goodWord(String str){
        int state = 0;
        boolean f = true;
        for (int i = 0; i < str.length() && f; i ++){
            switch (state) {
                case 0:
                    state++;
                    break;
                case 1:
                    state++;
                    break;
                case 2:
                    if (str.charAt(i) == '0') state = 0;
                    else f = false;
                    break;
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
