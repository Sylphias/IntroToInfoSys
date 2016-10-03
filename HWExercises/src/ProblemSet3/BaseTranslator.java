package ProblemSet3;

import java.util.Arrays;

/**
 * Created by Ilya on 29/9/16.
 */
public class BaseTranslator {
    /**
     * Converts an array where the ith digit corresponds to (1 / baseA)^(i + 1)
     * digits[i], return an array output of size precisionB where the ith digit
     * corresponds to (1 / baseB)^(i + 1) * output[i].
     *
     * Stated in another way, digits is the fractional part of a number
     * expressed in baseA with the most significant digit first. The output is
     * the same number expressed in baseB with the most significant digit first.
     *
     * To implement, logically, you're repeatedly multiplying the number by
     * baseB and chopping off the most significant digit at each iteration:
     *
     * for (i < precisionB) {
     *   1. Keep a carry, initialize to 0.
     *   2. From RIGHT to LEFT
     *   	a. x = multiply the jth digit by baseB and add the carry
     *          b. the new jth digit is x % baseA
     *          c. carry = x / baseA
     *   3. output[i] = carry
     * }
     * If digits[j] < 0 or digits[j] >= baseA for any j, return null
     * If baseA < 2, baseB < 2, or precisionB < 1, return null
     *
     * @param digits The input array to translate. This array is not mutated.
     * @param baseA The base that the input array is expressed in.
     * @param baseB The base to translate into.
     * @param precisionB The number of digits of precision the output should
     *                   have.
     * @return An array of size precisionB expressing digits in baseB.
     */

    //Test case 1: 0 1, ans : 25
    //Test case 8: 1 , ans : 3333333
    // Test case 9: 1 2 3 4 5 6 , ans 3 17 15 9 9 14 13 10 19 2
    public static int[] convertBase(int[] digits, int baseA,
                                   int baseB, int precisionB) {
        if(baseA < 2 || baseB <2 || precisionB <1){
        return null;
        }
        int []output = new int[precisionB];
        for (int i = 0 ; i < precisionB ; i ++) {
            int x;
            int carry = 0;
            for (int j = digits.length-1; j >= 0 ; j --){
                if (digits[j] < 0 || digits[j] >= baseA){
                    return null;
                }
                x = (digits[j] * baseB) +carry;
                digits[j] =  x%baseA;
                carry = x/baseA;
            }
            output[i]=carry;

        }
        return output;
    }

}
