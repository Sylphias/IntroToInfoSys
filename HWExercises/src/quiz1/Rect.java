package quiz1;
import ProblemSet2.GeometricObject;
/**
 * Created by Ilya on 26/9/16.
 */
public class Rect extends GeometricObject{
    private double  width, height;
    public Rect(){
        width  = 1.0;
        height = 1.0;
    }
    public Rect(double width, double height){
        this.width = width;
        this.height = height;
    }
    public double getArea(){
        return width * height;
    }
    public String toString(){
        return "Rectangle: width = "+width+" height = "+height;
    }
}
