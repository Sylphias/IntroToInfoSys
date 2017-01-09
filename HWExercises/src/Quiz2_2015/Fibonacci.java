package Quiz2_2015;

/**
 * Created by Ilya on 19/10/16.
 */
public class Fibonacci {
    // starts at 0
    public static int recurFibonacci(int n) {
        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }
        return recurFibonacci(n-1) + recurFibonacci(n-2);
    }

}
