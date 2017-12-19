package ru.itis.stroki;

import java.util.Scanner;

public class ex234 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean f = false;
        String str = new String();
        while (!f){
            System.out.println("Введите число в двоичной системе:");
            str = scanner.nextLine();
            for (int i = 0; i < str.length() ; i++) {
                if (str.charAt(i) != '0' && str.charAt(i) != '1' ) f = true;

            }
            if (f) {
                System.out.println("Ошибка!Повторите ввод");
                f = false;
            } else {
                f = true;
            }
        }
        System.out.println(perevod(str));
    }

    private static long perevod(String str) {
        int summ = 0;
        for (int i = str.length() - 1, st_dvoiki = 1; i >= 0; i--, st_dvoiki *= 2) {
            if (str.charAt(i) == '1') summ += st_dvoiki;
        }
        return summ;
    }
}
