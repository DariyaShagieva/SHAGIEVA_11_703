package ru.itis;

public class MusicShop {
    private int n = 3;
    private Object [][] place = new Object[n][n];

    MusicShop(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n ; j++) {
                place[i][i] = "";

            }

        }
    }
    public  void makePlace(Object object, int n, int m){
        if(place[n][m] != "") place[n][m] = object;
    }

    public void hello(){
        System.out.println("Привет, добро пожаловать!");
    }

    public void showMusicalInst (){
        for (int i = 0; i < n; i++) {
            int t = i + 1;
            System.out.println(t + " полка");
            for (int j = 0; j < n; j++) {
                int k = j + 1;
                System.out.println("место " + k);
                System.out.println(place[i][j]);
            }

        }
    }



}
