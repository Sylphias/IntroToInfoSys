package ProblemSet2;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Ilya on 19/9/16.
 */
public class StringOperation {
    // if you do a standard loop and compare method, best efficiency you can get is O(n^2).
    // But if you use a hashmap, you can get a O(n)(worst case) efficiency.
    // The string class provides a hashmap by default through the method contains().
    // But I guess if this is a assignment we must implement our own.
    public static boolean isAllCharacterUnique(String sIn) {
        boolean [] hasChar= new boolean[128];
        char [] ch_array = sIn.toCharArray();
        for(int i =0 ; i < sIn.length(); i++){
            if(hasChar[(int)ch_array[i]] == false ){
                hasChar[(int)ch_array[i]] = true;
            }
            else{
                return false;
            }
        }
        return true;
    }
    public static boolean isPermutation(String sIn1, String sIn2) {
        // sort the 2 arrays, not gona write my own algo. going to use the default sort which is O(nlog(n))
        char[] sorted1 = sIn1.toCharArray();
        char[] sorted2 = sIn2.toCharArray();

        if(sorted1.length != sorted2.length){
            return false;
        }

        Arrays.sort(sorted1);
        Arrays.sort(sorted2);

        for(int x = 0; x < sorted1.length; x ++){
            if(sorted1[x] != sorted2[x]){
                return false;
            }
        }
        return true;

    }

}
