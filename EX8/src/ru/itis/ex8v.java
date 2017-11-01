package ru.itis;

public class ex8v {
    public static void main(String[] args) {
        int [] t1 = {1, 1, 0, 0, 0, 1};
        int [] t2 = {1, 0, 0, 1, 0, 1};
        int [] ob = new int[t1.length];
        int [] per = new int[t1.length];
        int [] raz = new int[t1.length];

        for ( int i = 0; i < t1.length; i++){
            System.out.print(t1[i] + " ");
        }
        System.out.println();
        for ( int i = 0; i < t2.length; i++){
            System.out.print(t2[i] + " ");
        }
        System.out.println();
        System.out.println("объединение t1 и t2");
        for ( int i = 0; i < ob.length; i++){
            if (t1[i] == 1 || t2[i] == 1) ob[i] = 1;
            System.out.print(ob[i] + " ");
        }
        System.out.println();
        System.out.println("пересечение t1 и t2");
        for ( int i = 0; i < per.length; i++){
            if (t1[i] == 1 & t2[i] == 1) per[i] = 1;
            System.out.print(per[i] + " ");
        }
        System.out.println();
        System.out.println(" разность между t1 и t2");
        for ( int i = 0; i < raz.length; i++){
            if(t1[i] == 1 & t1[i] != t2[i]) raz[i] = 1;
            System.out.print(raz[i] + " ");
        }




    }
}
