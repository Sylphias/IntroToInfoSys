package ProblemSet2;

/**
 * Created by Ilya on 19/9/16.
 */
public class Octagon implements Comparable<Octagon> {
    private double side;
    public Octagon(double side){
        this.side = side;
    }
    public double getSide() {
        return side;
    }

    public int compareTo(Octagon x) {
        if(x.getSide() <  this.getSide()){
            return 1;
        }
        else if(x.getSide() == this.getSide()){
            return 0;
        }
        else{
            return -1;
        }
    }
}
