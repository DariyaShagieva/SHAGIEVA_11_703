package ru.itis;

public class Vector2D {
    private double x,y;
    Vector2D(){
        x = 0;
        y = 0;
    }
    Vector2D(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }

    public void setX(double x) { this.x = x; }

    public double getY() { return y; }

    public void setY(double y) { this.y = y; }

    Vector2D add (Vector2D vector2D){
        return new Vector2D(x + vector2D.x, y + vector2D.y);
    }

    public void add2(Vector2D vector2D){
        x += vector2D.x;
        y += vector2D.y;
    }

    Vector2D sub ( Vector2D vector2D){
        return new Vector2D( x - vector2D.x, y - vector2D.y);
    }

    public void sub2(Vector2D vector2D){
        x -= vector2D.x;
        y -= vector2D.y;
    }

    Vector2D mult(double a){
        return  new Vector2D(x*a, y*a);
    }

    public void mult2(double a){
        x *= a;
        y *= a;
    }

    @Override
    public String toString() {
        return ("(" + x + ";" + y + ")");
    }


    public double lenght(){
        return Math.sqrt(x*x + y*y);
    }

    public double scalarProduct( Vector2D vector2D){
        return (x * vector2D.x + y*vector2D.y);
    }

    public double cos( Vector2D vector2D){
        return (scalarProduct(vector2D) / (this.lenght() * vector2D.lenght()));
    }

    public boolean eguals (Vector2D vector2D){
        return ((x == vector2D.x) && (y == vector2D.y) && (this.lenght() == vector2D.lenght()));
    }

}
