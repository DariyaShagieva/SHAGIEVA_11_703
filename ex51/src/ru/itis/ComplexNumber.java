package ru.itis;

public class ComplexNumber {
    private double a, b;
    ComplexNumber(){
        this.a = 0;
        this.b = 0;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    ComplexNumber(double a, double b){
        this.setA(a);
        this.setB(b);
    }
    public ComplexNumber add (ComplexNumber number){
        ComplexNumber complexNumber = new ComplexNumber();
        complexNumber.a = this.a + number.a;
        complexNumber.b = this.b + number.b;
        return  complexNumber;
    }
    public void add2(ComplexNumber number){
        number.a += this.a;
        number.b += this.b;
    }
    public ComplexNumber sub (ComplexNumber number){
        ComplexNumber complexNumber = new ComplexNumber();
        complexNumber.a = this.a - number.a;
        complexNumber.b = this.b - number.b;
        return complexNumber;
    }
    public void sub2(ComplexNumber number){
        number.a -= this.a;
        number.b -= this.b;
    }
    public ComplexNumber multNumber (double x){
        ComplexNumber complexNumber = new ComplexNumber();
        complexNumber.a = this.a * x;
        complexNumber.b = this.b * x;
        return complexNumber;
    }
    public void multNumber2 (double x){
        this.setA(this.a * x);
        this.setB(this.b * x);
    }
    public ComplexNumber mult (ComplexNumber number){
        ComplexNumber complexNumber = new ComplexNumber();
        complexNumber.a = this.a*number.a - this.b*number.b;
        complexNumber.b = this.a*number.b + this.b*number.a;
        return complexNumber;
    }
    public void mult2 (ComplexNumber number){
        double a = number.a;
        double b = number.b;
        number.a = this.a*a - this.b*b;
        number.b = this.a*b + this.b*a;
    }

    public ComplexNumber div (ComplexNumber number){
        ComplexNumber complexNumber = new ComplexNumber();
        complexNumber.a = (this.a * number.a + this.b * number.b)/(number.b*number.b + number.a*number.a);
        complexNumber.b = (this.b * number.a + this.a * number.b)/(number.b*number.b + number.a*number.a);
        return complexNumber;
    }
    public void div2 (ComplexNumber number){
        double a = number.a;
        double b = number.b;
        number.a = (this.a * a + this.b * b)/(b*b + a*a);
        number.b = (this.b * a + this.a * b)/(b*b + a*a);
    }

    public double lenght (){
        return Math.sqrt(a * a + b * b);
    }
    public double arg (){
        return Math.atan(a/b);
    }
    public ComplexNumber pow (double n){
        ComplexNumber complexNumber = new ComplexNumber();
        complexNumber.a = Math.pow(Math.abs(this.lenght()),n) * Math.cos(this.arg()*n);
        complexNumber.b = Math.pow(Math.abs(this.lenght()),n) * Math.sin(this.arg()*n);
        return complexNumber;
    }
    public boolean equals (ComplexNumber number){
        return ((this.a == number.a) && (this.b == number.b));
    }

    @Override
    public String toString() {
        if ( a > 0) return (b + " * i" + " + " + a);
        else return (b + " * i " + a);
    }
}
