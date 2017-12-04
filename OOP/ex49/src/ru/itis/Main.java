package ru.itis;

public class Main {

    public static void main(String[] args) {
	Vector2D vector2D = new Vector2D(5, 8);
	Vector2D vector2D1 = new Vector2D(9, 10);
	System.out.println(vector2D);
	vector2D.sub2(vector2D1);
	System.out.println(vector2D);
    }
}
