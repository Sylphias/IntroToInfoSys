package Quiz2_2015;

/**
 * Created by Ilya on 19/10/16.
 */
public class NoWhere extends Exception {
    static void test() {
        throw new NullPointerException();
    }


    public static void main(String[] args) {
        try  {
            test();
        }
        catch (NullPointerException ex) {
            System.out.println("Error: " + ex);
            ex.printStackTrace();
        }
    }

}

