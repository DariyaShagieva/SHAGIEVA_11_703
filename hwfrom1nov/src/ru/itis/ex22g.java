package ru.itis;

public class ex22g {
    // задание 22 г
    public static void main(String[] args) {
        int [] a = {1,2,3,5,6};
        boolean f = false;
        for (int i = 0; i < a.length-1 & !f; i++){
            for (int j = i+1; j < a.length & !f; j++){
                if (a[i] == a[j]) f = true;
            }
        }
        if (f) System.out.println("есть");
        else System.out.println("нет");
    }
}
