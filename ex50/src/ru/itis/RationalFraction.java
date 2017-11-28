package ru.itis;


public class RationalFraction {
    private int chisl;
    private int znam;

    public int getChisl() { return chisl; }

    public void setChisl(int chisl) {this.chisl = chisl;}

    public int getZnam() {return znam;}

    public void setZnam(int znam) {
        if (znam != 0) {
            this.znam = znam;
        }
        else{this.znam = 1;}
    }
    public  RationalFraction(){
        this.chisl = 0;
        this.znam = 1;
    }
    public RationalFraction(int a, int b){
        this.setChisl(a);
        this.setZnam(b);
    }
    private int calcNod(int x, int y){
        while ( x!= 0 && y!= 0){
            if ( x > y) x = x % y;
            else y = y % x;
        }
        return Math.max(x,y);
    }
    public void reduce (){
        int nod = calcNod(this.chisl, this.znam);
        this.chisl /= nod;
        this.znam /= nod;
    }
    private void commonZnam (RationalFraction fraction){
        if (this.znam != fraction.znam) {
            int t = this.znam;
            this.znam *= fraction.znam;
            this.chisl *= fraction.znam;
            fraction.znam *= t;
            fraction.chisl *= t;
        }
    }
    public RationalFraction add (RationalFraction fraction){
        this.commonZnam(fraction);
        int a = this.chisl + fraction.chisl;
        this.reduce();
        fraction.reduce();
        return new RationalFraction(a, this.znam);
    }
    public void add2 (RationalFraction fraction){
        this.commonZnam(fraction);
        fraction.chisl += this.chisl;
        fraction.reduce();
        this.reduce();
    }
    public RationalFraction sub(RationalFraction fraction){
        this.commonZnam(fraction);
        int a = this.chisl - fraction.chisl;
        this.reduce();
        fraction.reduce();
        return new RationalFraction(a, this.znam);
    }
    public void sub2(RationalFraction fraction){
        this.commonZnam(fraction);
        fraction.chisl -= this.chisl;
        fraction.reduce();
        this.reduce();
    }
    public RationalFraction mult (RationalFraction fraction){
        RationalFraction rationalFraction = new RationalFraction();
        rationalFraction.chisl = this.chisl * fraction.chisl;
        rationalFraction.znam = this.znam * fraction.znam;
        rationalFraction.reduce();
        return rationalFraction;
    }
    public void mult2(RationalFraction fraction){
        fraction.chisl *= this.chisl;
        fraction.znam *= this.znam;
        fraction.reduce();
    }
    public RationalFraction div(RationalFraction fraction){
        RationalFraction rationalFraction = new RationalFraction();
        rationalFraction.chisl = this.chisl * fraction.znam;
        rationalFraction.znam = this.znam * fraction.chisl;
        rationalFraction.reduce();
        return rationalFraction;
    }
    public void div2(RationalFraction fraction){
        fraction.chisl *= this.znam;
        fraction.znam *= this.chisl;
        fraction.reduce();
    }

    @Override
    public String toString() {
        return (chisl + "/" + znam);
    }

    public double value (){
        return (1.0*chisl/znam);
    }

    public boolean equals(RationalFraction fraction){
        return (this.value() == fraction.value());
    }
    public int numberPart(){
        return (chisl % znam);
    }
}
