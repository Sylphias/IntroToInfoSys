package ProblemSet2;

/**
 * Created by Ilya on 19/9/16.
 */
public class LinearEquation {
    private double a,b,c,d,e,f;

    public LinearEquation(double a, double b, double c, double d, double e, double f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getD() {
        return d;
    }

    public double getE() {
        return e;
    }

    public double getF() {
        return f;
    }

    public boolean isSolvable(){
        if((a*d-b*c)!= 0){
            return true;
        }
        return false;
    }
    // Using Cramers rule, go back and read up to understand
    public double getX(){
        return (e*d - f*b)/(a*d - b*c);
    }

    public double getY(){
        return (a*f - c*e)/(a*d - b*c);
    }
}
