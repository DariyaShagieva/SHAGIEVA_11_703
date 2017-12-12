package ru.itis;


import java.util.Scanner;
public class Main {

    public static boolean isGoodWordBySwitch(String ar) {
        char array[] = ar.toCharArray();
        boolean isNotFiniteState = true;
        int state = 0;
        int i = 0;
        while (isNotFiniteState && i < array.length) {
            switch (state) {
                case 0:
                    if (array[i] == 'б') {
                        state++;
                        i++;
                    } else {
                        isNotFiniteState = false;
                    }
                    break;
                case 1:
                    if (array[i] == 'э') {
                        state++;
                        i++;
                    } else {
                        isNotFiniteState = false;
                    }
                    break;
                case 2:
                    if (array[i] == 'э') {
                        state++;
                        i++;
                    } else {
                        isNotFiniteState = false;
                    }
                    break;
                case 3:
                    if (array[i] == 'э') i++;
                    else {
                        state++;
                    }
                    break;

                case 4:
                    if (array[i] == '!' && i == array.length - 1) i++;
                    else {
                        isNotFiniteState = false;
                    }
                    break;
            }
        }
        if (state != 4) isNotFiniteState = false;
        return isNotFiniteState;
    }




    public static void main(String[] args) {

        String words[] = {"бээ!", "б", "", "бэээээ!", "бэ", "!"};
        for (int i = 0; i < words.length ; i++) {
            System.out.println(isGoodWordBySwitch(words[i]));

        }

    }
}
