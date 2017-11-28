package ru.itis;

public class Main {

    public static void main(String[] args) {
	    RationalFraction fraction = new RationalFraction(55, 10);
        RationalFraction fraction1 = new RationalFraction(3, 7);
        RationalFraction fraction2 = fraction.mult(fraction1);
        System.out.println(fraction2);
        System.out.println(fraction.value());
        System.out.println(fraction.numberPart());

    }

}
