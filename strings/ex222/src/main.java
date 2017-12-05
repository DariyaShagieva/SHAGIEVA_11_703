

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] str = s.split(" ");
        int k = 0;
        for (int i = 0; i < str.length ; i++) {
            boolean f = true;
            for (int j = 0; j <str[i].length()/2 && f; j++) {
                if (str[i].charAt(j) != str[i].charAt(str[i].length() - 1 - j)) f = false;
            }

            if(f) k++;
        }
        System.out.println(k);
    }
}
