package ProblemSet1;

/**
 * Created by Ilya on 18/9/16.
 */
public class MyRectangle2D {
    private double x, y, width, height;
    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public MyRectangle2D() {
        this.x = 0;
        this.y = 0;
        this.height = 1;
        this.width = 1;
    }

    public MyRectangle2D(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double getArea(){
        return width*height;
    }

    public double getPerimeter(){
        return width*2 + height*2;
    }

    public boolean contains(double x, double y){
        double half_height = this.height/2;
        double half_width = this.width/2;
        if (((x>(this.x-half_width)) && (x<(this.x+half_width))) && ((y>this.y-half_height) && (y < this.y+half_height))){
            return true;
        }
            return false;
    }

    public boolean contains(MyRectangle2D r){
        double half_height = r.getHeight()/2;
        double half_width = r.getWidth()/2;
//        if the rectangle contains all 4 corners of the inner rect, then the inner rect is inside the bigger rect
        if (this.contains(r.getX()-half_width,r.getY()-half_height) && this.contains(r.getX()+half_width,r.getY()-half_height) && this.contains(r.getX()-half_width,r.getY()+half_height) && this.contains(r.getX()+half_width,r.getY()+half_height)){
            return true;
        }
        return false;
    }

    public boolean overlaps(MyRectangle2D r){
        double half_height = r.getHeight()/2;
        double half_width = r.getWidth()/2;
//        if the rectangle contains one of the  4 corners of the inner rect, then the inner rect overlaps the bigger rect
        if (this.contains(r.getX()-half_width,r.getY()-half_height) || this.contains(r.getX()+half_width,r.getY()-half_height) || this.contains(r.getX()-half_width,r.getY()+half_height) || this.contains(r.getX()+half_width,r.getY()+half_height)){
            return true;
        }
        return false;
    }

}
