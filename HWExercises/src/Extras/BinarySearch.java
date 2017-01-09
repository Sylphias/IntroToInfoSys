package Extras;

/**
 * Created by Ilya on 20/10/16.
 */
public class BinarySearch {
    public static int binsearch(int [] A, int n, int l, int r) {
        if (l == r) {
            if (A[l] == n) return l;
            else return -1; //not found
        }
        else {
            int mid = (l+r) / 2;
            if (n == A[mid]) return mid;
            else {
                if (n < A[mid]) return binsearch(A, n, l, mid-1);
                else return binsearch (A, n, mid+1, r);
            }
        }
    }
}
