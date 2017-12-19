package ru.itis;

public class MusicalInstrument {
    protected String name;
    protected int price;
    MusicalInstrument (){
        name = "";
        price = 0;
    }
    MusicalInstrument (String name,int price){
        this.name = name;
        this.price = price;
    }


}

