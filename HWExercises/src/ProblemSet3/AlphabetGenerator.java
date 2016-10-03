package ProblemSet3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Ilya on 1/10/16.
 */
public class AlphabetGenerator {
    /**
     * Given a numeric base, return a char[] that maps every digit that is
     * representable in that base to a lower-case char.
     *
     * This method will try to weight each character of the alphabet
     * proportional to their occurrence in words in a training set.
     *
     * This method should do the following to generate an alphabet:
     *   1. Count the occurrence of each character a-z in trainingData.
     *   2. Compute the probability of each character a-z by taking
     *      (occurrence / total_num_characters).
     *   3. The output generated in step (2) is a PDF of the characters in the
     *      training set. Convert this PDF into a CDF for each character.
     *   4. Multiply the CDF value of each character by the base we are
     *      converting into.
     *   5. For each index 0 <= i < base,
     *      output[i] = (the first character whose CDF * base is > i)
     *
     * A concrete example:
     * 	 0. Input = {"aaaaa..." (302 "a"s), "bbbbb..." (500 "b"s),
     *               "ccccc..." (198 "c"s)}, base = 93
     *   1. Count(a) = 302, Count(b) = 500, Count(c) = 198
     *   2. Pr(a) = 302 / 1000 = .302, Pr(b) = 500 / 1000 = .5,
     *      Pr(c) = 198 / 1000 = .198
     *   3. CDF(a) = .302, CDF(b) = .802, CDF(c) = 1
     *   4. CDF(a) * base = 28.086, CDF(b) * base = 74.586, CDF(c) * base = 93
     *   5. Output = {"a", "a", ... (29 As, indexes 0-28),
     *                "b", "b", ... (46 Bs, indexes 29-74),
     *                "c", "c", ... (18 Cs, indexes 75-92)}
     *
     * The letters should occur in lexicographically ascending order in the
     * returned array.
     *   - {"a", "b", "c", "c", "d"} is a valid output.
     *   - {"b", "c", "c", "d", "a"} is not.
     *
     * If base >= 0, the returned array should have length equal to the size of
     * the base.
     *
     * If base < 0, return null.
     *
     * If a String of trainingData has any characters outside the range a-z,
     * ignore those characters and continue.
     *
     * @param base A numeric base to get an alphabet for.
     * @param trainingData The training data from which to generate frequency
     *                     counts. This array is not mutated.
     * @return A char[] that maps every digit of the base to a char that the
     *         digit should be translated into.
     */
    public static char[] generateFrequencyAlphabet(int base, String[] trainingData) {
        if(base<0){
            return null;
        }
        HashMap<Character,Integer> alphamap = new HashMap<Character,Integer>();
        String alpha = "abcdefghijklmnopqrstuvwxyz";

        //Create a Hashmap of frequency of each letter in the training data
        for (int i = 0 ; i < trainingData.length ; i++){
            for (int j = 0 ; j < trainingData[i].length() ; j++ ){

                if(alphamap.get(trainingData[i].charAt(j)) != null){
                    int value = alphamap.get(trainingData[i].charAt(j));
                    alphamap.put(trainingData[i].charAt(j), ++value);
                }else{
                    if(alpha.contains(Character.toString(trainingData[i].charAt(j)))){
                        alphamap.put(trainingData[i].charAt(j),1);
                    }
                }
            }
        }

        // Go through each entry of the hashmap to calculate the probability
        int total = 0;
        for (int i : alphamap.values()){
            total+= i;
        }
        HashMap<Character,Double> probabilitymap = new HashMap<Character,Double>();
        for (Map.Entry<Character,Integer> entry: alphamap.entrySet()){
           probabilitymap.put(entry.getKey(),((double)entry.getValue()/(double)total));
        }
        // convert PDF to CDF


        char[] output = new char[base];

        //Convert the PDF into CDF and multiply by base, then put into output
        double cumulative = 0;
        int j = 1 ;
        boolean is_first = true;
        for(int i = 0 ; i < 26 ; i++){
            if(probabilitymap.get(alpha.charAt(i))!= null) {
                if(is_first){
                    output[0] = alpha.charAt(i);
                    is_first = false;
                }
                cumulative += (probabilitymap.get(alpha.charAt(i)) * base);
                while (j < cumulative && j!=output.length) {
                    output[j] = alpha.charAt(i);
                    j++;
                }
            }
        }
        return output;
    }
}
