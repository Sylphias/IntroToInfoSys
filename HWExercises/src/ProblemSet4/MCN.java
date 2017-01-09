package ProblemSet4;

/**
 * Created by Ilya on 17/10/16.
 */
public class MCN {
    public static void main(String[] args) {
        System.out.println(mcn(4,1));
        System.out.println(mcn(6,2));
        System.out.println(mcn(8,5));
        System.out.println(mcn(12,8));

    }

    public static long mcn(int m, int n) {
        int[] storage = new int[m+1];
        factorial(m,storage);
        return storage[m]/(storage[n]*storage[m-n]);

    }

    static public int[] factorial(int i, int[] storage){
        if (i == 0)
        {
            storage[i]= 1;
            return storage;
        }
        storage[i] = i*factorial((i-1),storage)[i-1];
        return storage;
    }

}
