package ru.itis;

public class Main {

    public static void main(String[] args) {
        MusicShop musicShop = new MusicShop();
        Violin violin1 = new Violin("Скрипка маленькая", 1500);
        Violin violin2 = new Violin("Скрипка большая", 3000);
        Piano piano = new Piano("Просто пианино", 10000);
        Guitar guitar = new Guitar("Гитарка твоей мечты", 2300);
        Cello cello = new Cello("Виолончель", 400000);
        musicShop.makePlace(violin1,0,2);
        musicShop.makePlace(violin2,1,0);
        musicShop.makePlace(piano,2,0);
        musicShop.makePlace(guitar,0,1);
        musicShop.makePlace(cello,1,2);
        musicShop.hello();
        System.out.println("Здравствуйте! Что у вас есть?");
        musicShop.showMusicalInst();
        System.out.println("Можно послушать, как играет гитара?");
        System.out.println("да, конечно");
        guitar.playMelody();


    }
}

