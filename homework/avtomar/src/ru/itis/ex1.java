package ru.itis;

import java.util.Scanner;

public class ex1 {
    public static boolean goodWord(String str){
        boolean f = true;
        int state = 0;
        for(int i = 0; i < str.length() && f && state < 2; i++){
            switch (state){
                case 0:
                    if(str.charAt(i) == '1') state++;
                    break;
                case 1:
                    if(str.charAt(i) == '0') state++;
                    break;
            }
        }
        if (state == 2) return true;
        else return false;
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
