package Quiz2_2015;

/**
 * Created by Ilya on 19/10/16.
 */
public class InvalidTest extends Exception {
    public InvalidTest() {
        super("Score negative or bigger than 100:");
    }

    public InvalidTest(String message) {
        super("Score negative or bigger than 100: " + message);
    }
    public static void testScores(double[] s) throws InvalidTest
    {
        for(double x  : s){
            if(x<0){
                throw new InvalidTest(Double.toString(x));
            }
        }

    }

}
