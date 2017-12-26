package ru.itis;//-

import java.util.Scanner;

public class ex7 {
    public static boolean goodWord(String str){
        int state = 0;
        int k0 = 0, k1 = 0;
        for (int i = 0; i < str.length() ; i++) {
            switch (state){
                case 0:
                    if (str.charAt(i) == '1'){
                        state++;
                        k1++;                       //no calculations
                    }
                    else k0++;
                    break;
                case 1:
                    if (str.charAt(i) == '0'){
                        state--;
                        k0++;      
                    }
                    else k1++;
                    break;

            }

        }
        if (k0 % 3 == 0 && k1 % 2 == 1) return true;
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
