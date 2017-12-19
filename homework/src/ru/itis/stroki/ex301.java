package ru.itis.stroki;

import java.util.Scanner;

public class ex301 {
    public static String letter(char a){
        char[] glas = {'a', 'e', 'i', 'o', 'u', 'y'};
        boolean f = false;
        for (int i = 0; i < glas.length && !f; i++) {
            if(a == glas[i]) f = true;
        }
        if(f) return "гласная";
        else return "согласная";
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int k = 1;
        boolean f = true;
        for (int i = 0; i < str.length() - 1 && f; i++) {
            if (letter(str.charAt(i)) == letter(str.charAt(i + 1))) {
                k++;
                if (k > 2) f = false;
            }
            else k = 1;
        }
        if (f) System.out.println(str + " - слово благозвучное");
        else {
            System.out.println(str + " - слово неблагозвучное");
            k = 0;
            double t = 1;
            for (int i = 0; i < str.length() - 1; i++) {
                if(letter(str.charAt(i)) == letter(str.charAt(i + 1))) t++;
                else{
                  if (t % 2 < 0.0001) k += t / 2 - 1;
                  else k += t/2;
                  t = 1;
                }
            }
            System.out.println(k + " - минимальное количество букв, которых нужно вставить, чтобы слово стало благозвучным");
        }

    }
}
