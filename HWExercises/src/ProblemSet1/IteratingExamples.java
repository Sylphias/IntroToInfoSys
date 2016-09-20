/**
 * Created by Ilya on 18/9/16.
 */

package ProblemSet1;
import java.util.*;


public class IteratingExamples {
    public static void main(String []args){
        List<Integer> lol = new ArrayList<>();
        lol.add(1);
        lol.add(2);
        System.out.println(Act2Iterator(lol));
    }

    public static int Act2Iterator(List<Integer> integers) {
        int total = 0;
        for(Iterator<Integer> iter = integers.iterator(); iter.hasNext();){
            total += iter.next();
        }
        return total;

    }

    public static int Act2ForEach(List<Integer> integers) {
        int total = 0;
        for(int i: integers){
            total += i;
        }
        return total;
    }
}