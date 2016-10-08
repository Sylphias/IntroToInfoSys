package ProblemSet4;

/**
 * Created by Ilya on 4/10/16.
 */
public class TestScores {
    public static void testScores(double[] s){
        for(int i = 0 ; i < s.length ; i++) {
            if (s[i] < 0 || s[i] > 100) {
                throw new IllegalArgumentException("Element:" + i + " Score:" + s[i]);
            }
        }
    }
}
