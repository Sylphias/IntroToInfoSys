package quiz1;
/**
 * Created by Ilya on 26/9/16.
 */import java.util.HashMap;
public class Test {
    public static void main(String[]args){
//        Rect r1 = new Rect(); System.out.println(r1);
//        System.out.println(r1.getArea());
//        Rect r2 = new Rect(2, 12); // width, height
//        System.out.println(r2);
//        System.out.println(r2.getArea());
//        System.out.println(divisible("1v3"));
//        System.out.println(divisible("2P6"));

        int [] f = new int [5];
        f[0] = 2;
        f[1] = 5;
        int [] g = {1, 3, 7};
        mergeSortedArray(f, 2, g, 3);
    }

    public static boolean divisible(String x){
        // convert to decimal
        HashMap dict = letterMap();
        double decimal = 0.0;
        for(int i = 0; i< x.length() ; i ++){
            double pos = Math.pow(62,i);
            int decvalue = (int) dict.get(x.charAt(i));
            decimal += decvalue * pos;
        }
        if (decimal%61 == 0){
            return true;
        }
        else {
            return false;
        }
    }
    // Terrible implementation, will fix
    public static HashMap letterMap(){
        String alph="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        HashMap<Character,Integer> rawr = new HashMap<Character, Integer>();
        for (int i = 0; i<62 ; i++){
            rawr.put(alph.charAt(i),i);
        }
        return rawr;
    }
    // O(n+m)
    public static int[] mergeSortedArray(int[] A, int m, int[] B, int n ){
        int index = m+n;
        m--;
        n--;
        for (int i = index-1; i>=0; i--) {
            if (m == -1) {
                A[i] = B[n];
                n--;
            } else if (n == -1) {
                A[i] = A[m];
                m--;
            }
            switch(n,m)
            if (n != -1 && m != -1) {
                if (A[m] > B[n]) {
                    A[i] = A[m];
                    m--;
                } else if (A[m] == B[n]) {
                    A[i] = A[m];
                    i--;
                    A[i] = B[n];
                    m--;
                    n--;
                } else if (A[m] < B[n]) {
                    A[i] = B[n];
                    n--;
                }
            }
        }

        return A;
    }

}
