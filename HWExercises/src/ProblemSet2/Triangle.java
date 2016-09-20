package ProblemSet2;

/**
 * Created by Ilya on 19/9/16.
 */
public class Triangle extends GeometricObject{
    double side1;
    double side2;
    double side3;

    public Triangle() {
        this.side1 = 1.0;
        this.side2 = 1.0;
        this.side3 = 1.0;
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    public double getPerimeter(){
        return side1 + side2 + side3;
    }
    // Using Heron's Formula
    public double getArea(){
        double p = getPerimeter()/2.0;
        return Math.sqrt(p*(p-side1)*(p-side2)*(p-side3 ));
    }
    public String toString(){
        return "Triangle: side1 = "+side1+" side2 = "+side2+" side3 = "+side3;
    }
}
